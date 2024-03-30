import java.util.Scanner;

public class if_else_2 {
    @SuppressWarnings("resource")
    public static void main(String args[]) {
        System.out.println(
            (new Scanner(System.in).nextInt()) % 2 < 1 ? "Even" : "Odd"
        );
    }
}