import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

interface Pet {
    public String getName();
    public void setName(String name);
    public void play();
}

abstract class Animal {
    int legs;
    Animal(int legs) {
        this.legs = legs;
    }
    
    public int getLegs() {
        return legs;
    }
    void walk() {
        String res = String.format("This animal walks on %d legs", getLegs());
        System.out.println(res);
    }
    abstract public void eat();
}

class Spider extends Animal {
    Spider() {
        super(8);
    }
    public void walk() {
        super.walk();
    }
    public void eat() {
        System.out.println("The spider eats a fly.");
    }
}

class Fish extends Animal implements Pet {
    public Fish() {
        super(0);
    };
    
    private String name;
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public void play() {
        System.out.println("Fish swim in their tanks all day.");
    }
    @Override
    public void walk() {
        super.walk();
        System.out.println("Fish, of course, can't walk; they swim.");
    }
	@Override
	public void eat() {
        System.out.println("Fish eat pond scum.");
    }
}

class Cat extends Animal implements Pet {
    private String name;
    
    public Cat(String name) {
        super(4);
        this.name = name;
    }
    public Cat() {
        super(4);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public void play() {
        String res = String.format("%s likes to play with string.", getName());
        System.out.println(res);
    }
    @Override
    public void walk() {
        super.walk();
    }
	@Override
	public void eat() {
        System.out.println("Cats like to eat spiders and mice.");
    }
}
                           
public class inher006 {
    public static void main(String args[]) {
        Fish f = new Fish();
        Spider s = new Spider();
        Cat c = new Cat("Fluffy");
        f.play();
        f.walk();
        c.play();
        c.eat();
        s.eat();
        c.walk();
        s.walk();
    }
}