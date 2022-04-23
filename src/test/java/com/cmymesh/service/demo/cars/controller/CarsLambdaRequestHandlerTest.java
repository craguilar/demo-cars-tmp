package com.cmymesh.service.demo.cars.controller;

import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.cmymesh.service.demo.cars.model.pojo.Car;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsLambdaRequestHandlerTest {

  private static final String EXPECTED_CONTENT_TYPE = "application/json";
  private static final String EXPECTED_RESPONSE_VALUE = "Elantra";
  private static final int EXPECTED_STATUS_CODE_SUCCESS = 200;

  // A mock class for com.amazonaws.services.lambda.runtime.Context
  private final MockLambdaContext mockLambdaContext = new MockLambdaContext();
  private final Object input = new Object();

  /**
   * Initializing variables before we run the tests.
   * Use @BeforeAll for initializing static variables at the start of the test
   * class execution.
   * Use @BeforeEach for initializing variables before each test is run.
   */
  @BeforeAll
  static void setup() {
    // Use as needed.
  }

  /**
   * De-initializing variables after we run the tests.
   * Use @AfterAll for de-initializing static variables at the end of the test
   * class execution.
   * Use @AfterEach for de-initializing variables at the end of each test.
   */
  @AfterAll
  static void tearDown() {
    // Use as needed.
  }

  /**
   * Basic test to verify the result obtained when calling
   * {@link HelloWorldHandler} successfully.
   */
  @Test
  @DisplayName("Basic test for request handler")
  void testHandleRequest() {
    // TODO: Implement lambda Controller test
    //Car response = (Car) new CarsLambdaRequestHandler().handleRequest(input, mockLambdaContext);

    // Verify the response obtained matches the values we expect.
    //assertEquals(EXPECTED_RESPONSE_VALUE, jsonObjectFromResponse.get("description"));
    //assertEquals(EXPECTED_CONTENT_TYPE, response.getHeaders().get("Content-Type"));
    //assertEquals(EXPECTED_STATUS_CODE_SUCCESS, response.getStatusCode());
  }
}
