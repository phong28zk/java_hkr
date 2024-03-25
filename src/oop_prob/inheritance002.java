import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

@SuppressWarnings("all")

class Item {

    protected String name;
    protected double price;
    protected double discount;

    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);
        return name + " $" + df.format(price) + " (-$" + df.format(discount) + ")";
    }
}

class Employee {
    protected String name;

    public String getName() {
        return name;
    }
}

class GroceryBill {
    private Employee clerk;
    protected List<Item> receipt;
    protected double total;

    

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
        this.receipt = new ArrayList<Item>();
    }

    public void add(Item i) {
        receipt.add(i);
        total += i.getPrice();
    }

    public double getTotal() {
        return total;
    }

    public void printReceipt() {
        System.out.println("items:");

        for(Item i : receipt) {
            System.out.println("   " + i);
        }
    }

    public String DecimalFormat(double value) {
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);
        return df.format(value);
    }

    public void printTotal() {
        System.out.println("total: $" + DecimalFormat(total));
    }

    public void printClerk() {
        System.out.println("Clerk: " + clerk.getName());
        System.out.println();
    }
}


class DiscountBill extends GroceryBill {
    private double discount;


    public DiscountBill(Employee clerk) {
        super(clerk);
    }

    public void add(Item i) {
        receipt.add(i);
        total += i.getPrice();
        discount += i.getDiscount();
    }

    public void printTotal() {
        System.out.println("sub-total: $" + DecimalFormat(total));
        System.out.println("discount: $" + DecimalFormat(discount));
        System.out.println("total: $" + DecimalFormat(total - discount));
    }
}

public class inheritance002 {
    public static void main(String[] args) {
        Employee e1 = new Employee(); e1.name = "Grocery Bill";
        Employee e2 = new Employee(); e2.name = "Discount Bill";

        GroceryBill g1 = new GroceryBill(e1);
        DiscountBill g2 = new DiscountBill(e2);

        Item i1 = new Item("item 1", 2.30, 0.00);
        Item i2 = new Item("item 2", 3.45, 0.00);
        Item i3 = new Item("item 3", 20.00, 15.00);
        Item i4 = new Item("item 4", 40.00, 35.00);
        Item i5 = new Item("item 5", 50.00, 35.00);

        g1.add(i1);
        g1.add(i2);

        g2.add(i3);
        g2.add(i4);
        g2.add(i5);

        g1.printReceipt();
        g1.printTotal();
        g1.printClerk();

        g2.printReceipt();
        g2.printTotal();
        g2.printClerk();

    }
}