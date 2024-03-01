package org.example;

import java.util.HashMap;

public class Occurrence {
    public static void main(String args[]) {
        String str = "aabbbc";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                count++;
                map.replace(ch, count);
            } else {
                map.put(ch, 1);
            }
        }

        for (Character key : map.keySet()) {
            System.out.print(key + "" + map.get(key));
        }
    }
}
