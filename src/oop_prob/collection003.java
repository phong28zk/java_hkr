import java.util.*;
import java.lang.*;
import java.io.*;


public class collection003 {
    public static void rarest(Map<String, Integer> map) {
        Map<Integer, ArrayList<String>> temp = new HashMap<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(temp.containsKey(entry.getValue())) {
                temp.get(entry.getValue()).add(entry.getKey());
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(entry.getKey());
                temp.put(entry.getValue(), list);
            }
        }

        int minLength = Integer.MAX_VALUE;
        int minKey = Integer.MAX_VALUE;

        for (Map.Entry<Integer, ArrayList<String>> entry : temp.entrySet()) {
            if (entry.getValue().size() < minLength) {
                minLength = entry.getValue().size();
                minKey = entry.getKey();

            }
        }
        System.out.println(minKey);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0) {
            String inp = sc.nextLine();
            String[] line = inp.split(" ");
            Map<String, Integer> map = new HashMap<>();
            
            for(int i=0; i<line.length-1; i+=2) {
                map.put(line[i], Integer.parseInt(line[i+1]));
            }
            rarest(map);
        }
        sc.close();
    }
}