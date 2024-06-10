import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class SDate {
    private int day;
   	private int month;
    private int year;
    
    SDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public boolean equals(Object s) {
         if (s instanceof SDate) {
            SDate d = (SDate) s;
            if (this.day == d.day && this.month == d.month && this.year == d.year) {
                return true;
            }
        }
        return false;
    }
}

public class object_ref002 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
            SDate d = new SDate(1, 2, 2020);
        System.out.println(d.equals("heh"));
        System.out.println(d.equals(new SDate(5, 2, 2012)));
        System.out.println(d.equals(new SDate(1, 2, 2020)));
        }
}