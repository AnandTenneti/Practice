package org.example;

public class DuplicatesInArray {

    public static void main(String args[]) {
        int[] arr = {1, 4, 6, 5, 2, 1, 7, 2};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.print(arr[i]+",");
                }
            }

        }
    }
}

