package org.example;

public class ThisKeyword {

    ThisKeyword() {
       this("Fido", 1);
    }
    ThisKeyword(String name, int age) {
        this.name=name;
        this.age=age;
    }
    private int age;
    private String name;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age=age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }

    public static void main(String args[]) {
        ThisKeyword obj = new ThisKeyword();
        obj.setName("Anand");
        obj.setAge(30);
        System.out.println(obj.getName());
        System.out.println(obj.getAge());
    }
}
