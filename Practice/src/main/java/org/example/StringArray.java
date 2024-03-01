package org.example;

public class StringArray {
    public static void main(String args[]) {

        String[] strAr1 = new String[]{"Ani", "Sam", "Joe"}; //inline initialization
        String[] strAr2 = {"Annie", "Sam", "Joe"};
        String[] strAr3 = new String[3]; //Initialization after declaration with specific size
        int k =0;
        for(int i =0; i <strAr1.length; i++)
            for(int j=0; j<strAr2.length; j++) {
                if(strAr1[i]==strAr2[j]) {
                    strAr3[k] = strAr1[i];
                    k++;
                }
            }
        //Matching Array elements
        for(k =0; k <strAr3.length; k++) {
            if(strAr3[k]!=null) {
                System.out.println(strAr3[k]);
            }
        }

    }

}
