import java.io.*;
import java.lang.*;
import java.util.*;

@SuppressWarnings("all")
public class string003 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            boolean comp = false;

            s1 = s1.toLowerCase();

            if(s1.equals(s2)) {
                comp = true;
            } else {
                comp = false;
            }

            System.out.println(comp);
        }
    }
}