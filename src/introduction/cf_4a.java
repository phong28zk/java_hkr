import java.util.Scanner;

public class cf_4a {
    public static void main(String args[]) {
        System.out.println(
            (new Scanner(System.in).nextInt() - 3) % 2 < 1 ? "NO" : "YES"
        );
    }
}