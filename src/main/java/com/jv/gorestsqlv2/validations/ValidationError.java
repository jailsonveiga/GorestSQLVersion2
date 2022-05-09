package com.jv.gorestsqlv2.validations;

import org.json.JSONObject;

import java.util.HashMap;

public class ValidationError {
    private final HashMap<String, String> errors = new HashMap<>();

    public void addError(String Key, String errorMsg) {
        errors.put(Key, errorMsg);
    }

    public boolean hasError() {
        return errors.size() != 0;
    }

    public String toJSONString() {
        return new JSONObject(errors).toString();
    }
}
