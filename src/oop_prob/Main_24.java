import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class Pair {
    private int x;
    private int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int add() {
        return x + y;
    }
    
    public int substract() {
        return x - y;
    }
    
    public int divide() {
        return (y==0 ? -1 : x/y);
    }
    
    @Override
    public String toString() {
        return "" + add() + " " + substract() + " " + divide();
    }
}

public class Main_24 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0) {
            String line = sc.nextLine();
            String[] inp = line.split(" ");
            Pair p = new Pair(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]));
            System.out.println(p);
        }
    }
} 