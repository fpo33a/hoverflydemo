package io.swagger.server.api.verticle;

import io.swagger.server.api.MainApiException;
import io.swagger.server.api.model.Upper;
import io.swagger.server.api.model.Value;

public final class UpperApiException extends MainApiException {
    public UpperApiException(int statusCode, String statusMessage) {
        super(statusCode, statusMessage);
    }
    
    public static final UpperApiException Upper_upperCase_400_Exception = new UpperApiException(400, "Invalid parameters");
    public static final UpperApiException Upper_upperCase_404_Exception = new UpperApiException(404, "parameters not found");
    public static final UpperApiException Upper_upperCase_405_Exception = new UpperApiException(405, "Validation exception");
    

}