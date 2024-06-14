import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Scanner getScanner() {
        return sc;
    }
    public static int rarest(Map<String, Integer> psn) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int tmp = 1;
        int res = -1;
        int min = Integer.MAX_VALUE;
        for(Map.Entry<String, Integer> entry : psn.entrySet()) {
            if(map.containsKey(entry.getValue())) {
                map.put(entry.getValue(), map.get(entry.getValue())+1);
            } else {
                map.put(entry.getValue(), tmp);
            }
        }
        SortedSet<Integer> keys = new TreeSet<Integer>(map.keySet());
        for(int key : keys) {
            if(map.get(key) < min) {
                min = map.get(key);
                res = key;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = getScanner();
        int tt = Integer.parseInt(sc.nextLine());
        while(tt-->0) {
            Map<String, Integer> psn = new HashMap<String, Integer>();
            String line = sc.nextLine();
            String[] inp = line.split(" ");
            for(int i=0; i<inp.length-1; i+=2) {
                String name = inp[i];
                int age = Integer.parseInt(inp[i+1]);
                psn.put(name, age);
            }
            // for(Map.Entry<String, Integer> entry : psn.entrySet()) {
            //     System.out.println(entry.getKey() + " " + entry.getValue());
            // }
            System.out.println(rarest(psn));
        }
    }
}