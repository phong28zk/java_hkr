import java.lang.*;
import java.io.*;
import java.util.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class exception004 {
    public static void checkValid(String name, int age) throws Exception{
        if(name.equals("") || name.length() > 40) {
            throw new Exception("Name is not valid");
        } else if(age<0 || age>120) {
            throw new Exception("Age is not valid");
        } else {
            System.out.printf("Name: %s--Age:%d%n", name, age);
        }
    }
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0) {
            String name = sc.nextLine();
            int age = Integer.parseInt(sc.nextLine());

            Person p = new Person(name, age);
            try {
                checkValid(p.name, p.age);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}