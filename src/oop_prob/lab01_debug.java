import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

public class lab01_debug {
    public static int func(int x) {
        int sum = 0;
        outer: for(int i =0; i<x; i++){
            sum++;
            if(i==4) continue;
            inner: for(int j=0; j<x; j++) {
                if(j==i) continue outer;
                if(i==3) break;
                if(i==2) break outer;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
    }
}