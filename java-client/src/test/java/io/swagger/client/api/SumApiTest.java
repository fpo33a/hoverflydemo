/*
 * Swagger demo API
 * This is demo API.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: frank_polet@hotmail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.specto.hoverfly.junit.core.HoverflyConfig;
import io.specto.hoverfly.junit.rule.HoverflyRule;
import io.swagger.client.ApiException;
import io.swagger.client.model.Addition;
import io.swagger.client.model.AdditionResult;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * API tests for SumApi
 */
//@Ignore
public class SumApiTest {

    private final SumApi api = new SumApi();

    
    /**
     * add two integers
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */

    @ClassRule
    public static HoverflyRule hoverflyRule = HoverflyRule
            .inCaptureOrSimulationMode("c:\\frank\\hoverflydemo\\sum.json"
                                        , HoverflyConfig.configs().proxyLocalHost());//.printSimulationData();

    @Test
    public void sumValuesTest() throws ApiException {
        Addition addition = new Addition();
        addition.setField1(10);
        addition.setField2(22);
        AdditionResult response = api.sumValues(addition);

        System.out.println(" ---> sum : response : "+response.getResult());

        // TODO: test validations
        assertEquals(new Integer(32),response.getResult());
    }
    
}
