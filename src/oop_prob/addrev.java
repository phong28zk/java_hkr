import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class addrev {
    public static void main(String args[]) { 
        Scanner sc = new Scanner(System.in);
        int tt = Integer.parseInt(sc.nextLine());

        while(tt-->0) { 
            String s = sc.nextLine();
            String[] num = s.split(" ");
            
            String rev1 = new StringBuilder(num[0]).reverse().toString();
            String rev2 = new StringBuilder(num[1]).reverse().toString();

            int r1 = Integer.parseInt(rev1);
            int r2 = Integer.parseInt(rev2);

            int sum = r1 + r2;
            String revSum = new StringBuilder(Integer.toString(sum)).reverse().toString();
            System.out.println(Integer.parseInt(revSum));
        }
    }
}