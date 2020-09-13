package io.swagger.server.api.verticle;

import io.swagger.server.api.MainApiException;
import io.swagger.server.api.model.Upper;
import io.swagger.server.api.model.Value;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

import java.util.List;
import java.util.Map;

public interface UpperApi  {
    //upperCase
    void upperCase(Value stringObject, Handler<AsyncResult<Upper>> handler);
    
}
