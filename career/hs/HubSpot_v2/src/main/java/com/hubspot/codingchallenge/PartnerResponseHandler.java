package com.hubspot.codingchallenge;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class PartnerResponseHandler {
    int status;
    String responseBody;

    PartnerResponseHandler(int status, String responseBody) {
        this.status = status;
        this.responseBody = responseBody;
    }

}
