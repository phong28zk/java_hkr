public import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class Pair {
    int x; 
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    int add() {
        return x+y;
    }
    
    int substract() {
        return x-y;
    }
    
    int divide() {
        return (y==0 ? -1 : (x/y));
    }
    
    public String toString() {
        String res = String.format("%d %d %d", add(), substract(), divide());
        return res;
    }
}

public class 24 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tt = Integer.parseInt(sc.nextLine());
        while(tt-->0) {
            String line = sc.nextLine();
            String[] inp = line.split(" ");
            Pair p = new Pair(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]));
            System.out.println(p.toString());

        }
    }
} {
    
}
