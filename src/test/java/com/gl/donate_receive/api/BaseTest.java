package com.gl.donate_receive.api;

import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.baseURI;
public class BaseTest {
    @BeforeMethod
    public void setBaseURI() {
         baseURI = "http://localhost:8080";
    }
    JSONObject request = new JSONObject();
}
