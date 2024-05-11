import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class lab01_bigdec {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tt = Integer.parseInt(sc.nextLine());
        while(tt-->0) {
            String line = sc.nextLine();
            String[] num = line.split(" ");
            BigDecimal sum = BigDecimal.ZERO;
            for(String number : num) {

                // Split the number by dot
                String[] parts = number.split("\\.");

                // print the parts
                // System.out.println(parts[0]);
                
                sum = sum.add(new BigDecimal(number).subtract(new BigDecimal(parts[0])));
            }
            System.out.println(sum);
        }
    }
}