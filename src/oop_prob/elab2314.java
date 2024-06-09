import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class Planet {
    private double weight;
    private double rad;
   	public double G;
    
    public Planet(double weight, double rad) {
        this.weight = weight;
        this.rad = rad;
    }
    
    public double surfaceGravity() {
        return weight * G/(rad*rad);
    }
    
    public double surfaceWeight(double weight) {
        return (surfaceGravity() / 9.802775697614821) * weight;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        String planet = sc.nextLine();
        String weight = sc.nextDouble();
        String rad = sc.nextDouble();
        String weightPeople = sc.nextDouble();
        Planet p = new Planet(weight, rad);
        System.out.println("Your weight on " + hanhTinh + " is " + String.format("%.2f", ht.khoiLuongBeMat(khoiLuongTD)));
    }
}