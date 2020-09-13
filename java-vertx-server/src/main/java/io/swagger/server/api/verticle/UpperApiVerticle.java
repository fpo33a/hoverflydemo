package io.swagger.server.api.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import io.swagger.server.api.MainApiException;
import io.swagger.server.api.model.Upper;
import io.swagger.server.api.model.Value;

import java.util.List;
import java.util.Map;

public class UpperApiVerticle extends AbstractVerticle {
    final static Logger LOGGER = LoggerFactory.getLogger(UpperApiVerticle.class);

    final static String UPPERCASE_SERVICE_ID = "upperCase";

    final UpperApi service;

    public UpperApiVerticle() {
        try {
            Class serviceImplClass = getClass().getClassLoader().loadClass("io.swagger.server.api.verticle.UpperApiImpl");
            service = (UpperApi) serviceImplClass.newInstance();
        } catch (Exception e) {
            logUnexpectedError("UpperApiVerticle constructor", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void start() throws Exception {

        //Consumer for upperCase
        vertx.eventBus().<JsonObject>consumer(UPPERCASE_SERVICE_ID).handler(message -> {
            try {
                System.out.println("upper : I have received a message: " + message.body());
                // Workaround for #allParams section clearing the vendorExtensions map
                String serviceId = "upperCase";
                JsonObject stringObjectParam = message.body().getJsonObject("stringObject");
                if (stringObjectParam == null) {
                    manageError(message, new MainApiException(400, "stringObject is required"), serviceId);
                    return;
                }
                Value stringObject = Json.mapper.readValue(stringObjectParam.encode(), Value.class);
                service.upperCase(stringObject, result -> {
                    if (result.succeeded()) {
                        DeliveryOptions options = new DeliveryOptions();
                        options.addHeader("content-type", "application/json");
                        message.reply(new JsonObject(Json.encode(result.result())).encodePrettily(),options);
                    }
                    else {
                        Throwable cause = result.cause();
                        manageError(message, cause, "upperCase");
                    }
                });
            } catch (Exception e) {
                logUnexpectedError("upperCase", e);
                message.fail(MainApiException.INTERNAL_SERVER_ERROR.getStatusCode(), MainApiException.INTERNAL_SERVER_ERROR.getStatusMessage());
            }
        });

    }

    private void manageError(Message<JsonObject> message, Throwable cause, String serviceName) {
        int code = MainApiException.INTERNAL_SERVER_ERROR.getStatusCode();
        String statusMessage = MainApiException.INTERNAL_SERVER_ERROR.getStatusMessage();
        if (cause instanceof MainApiException) {
            code = ((MainApiException) cause).getStatusCode();
            statusMessage = ((MainApiException) cause).getStatusMessage();
        } else {
            logUnexpectedError(serviceName, cause);
        }

        message.fail(code, statusMessage);
    }

    private void logUnexpectedError(String serviceName, Throwable cause) {
        LOGGER.error("Unexpected error in " + serviceName, cause);
    }
}
