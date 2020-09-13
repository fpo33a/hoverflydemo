package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Addition;
import io.swagger.server.api.model.AdditionResult;
import io.swagger.server.api.MainApiException;

public final class SumApiException extends MainApiException {
    public SumApiException(int statusCode, String statusMessage) {
        super(statusCode, statusMessage);
    }
    
    public static final SumApiException Sum_sumValues_400_Exception = new SumApiException(400, "Invalid parameters");
    public static final SumApiException Sum_sumValues_404_Exception = new SumApiException(404, "parameters not found");
    public static final SumApiException Sum_sumValues_405_Exception = new SumApiException(405, "Validation exception");
    

}