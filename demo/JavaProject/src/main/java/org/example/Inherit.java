package org.example;

class Parent {
    private void print() {
        System.out.println("Parent");
    }
    public void display() {
        print();
    }


        }

 class Inherit extends Parent {
    public void display() {
        System.out.println("Child");
    }

    public static void main(String args[]) {
     Parent parent = new Inherit();
        parent.display();
    }
}
