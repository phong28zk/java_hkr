import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class Money {
    int euros;
    int cents;
    
    Money(int euros, int cents) {
        this.euros = euros;
        this.cents = cents;
    }
    
    @Override
    public String toString() {
        return String.format("%.2fe",euros + (double)cents/100.0);
    }
    
    public Money plus(Money added) {
        int totalEuros = this.euros + added.euros;
        int totalCents = this.cents + added.cents;
		if(this.cents + added.cents >= 100) {
            totalEuros+=totalCents/100;
            totalCents%=100;
        }
        return new Money(totalEuros, totalCents);
    }
    
    public boolean lessThan(Money compared) {
        int c1Euros = this.euros - compared.euros;
        int c1Cents = this.cents - compared.cents;
        // System.out.println(c1Euros);
        // System.out.println(c1Cents);
        if(c1Euros>0) return false;
        else if(c1Euros==0) {
            if(c1Cents>0) return false;
            else return true;
        } else {
            return true;
        }
    }
    
    public Money minus(Money minus) {
        int subtractEuros = 0;
        int subtractCents = 0;
        if(lessThan(minus)) {
            return new Money(0,0);
        } else {
            if(this.cents < minus.cents) {
                subtractCents = this.cents + 100 - minus.cents;
                subtractEuros = this.euros - minus.euros - 1;
                return new Money(subtractEuros, subtractCents);
            } else {
                subtractCents = this.cents - minus.cents;
                subtractEuros = this.euros - minus.euros;
                return new Money(subtractEuros, subtractCents);
            }
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Money t1 = new Money(10, 8);
        Money t2 = new Money(5, 5);

        Money t3 = new Money(10, 0);
        Money t4 = new Money(3, 0);
        Money t5 = new Money(5, 0);
        Money t6 = new Money(3, 50);

        String m1 = t1.toString();
        String m2 = t2.toString();
        System.out.println(m1);
        System.out.println(m2);
        Money sum1 = t1.plus(t2);
        System.out.println(sum1.toString());
        boolean b1 = t3.lessThan(t4);
        boolean b2 = t4.lessThan(t5);
        System.out.println(b1);
        System.out.println(b2);

        String m3 = t3.toString();
        String m6 = t6.toString();
        System.out.println(m3);
        System.out.println(m6);

        Money sub1 = t3.minus(t6);
        System.out.println(sub1.toString());
        Money sub2 = sub1.minus(t3);
        System.out.println(sub2.toString());

    }
}