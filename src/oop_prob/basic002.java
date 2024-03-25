import java.util.*;
import java.lang.*;
import java.io.*;

@SuppressWarnings("all")

public class basic002
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        sc.nextLine();
		while(t-- > 0)
		{
			String a = sc.nextLine();
            System.out.println(a);
        }
    }
}