package com.qa.support;

import io.restassured.RestAssured;

/**
 * Created by sulari.dulsara on 27/6/2018 .
 */
public class HttpResponseCode {
    public static int httpResponseCodeViaGet(String url) {
        return RestAssured.get(url).statusCode();
    }

    public static int httpResponseCodeViaPost(String url) {
        return RestAssured.post(url).statusCode();
    }
}
