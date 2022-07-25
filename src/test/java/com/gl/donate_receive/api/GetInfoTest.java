package com.gl.donate_receive.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetInfoTest extends BaseTest{
    @Test
    public void test_ResponseHeaderData_ShouldBeCorrect() {
        given().
                when().
                get("/users").
                then().
                assertThat().
                statusCode(200);
    }
}
