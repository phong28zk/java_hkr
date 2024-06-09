import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tt = Integer.parseInt(sc.nextLine());
        while(tt-->0) {
            String line = sc.nextLine();
            String[] inp = line.split(" ");
            System.out.println(line.length());
            System.out.println(inp.length);
        }
    }
}