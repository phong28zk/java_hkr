import java.util.*;

@SuppressWarnings("all")

class Sum {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    public int Sum5Number(int a, int b, int c, int d, int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        return this.a + this.b + this.c + this.d + this.e;
    }
}

public class basic005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            Sum sumScanner = new Sum();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int e = sc.nextInt();
            System.out.println(sumScanner.Sum5Number(a, b, c, d, e));
        }
    }
}