import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class Item {
    private String name;
    private double price;
    private double discount;
    Item(String name, double price, double discount) {
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
    
    @Override public String toString() {
        return String.format("%s $%.2f (-$%.2f)", name, price, discount).replace(",", ".");
    }
}


class Employee {
 	private String name;
    Employee(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}

class GroceryBill {
    private Employee clerk;
    private List<Item> receipt;
    private double total;
	
    GroceryBill(Employee clerk) {
        this.clerk = clerk;
        receipt = new ArrayList<>();
        total = 0.0;
    }
    
    public void add(Item i) {
        receipt.add(i);
        total += i.getPrice();
    }
    
    public double getTotal() {
        return total;
    }
    
    public Employee getClerk() {
        return clerk;
    }
    
    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer("items:\n");
        for(Item i : receipt) {
            sbf.append("   ").append(i).append("\n");
        }
        sbf.append("total: $").append(String.format("%.2f", total)).append("\n");        
        sbf.append("Clerk: ").append(clerk.getName()).append("\n");
        return sbf.toString().replace(",", ".");
    }
}



class DiscountBill extends GroceryBill {
    private double discountAmount;
    DiscountBill(Employee clerk) {
        super(clerk);
        this.discountAmount = 0.0;
    }
    
    public void add(Item item) {
        super.add(item);
        discountAmount += item.getDiscount();
    }
    
    @Override
    public String toString() {
        StringBuffer sbf = new StringBuffer(super.toString());
        sbf.replace(sbf.indexOf("total:"), sbf.length(), "");
        sbf.append("sub-total: $").append(String.format("%.2f", super.getTotal())).append("\n");
        sbf.append("discount: $").append(String.format("%.2f", discountAmount)).append("\n");
        sbf.append("total: $").append(String.format("%.2f", super.getTotal() - discountAmount)).append("\n");
		sbf.append("Clerk: ").append(super.getClerk().getName());
        return sbf.toString().replace(",", ".");
    }
    
}

public class inher003 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // int tt = Integer.parseInt(sc.nextLine());
        // while(tt-->0) {}
        Employee clerk1 = new Employee("Grocery Bill");
        GroceryBill groceryBill = new GroceryBill(clerk1);
        groceryBill.add(new Item("item 1", 2.3, 0));        
        groceryBill.add(new Item("item 2", 3.45, 0));
		System.out.println(groceryBill.toString());      

		Employee clerk2 = new Employee("Discount Bill");
		DiscountBill discountBill = new DiscountBill(clerk2);
        discountBill.add(new Item("item 3", 20.00, 15.00));
		discountBill.add(new Item("item 4", 40.00, 35.00));
		discountBill.add(new Item("item 5", 50.00, 35.00));
		System.out.println(discountBill.toString());      

    }
}