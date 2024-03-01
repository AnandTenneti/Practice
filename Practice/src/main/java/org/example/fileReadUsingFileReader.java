package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class fileReadUsingFileReader {
    public static void main(String args[]) throws IOException {
        File file = new File("/Users/tennetikiran/IdeaProjects/Practice/src/main/resources/TestFile.txt");
        FileReader fr = new FileReader(file);
        int i;
        while(( i = fr.read())!=-1) {
            System.out.println((char) i);
        }


    }
}
