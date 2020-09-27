
package io.swagger.client.api;

import io.specto.hoverfly.junit.core.HoverflyConfig;
import io.specto.hoverfly.junit.rule.HoverflyRule;
import io.swagger.client.ApiException;
import io.swagger.client.model.Upper;
import io.swagger.client.model.Value;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.specto.hoverfly.junit.core.SimulationSource.dsl;
import static io.specto.hoverfly.junit.dsl.HoverflyDsl.service;
import static io.specto.hoverfly.junit.dsl.ResponseCreators.success;
import static io.specto.hoverfly.junit.dsl.matchers.HoverflyMatchers.any;
import static io.specto.hoverfly.junit.dsl.matchers.HoverflyMatchers.startsWith;
import static org.junit.Assert.assertEquals;

/**
 * API tests for UpperApi
 */
//@Ignore
public class UpperApiSimulationTest {

    private final UpperApi api = new UpperApi();


    /**
     * convert input to uppercase
     *
     *
     *
     * @throws ApiException
     *          if the Api call fails
     */

    @ClassRule
    public static HoverflyRule hoverflyRule = HoverflyRule
            .inSimulationMode(dsl(service("http://localhost:8095")
                    .post("/v2/upper")
                    .anyBody()
                    .willReturn(success("{\"upper\":\"THIS IS ANOTHER TEST\"}", "application/json")))
                    , HoverflyConfig.configs().proxyLocalHost());

    @Test
    public void upperSimulationCaseTest() throws ApiException {
        Value stringObject = new Value ();
        stringObject.setValue("this is another test");
        Upper response = api.upperCase(stringObject);

        System.out.println(" ---> ANOTHER upper : result : "+response.getUpper());

        // TODO: test validations
        assertEquals("THIS IS ANOTHER TEST",response.getUpper().toString());
    }

}
