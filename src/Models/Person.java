package Models;

public class Person {
    int ID, age;
    String name;

    public Person(int ID, int age, String name) {
        this.ID = ID;
        this.age = age;
        this.name = name;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
