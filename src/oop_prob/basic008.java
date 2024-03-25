import java.util.*;

@SuppressWarnings("all")

public class basic008 {
    public static void main(String args[]) {
        int sum = 0;
        System.out.println("Numbers between 100 and 200, divisible by 9:");
        for(int i=108; i<=200; i+=9) {
            System.out.println(i);
            sum+=i;
        }
        System.out.println(sum);
    }
}