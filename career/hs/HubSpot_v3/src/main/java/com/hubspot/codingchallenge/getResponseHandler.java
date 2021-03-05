package com.hubspot.codingchallenge;

public class getResponseHandler {
    int status;
    String responseBody;

    getResponseHandler(int status, String responseBody) {
        this.status = status;
        this.responseBody = responseBody;
    }

}
