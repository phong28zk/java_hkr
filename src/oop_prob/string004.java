import java.util.*;
import java.lang.*;
import java.io.*;

@SuppressWarnings("all")

public class string004
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        sc.nextLine();
		while(t-- > 0)
		{
			StringBuffer a = new StringBuffer(sc.nextLine());
            System.out.println(a.length());
        }
    }
} 
