import java.util.*;

@SuppressWarnings("all")

class MyStuff {
    private String name;

    MyStuff(String name) {
        this.name = name;
        // System.out.println("My Stuff is: " + name);
    }

    public String getValue() {
        return this.name;
    }

}

public class elab2303 {
    public static void main(String[] args) {
        MyStuff m1 = new MyStuff("PC");
        MyStuff m2 = new MyStuff("PC");

        // System.out.println("Ref of m1: " + m1.hashCode());
        // System.out.println("Ref of m2: " + m2.hashCode());
        // System.out.println("Value of m1: " + m1.getValue());
        // System.out.println("Value of m2: " + m2.getValue());

        if (m1.getValue().equals(m2.getValue())) {
            System.out.println("value compared: same");
        } else {
            System.out.println("value compared: different");
        }

        if (m1.equals(m2)) {
            System.out.println("reference compared: same");
        } else {
            System.out.println("reference compared: different");
        }

    }
}