import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

abstract class Car {
    protected double price;
    protected int year;
    Car(double price, int year) {
        this.price = price;
        this.year = year;
    }

    public String toString() {
        return String.format("Price: %,.2f VND | Year: %d", calculateSalePrice(), year);
    }

    abstract double calculateSalePrice();
}

class SportCar extends Car {
    SportCar(double price, int year) {
        super(price, year);
    }

    double calculateSalePrice() {
        double salePrice = price;
        if(year>2018) salePrice = price*0.8;
        else if(year>2010) salePrice = price*0.5;
        else salePrice = price*0.1;
        return salePrice;
    }
}

class ClassicCar extends Car {
    ClassicCar(double price, int year) {
        super(price, year);
    }

    double calculateSalePrice() {
        return 1.12*price+2E7;
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Scanner getScanner() {
        return sc;
    }
    public static void main(String args[]) {
        Scanner sc = getScanner();
        int tt = Integer.parseInt(sc.nextLine());
        double maxPrice = -1;
        while(tt-->0) {
            String[] line = sc.nextLine().split(" ");
            String type = line[0];
            double price = Double.parseDouble(line[1]);
            int year = Integer.parseInt(line[2]);
            Car c = createCar(type, price, year);
            System.out.println(c.toString());
            maxPrice = Math.max(maxPrice, c.calculateSalePrice());
        }
        System.out.printf("Most Expensive: %,.2f VND", maxPrice);
        
    }
    private static Car createCar(String type, double price, int year) {
        if(type.equals("SC")) {
            return new SportCar(price, year);
        } else {
            return new ClassicCar(price, year);
        }
    }
}