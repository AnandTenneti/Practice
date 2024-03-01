package org.example;

import org.json.simple.JSONObject;

public class JsonObjectExample {
    public static void main(String args[]) {
        JSONObject obj = new JSONObject();
        obj.put("name","Anand");
        obj.put("age",27);
        obj.put("salary",60000);
        System.out.println(obj);
    }

}
