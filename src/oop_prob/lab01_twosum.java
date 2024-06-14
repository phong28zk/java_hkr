import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

public class lab01_twosum {
    public static void getIndex(String[] inp) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = Integer.parseInt(inp[0]);
        int sum = Integer.parseInt(inp[inp.length-1]);
        boolean found = false;
        for(int i=1; i<=n; i++) {
            int x = Integer.parseInt(inp[i]);
            int y = sum - x;
            map.put(x, i-1);
            if(map.containsKey(y)) {
                System.out.println(map.get(y) + " " + map.get(x));
                found = true;
                return;
            }
        }
        if(!found) {
            System.out.println("Not found");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = Integer.parseInt(sc.nextLine());
        while(tt-->0) {
            String line = sc.nextLine();
            String[] inp = line.split(" ");
            getIndex(inp);
        }
    }
}