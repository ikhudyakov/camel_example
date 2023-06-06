package com.example.camel_example.utility;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class JsonValidation {

    public boolean validate(String order) {
        JSONObject jsonSchema = null;
        JSONObject jsonData = null;
        InputStream is;
        Schema schema;

        is = getClass().getClassLoader().getResourceAsStream("static/json-schema.json");

        if (is != null) {
            jsonSchema = new JSONObject(new JSONTokener(is));
            jsonData = new JSONObject(new JSONTokener(String.valueOf(order)));
        }


        schema = SchemaLoader.load(jsonSchema);
        try {
            schema.validate(jsonData);
        } catch (ValidationException e) {
            System.out.println("schema validation failed: ");
            System.out.println(e.getMessage());
            return false;
        }
        System.out.println("schema validated successfully");
        return true;
    }
}


