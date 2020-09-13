package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Upper;
import io.swagger.server.api.model.Value;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;

public class UpperApiImpl implements UpperApi {
    @Override
    public void upperCase(Value stringObject, Handler<AsyncResult<Upper>> handler) {
        String value = stringObject.getValue().toUpperCase();
        Upper upper = new Upper();
        upper.setUpper(value);
        System.out.println( " upper : value : "+value);
        handler.handle(Future.succeededFuture(upper));
    }
}
