import java.util.*;

class ProductDefine {
    private String name;
    private String location;
    public int weight;

    public void Product(String name) {
        this.name = name;
        this.location = "shelf";
        this.weight = 1;
    }

    public void Product(String name, String location) {
        this.name = name;
        this.location = location;
        this.weight = 1;
    }

    public void Product(String name, int weight) {
        this.name = name;
        this.location = "shelf";
        this.weight = weight;
    }

    public void printDetails() {
        System.out.println(name + " (" + weight + "kg" + ") " + "can be found from the " + location);
    }
}

public class oop10 {
    public static void main(String[] args) {
        ProductDefine p1 = new ProductDefine();
        p1.Product("Tape measure");
        p1.printDetails();
        ProductDefine p2 = new ProductDefine();
        p2.Product("Plaster", "home improvement section");
        p2.printDetails();
        ProductDefine p3 = new ProductDefine();
        p3.Product("Tyre", 5);
        p3.printDetails();
    }
}