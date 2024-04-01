import java.util.*;
public class cf_1840a
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			String s = sc.next();
			String z = "";
			char x = '0';
			for(int i = 0;i<n;i++)
			{
				if(x=='0')
					x = s.charAt(i);
				else if(x==s.charAt(i))
				{
					z+=x;
					x = '0';
				}
			}
			System.out.println(z);
		}
	}
}