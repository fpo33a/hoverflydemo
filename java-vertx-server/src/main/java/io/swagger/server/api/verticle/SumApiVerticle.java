package io.swagger.server.api.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import io.swagger.server.api.model.Addition;
import io.swagger.server.api.model.AdditionResult;
import io.swagger.server.api.MainApiException;

import java.util.List;
import java.util.Map;

public class SumApiVerticle extends AbstractVerticle {
    final static Logger LOGGER = LoggerFactory.getLogger(SumApiVerticle.class);

    final static String SUMVALUES_SERVICE_ID = "sumValues";

    final SumApi service;

    public SumApiVerticle() {
        try {
            Class serviceImplClass = getClass().getClassLoader().loadClass("io.swagger.server.api.verticle.SumApiImpl");
            service = (SumApi) serviceImplClass.newInstance();
        } catch (Exception e) {
            logUnexpectedError("SumApiVerticle constructor", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void start() throws Exception {

        //Consumer for sumValues
        vertx.eventBus().<JsonObject>consumer(SUMVALUES_SERVICE_ID).handler(message -> {
            try {
                System.out.println("sum : I have received a message: " + message.body());

                // Workaround for #allParams section clearing the vendorExtensions map
                String serviceId = "sumValues";
                JsonObject additionParam = message.body().getJsonObject("Addition");
                if (additionParam == null) {
                    manageError(message, new MainApiException(400, "Addition is required"), serviceId);
                    return;
                }
                Addition addition = Json.mapper.readValue(additionParam.encode(), Addition.class);
                service.sumValues(addition, result -> {
                    if (result.succeeded()) {
                        DeliveryOptions options = new DeliveryOptions();
                        options.addHeader("content-type", "application/json");
                        message.reply(new JsonObject(Json.encode(result.result())).encodePrettily(),options);
                    }
                    else {
                        Throwable cause = result.cause();
                        manageError(message, cause, "sumValues");
                    }
                });
            } catch (Exception e) {
                logUnexpectedError("sumValues", e);
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
