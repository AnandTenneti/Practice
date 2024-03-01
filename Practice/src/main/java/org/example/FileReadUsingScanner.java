package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class FileReadUsingScanner {
    public static void main(String args[]) throws IOException {
        File file = new File("/Users/tennetikiran/IdeaProjects/Practice/src/main/resources/TestFile.txt");

        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()) {
            System.out.println(sc.nextLine());

        }

    }
}
