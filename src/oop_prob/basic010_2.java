import java.util.*;
import java.lang.*;
import java.lang.String.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class basic010_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0) {
            int n = sc.nextInt();
            int res = 0, log = 1;
            while(n>=10) {
                res += 10 * log * (n%10);
                n /= 10;
                res += log * (n%10);
                n /= 10;
                log *= 100;
            }
            System.out.println(res + n*log);
        }
    }
}