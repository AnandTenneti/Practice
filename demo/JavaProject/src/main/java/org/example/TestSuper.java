package org.example;

class Person {
    int id;
    String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

}

class Employee extends Person {
    float salary;

    Employee(int id, String name, float salary) {
        super(id, name);
        this.salary = salary;
    }

    void display() {
        System.out.println(id + " " + name + " " + salary);
    }


}

public class TestSuper {
    public static void main(String args[]) {
        Employee employee = new Employee(1, "ankit", 35000);
        employee.display();
    }
}
