package org.example;

public class FinalClass {
    //final
    int speedLimit=400;

    //final
    void  run() {
        speedLimit=150;
    }
    class test extends  FinalClass{
        void run() {

        }
    }
    public static void main(String args[]) {
        FinalClass finalValue = new FinalClass();
        finalValue.run();
    }
}
