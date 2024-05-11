import java.lang.*;
import java.util.Scanner;
import java.io.*;
import java.lang.*;

class Amount {
    String currency;
    int amount;

    Amount(String currency, int amount) {
        this.currency = currency;
        this.amount = amount;
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
                            System.out.println(a1.amount + a2.amount);
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