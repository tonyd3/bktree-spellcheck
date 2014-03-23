package com.td.server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Response {
    private JSONObject responseObject;

    public Response(List<String> response) throws JSONException {
        this.responseObject = new JSONObject();
        JSONArray results = new JSONArray();
        results.put(response);
        this.responseObject.put("results", results);
    }

    @Override
    public String toString() {
        return responseObject.toString();
    }
}
