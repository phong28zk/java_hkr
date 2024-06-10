import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

abstract class Shape {
    String name;
    Shape(String name) {
        this.name = name;
    }
    abstract double calculateArea();
    
    public void displayInfo() {
        String res = String.format("Shape:%s|Area:%.2f", name, calculateArea());
        System.out.println(res);
    }
}

class Circle extends Shape {
    String name;
    double radius;
    Circle(String name) {
        super(name);
	};
    void setRadius(double radius) {
        this.radius = radius;
    }
    double calculateArea() {
		return Math.PI * radius * radius;        
    }
    
}

class Rectangle extends Shape {
    String name;
    double width;
    double length;
    Rectangle(String name) {
        super(name);
	};
    void setWidth(double width) {
        this.width = width;
    }
    void setLength(double length) {
        this.length = length;
    }
    double calculateArea() {
		return width * length;        
    }
    
}

public class oop005 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tt = Integer.parseInt(sc.nextLine());
        while(tt-->0) {
            String line = sc.nextLine();
            String[] inp = line.split(" ");
            String type = inp[0];
        	if(type.equals("Rectangle")) {
                double w = Double.parseDouble(inp[1]);
                double l = Double.parseDouble(inp[2]);
                Rectangle r = new Rectangle("Rectangle");
                r.setWidth(w);
                r.setLength(l);
                r.displayInfo();
            } else {
                double r = Double.parseDouble(inp[1]);
                Circle c = new Circle("Circle");
                c.setRadius(r);
                c.displayInfo();
            }
        }
        
    }
}