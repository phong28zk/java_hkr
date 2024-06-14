public import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class WareHouse {
    private HashMap<String, Integer> map = new HashMap<String, Integer>();
    public void addProduct(String product, int stock) {
        map.put(product, stock);
    }
    public int stock(String product) {
		if(map.containsKey(product)) {
            return map.get(product);
        } else return -99;
    }
}

public class collection001 {
    public static void main(String args[]) {
        WareHouse wh = new WareHouse();
        wh.addProduct("milk", 10);
        wh.addProduct("coffee", 7);
        System.out.println("prices:");
        System.out.printf("milk: %d\n", wh.stock("milk"));
        System.out.printf("coffee: %d\n", wh.stock("coffee"));
        System.out.printf("sugar: %d\n", wh.stock("sugar"));
    }
	    
} 
