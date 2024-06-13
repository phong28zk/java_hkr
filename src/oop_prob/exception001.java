import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class CurrencyMismatchException extends Exception {
    public CurrencyMismatchException(String msg) {
        super(msg);
    }
}

class Amount {
    String currency;
    int amount;
    
    Amount(String currency, int amount) {
    	this.currency = currency;
        this.amount = amount;
    }
    
    public int getAmount() {
        return this.amount;
    }
    
    public void add(Amount other) throws CurrencyMismatchException {
       	if (!this.currency.equals(other.currency)) {
            throw new CurrencyMismatchException("Currency doesn't match");
        } else {
            this.amount += other.amount;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = Integer.parseInt(sc.nextLine());
        while(tt-->0) {
            String line = sc.nextLine();
            String[] inp = line.split(" ");
            String c1 = inp[0];
            int a1 = Integer.parseInt(inp[1]);
            String c2 = inp[2];
            int a2 = Integer.parseInt(inp[3]);
            Amount am1 = new Amount(c1, a1);
            Amount am2 = new Amount(c2, a2);
            try {
                am1.add(am2);
            	System.out.println(am1.getAmount());
            } catch(CurrencyMismatchException e) {
				System.out.println(e.getMessage());
            }
        }
    }
}