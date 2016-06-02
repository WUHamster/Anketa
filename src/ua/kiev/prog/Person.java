package ua.kiev.prog;

/**
 * Created by WUHamster on 02.06.2016.
 */
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private boolean isSingle;
    private boolean haveKids;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSingle(boolean single) {
        isSingle = single;
    }

    public void setHaveKids(boolean haveKids) {
        this.haveKids = haveKids;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean isSingle() {
        return isSingle;
    }

    public boolean isHaveKids() {
        return haveKids;
    }
}
