import java.lang.*;
import java.util.Scanner;
import java.io.*;
import java.lang.*;

class Amount {
    public String currency;
    public int amount;
    
    Amount(String currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }
    
    public void add(Amount add) throws CurrencyMismatchException {
        if(!this.currency.equals(add.currency)) {
            throw new CurrencyMismatchException("Currency doesn't match");
        }
        this.amount += add.amount;
    }
    
    public int getAmount() {
        return amount;
    }
}

class CurrencyMismatchException extends Exception {
    public CurrencyMismatchException(String message) {
        super(message);
    }
}
public class exception001 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0) {
            String inp = sc.nextLine();
            String[] line = inp.split(" ");
            try {
                if(line.length != 4) {
                    throw new Exception("Invalid Input");
                }
                String currency1 = line[0];
                int amount1 = Integer.parseInt(line[1]);
                String currency2 = line[2];
                int amount2 = Integer.parseInt(line[3]);

                Amount a1 = new Amount(currency1, amount1);
                    Amount a2 = new Amount(currency2, amount2);

                    try {
                        if(a1.currency.equals(a2.currency)) {
                            a1.add(a2);
                            System.out.println(a1.getAmount());
                        } else {
                            throw new Exception("Currency doesn't match");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
        }
    }
}