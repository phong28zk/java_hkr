import java.util.*;

@SuppressWarnings("all")

class Person {
    protected String name;
    protected String address;

    Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person [address=" + address + ", name=" + name + "]";
    }
}

class Student extends Person {
    static int credits;
    
    public Student(String name, String address) {
        super(name, address);
    }

    public void printDetails() {
        System.out.println( name + " - " + address);
    }

    public void study() {
        credits++;
    }

    public String getCredits() {
        return "Study credits " + credits;
    }


}

public class inheritance001 {
    public static void main(String[] args) {
        Student s = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
        s.printDetails();
        System.out.println(s.getCredits());
        s.study();
        System.out.println(s.getCredits());
    }
}


