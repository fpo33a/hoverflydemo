package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Addition;
import io.swagger.server.api.model.AdditionResult;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;

public class SumApiImpl implements SumApi {
    @Override
    public void sumValues(Addition addition, Handler<AsyncResult<AdditionResult>> handler) {
        int field1 = addition.getField1();
        int field2 = addition.getField2();
        System.out.println( " sum : result : "+(field1+field2));
        handler.handle(Future.succeededFuture(new AdditionResult(field1+field2)));
    }
}
