package org.lld.prep.json_parse;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Parser {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        String path = "/Users/sunnyranjan/Documents/Prep/src/main/java/org/lld/prep/json_parse/sample.json";
        try {
            User parsedObj = objectMapper.readValue(new File(path), User.class);
            System.out.println(parsedObj);
        }catch (Exception e) {
            System.out.println("Got exception!");
        }
    }
}
