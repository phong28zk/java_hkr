import java.util.*;
import java.lang.*;
import java.io.*;

@SuppressWarnings("all")

class Person {
    String name;
    String address;

    Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " - " + address;
    }

}

public class oop015
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t-->0) {
			String a = sc.nextLine();
            String b = sc.nextLine();

            Person p = new Person(a,b);
            System.out.println(p.toString());

		}


    }
} 
