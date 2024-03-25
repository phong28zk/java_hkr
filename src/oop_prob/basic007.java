import java.util.*;

@SuppressWarnings("all")

public class basic007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0)
        {
            String year = sc.nextLine();
            int y = Integer.parseInt(year);
            if(y%4==0 && y%100!=0 || y%400==0)
            {
                System.out.println(y + " : Leap-year");
            }
            else
            {
                System.out.println(y + " : Non Leap-year");

            }
        }
        
    }
}