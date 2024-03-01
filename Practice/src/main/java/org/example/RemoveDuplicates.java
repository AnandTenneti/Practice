package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.RandomAccess;

public class RemoveDuplicates {

    public static  <T> ArrayList<T>  removeDuplicates(ArrayList<T> list) {
        ArrayList<T> newList = new ArrayList<T>();
        for(T e: list) {
            if(!newList.contains(e)) {
                newList.add(e);
            }
        }
return newList;
}
public static void main(String args[]) {
        int[] newArray = new int[20];
        int[] array1 = {0,1,2,3,4};
    System.out.println(array1);
    ArrayList<Integer>
            list = new ArrayList<>(
            Arrays
                    .asList(1, 10, 1, 2, 2, 3, 3, 10, 3, 4, 5, 5));
    ArrayList<String> list1 = new ArrayList<>(
            Arrays
                    .asList("Anand", "Kiran", "Tenneti", "Abhinav", "Anurag", "Tenneti", "Tenneti"));

    // Print the Arraylist
    System.out.println("ArrayList with duplicates: "
            + list);
    ArrayList<Integer>
            newList = removeDuplicates(list);
    ArrayList<String>
            newList1 = removeDuplicates(list1);

    // Print the ArrayList with duplicates removed 
    System.out.println("ArrayList with duplicates removed: "
            + newList);
    System.out.println("ArrayList with duplicates removed: "
            + newList1);
}
}
