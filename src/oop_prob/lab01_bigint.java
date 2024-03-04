import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

@SuppressWarnings("all")

public class lab01_bigint
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			String a = sc.next();
            char op = sc.next().charAt(0);
            String b = sc.next();

            if(op == '+') {
                System.out.println(new java.math.BigInteger(a).add(new java.math.BigInteger(b)));
            } else if (op == '*') {
                System.out.println(new java.math.BigInteger(a).multiply(new java.math.BigInteger(b)));
            } else if (op == '-') {
                System.out.println(new java.math.BigInteger(a).subtract(new java.math.BigInteger(b))); 
            } else {
                System.out.println(new java.math.BigInteger(a).divide(new java.math.BigInteger(b)));
            }
        }
    }
}