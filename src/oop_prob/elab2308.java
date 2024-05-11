import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

abstract class Car {
    protected double price;
    protected int year;
    
    public Car(double price, int year) {
        this.price = price;
        this.year = year;
    }
    
    @Override
    public String toString() {
        String priceMod = String.format("%,.2f", calculateSalePrice());
        String year = String.valueOf(this.year);
        return "Price: " + priceMod + " VND | Year: " + year;

    }

    public abstract double calculateSalePrice();
}

class SportCar extends Car {
    public SportCar(double price, int year) {
        super(price, year);
    }
    
    @Override
    public double calculateSalePrice() {
        double salePrice = price;
        if(year > 2018) {
            salePrice *= 0.8;
        } else if(year > 2010) {
            salePrice *= 0.5;
        } else {
            salePrice *= 0.1;
        }
        return salePrice;
    }

    public String toString() {
        return super.toString();
    }
}

class ClassicCar extends Car {
    public ClassicCar(double price, int year) {
        super(price, year);
    }
    
    @Override
    public double calculateSalePrice() {
        return price * 1.12 + 2e7;
    }

    public String toString() {
        return super.toString();
    }
}

public class elab2308{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tt = Integer.parseInt(sc.nextLine());
        double maxPrice = 0;
        while(tt-->0) {
            String line = sc.nextLine();
            String[] car = line.split(" ");
            
            String type = car[0];
            double price = Double.parseDouble(car[1]);
            int year = Integer.parseInt(car[2]);

            Car c_car = createCar(type, price, year);
            double salePrice = c_car.calculateSalePrice();
            maxPrice = Math.max(maxPrice, salePrice);
            System.out.println(c_car.toString());

        }
        System.out.println("Most Expensive: " + String.format("%,.2f", maxPrice) + " VND");
    }
    private static Car createCar(String type, double price, int year) {
        if(type.equals("SC")) {
            return new SportCar(price, year);
        } else {
            return new ClassicCar(price, year);
        }
    }
}