

import java.util.*;

class java_loops_2 {
    public static void Solve(Scanner in){
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        for(int i = 0; i < n-1; i++) {
            System.out.printf("%d ", a + ((2<<i) - 1)*b);
        }
        System.out.printf("%d\n", a + ((2<<n-1)-1)*b);
    }
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int ii=0;ii<t;ii++){
            Solve(in);
        }
        in.close();
    }
}
