package org.example;

import org.json.simple.JSONObject;

import java.io.PrintStream;

public class JSONToStringExample {
    public static void main(String args[]) {

        JSONObject obj = new JSONObject();
        obj.put("firstname", "Anand");
        obj.put("middlename", "Kiran");
        obj.put("lastname", "Tenneti");
        obj.put("age", 30);
        obj.put("place", "Bangalore");
        obj.put("mobile", 99590);

        System.out.println(obj);
        int age = (Integer) obj.get("age");
        System.out.println(age);
        int mobile = (Integer) obj.get("mobile");
        System.out.println("Mobile number is " + mobile);
        System.out.println(obj.toString());
    }
}
