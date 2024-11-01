package Models;

public class Person implements HasID {
    protected Integer ID;
    protected int age;
    protected String name;

    public Person(Integer ID, int age, String name) {
        this.ID = ID;
        this.age = age;
        this.name = name;
    }
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
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

    @Override
    public Integer getId() {
        return this.ID;
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", Age: " + age + ", Name: " + name;
    }
}
