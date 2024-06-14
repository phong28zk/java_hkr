import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class CurrencyException extends Exception{
    CurrencyException(String msg) {
        super(msg);
    }
}
class Amount {
    String cur;
    int am;
    Amount(String cur, int am) {
        this.cur = cur;
        this.am = am;
    }
    public int add(Amount amount) throws CurrencyException {
        if(amount.cur.equals(cur)) {
            return amount.am + am;
        } else {
            throw new CurrencyException("Currency doesn't match");
        }
    }
}

public class exception001_2 {
    public static Scanner sc  = new Scanner(System.in);
    public static Scanner getScanner() {
        return sc;
    }
    public static void main(String[] args) {
        Scanner sc = getScanner();
        int tt = Integer.parseInt(sc.nextLine());
        while(tt-->0) {
            String[] line = sc.nextLine().split(" ");
            String cur1 = line[0];
            int am1 = Integer.parseInt(line[1]);
            String cur2 = line[2];
            int am2 = Integer.parseInt(line[3]);
            Amount amount1 = new Amount(cur1, am1);
            Amount amount2 = new Amount(cur2, am2);
            try {
                System.out.println(amount1.add(amount2));
            } catch(CurrencyException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }

    }
}