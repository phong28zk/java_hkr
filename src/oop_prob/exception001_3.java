import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;

class CurrencyException extends Exception {
    CurrencyException(String msg) {
        super(msg);
    }
}
class Amount {
    String cur;
    int amt;
    Amount(String cur, int amt) {
        this.cur = cur;
        this.amt = amt;
    }

    public int add(Amount amount) throws CurrencyException {
        if(this.cur.equals(amount.cur)) {
            return amt + amount.amt;
        } else {
            throw new CurrencyException("Currency doesn't match");
        }
    }

}

public class exception001_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = Integer.parseInt(sc.nextLine());
        while(tt-->0) {
            String line = sc.nextLine();
            String regex = ("([A-Za-z]+)\\s+(\\d+)\\s+([A-Za-z]+)\\s+(\\d+)");
            Matcher mt = Pattern.compile(regex).matcher(line);
            while(mt.find()) {
                String cur1 = mt.group(1);
                int am1 = Integer.parseInt(mt.group(2));
                String cur2 = mt.group(3);
                int am2 = Integer.parseInt(mt.group(4));
                Amount amount1 = new Amount(cur1, am1);
                Amount amount2 = new Amount(cur2, am2);
                try {
                    amount1.add(amount2);
                    System.out.println(amount1.add(amount2));
                } catch(CurrencyException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }
        }
    }
}