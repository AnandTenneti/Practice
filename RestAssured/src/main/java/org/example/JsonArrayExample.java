package org.example;

import org.json.simple.JSONArray;


public class JsonArrayExample {

    public static void main(String args[]) {
        JSONArray arr = new JSONArray();
        arr.add("test");
        arr.add("28");
        arr.add("10000");
        System.out.println(arr);
    }
}
