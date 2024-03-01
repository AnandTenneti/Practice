package org.example;

import java.util.*;

public class CheckDuplicates {
    public static void main(String args[]) {
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "e", "f"));

//common items in listOne and listTwo
        listOne.removeAll(listTwo);

        System.out.println(listOne);

         listOne = new ArrayList<>(Arrays.asList("e", "f", "g", "h"));
         listTwo = new ArrayList<>(Arrays.asList("a", "b", "e", "f"));

        listOne.retainAll(listTwo);
        System.out.println(listOne);

    }




}
