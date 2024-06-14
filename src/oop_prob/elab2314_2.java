import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class Planet {
    private double khoiLuong;
    private double banKinh;
    public double G = 6.67408E-11;

    public Planet(double khoiLuong, double banKinh) {
        this.khoiLuong = khoiLuong;
        this.banKinh = banKinh;
    }

    public double trongLucBeMat() {
        return khoiLuong*G/(banKinh*banKinh);
    }

    public double sWeight(double weight) {
        return weight/9.804239266*trongLucBeMat();
    }
}

public class elab2314_2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        double khoiLuong = Double.parseDouble(sc.nextLine());
        double banKinh = Double.parseDouble(sc.nextLine());
        Planet p = new Planet(khoiLuong, banKinh);

        Double userWeight = Double.parseDouble(sc.nextLine());
        double gEarth = 9.804239266;
        System.out.printf("Your weight on %s is %.2f", name, p.sWeight(userWeight));
    }
}