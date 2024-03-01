package org.example;



import java.util.ArrayList;
import java.util.Collections;

public class CollectionTest {

    public static void main(String args[]) {
        ArrayList<String> al = new ArrayList();
        al.add("a");
        al.add("b");
        al.add("c");
        al.add("d");
        al.add("e");
        al.add("f");
        System.out.println(al);
        ArrayList<String> al1 = new ArrayList<>(5);
        Collections.addAll(al1, "a","b","c","d","e");
        al1.add("f");
        int a[] = new int[3];
        a[0]=-1;
        a[1]= 0;
        a[2]=1;
       // a[3]=2;
        for(int i =0; i <a.length; i++) {
            System.out.print(a[i] + "\t");
        }

        System.out.println(al1);
    }
}
