package org.example;
import org.apache.commons.lang3.RandomStringUtils;


public class TestRandom {
    public static void main(String args[]) {
        String randomEmail = RandomStringUtils.randomAlphabetic(7);
        System.out.println(randomEmail+"@example.com");
    }
    public void testDataGeneration() {

    }


}
