import java.util.*;

@SuppressWarnings("all")

interface Pet {
    String getName();
    void setName(String name);
    void play();
}

class Animal {
    protected int legs;
    
    Animal(int legs) {
        this.legs = legs;
    }

    void walk() {
        System.out.println("This animal walks on " + legs + " legs.");
    }

    void eat() {
    }
}

class Spider extends Animal {
    Spider() {
        super(8);
    }

    void eat() {
        System.out.println("The spider eats a fly.");
    }

    public void walk() {
        super.walk();
    }
}

class Fish extends Animal implements Pet {
    Fish() {
        super(0);
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play() {
        System.out.println("Fish swim in their tanks all day.");
    }

    public void walk() {
        super.walk();
        System.out.println("Fish, of course, can't walk; they swim.");
    }

    public void eat() {
        System.out.println("Fish eat pond scum.");
    }

}

class Cat extends Animal implements Pet {
    Cat() {
        super(4);
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play() {
        System.out.println(getName() + " likes to play with string.");
    }

    public void eat() {
        System.out.println("Cats like to eat spiders and mice.");
    }

    public void walk() {
        super.walk();
    }

}

public class interface006 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Fish f1 = new Fish();
        Cat c1 = new Cat();
        c1.setName("Fluffy");
        Spider s1 = new Spider();

        f1.play();
        f1.walk();

        c1.play();
        c1.eat();
        s1.eat();

        c1.walk();
        s1.walk();

        
    }
}