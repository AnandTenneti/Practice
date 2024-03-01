package org.example;


import org.json.simple.JSONArray;

public class JSONArrayDemo {

    public static void main(String args[]) {
        JSONArray arr = new JSONArray();
        arr.add("test");
        arr.add(100);
        arr.add(6000000);
        System.out.println(arr);
    }
}
