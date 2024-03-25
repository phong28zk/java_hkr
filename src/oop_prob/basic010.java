import java.util.*;
import java.lang.*;
import java.lang.String.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class basic010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0) {
            String s = sc.nextLine();
            int n = s.length();
            
            StringBuilder reversed = new StringBuilder();
            reversed.append(s);
            String rev = reversed.toString();
            // System.out.println(rev);

            char[] c = rev.toCharArray();

            for(int i=n-1; i>=1; i--) {
                char temp = c[i-1];
                c[i-1] = c[i];
                c[i] = temp;
                i--;
            }

            // If c[0] = 0, then remove it
            if(c[0] == '0') {
                c = Arrays.copyOfRange(c, 1, c.length);
            }

            String s1 = new String(c);
            System.out.println(s1);
            

        }
    }
}