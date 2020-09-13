package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Addition;
import io.swagger.server.api.model.AdditionResult;
import io.swagger.server.api.MainApiException;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

import java.util.List;
import java.util.Map;

public interface SumApi  {
    //sumValues
    void sumValues(Addition addition, Handler<AsyncResult<AdditionResult>> handler);
    
}
