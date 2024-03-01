package org.example;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public class JSONArrayListDemo {
    public static void main(String args[]) {
        String s = "{\"name\":\"sonoo\",\"salary\":600000.0,\"age\":27}";
        Object object = JSONValue.parse(s);
        JSONObject jsonObject = (JSONObject) object;
        String name = (String) jsonObject.get("name");
        double salary = (Double) jsonObject.get("salary");
        long age = (Long) jsonObject.get("age");
        System.out.println(name + " " + salary + " "+ age);
        int[] array1 = new int[10];
        int[] array2 = {0,1,2,3,4};
        for(int i =0; i <array2.length; i++) {
            System.out.println(array2[i]);
        }
    }
}
