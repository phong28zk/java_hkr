import java.util.*;
import java.io.*;
import java.lang.*;

public class collection002 {
    public static void removeShorterStrings(ArrayList<String> list) {
        ArrayList<String> temp = list;
        for(int i=0; i< list.size()-1; i++) {
            if(list.get(i).length() <= list.get(i+1).length()) {
                temp.remove(i);
            } else {
                temp.remove(i+1);
            }
        }
        for(int i=0; i<temp.size(); i++){
            System.out.print(temp.get(i) + (i==temp.size() - 1 ? "\n" : " "));
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0) {
            ArrayList<String> list = new ArrayList<>();
            
            String inp = sc.nextLine();
            String[] line = inp.split(" ");

            for(String str : line) {
                list.add(str);
            }
            removeShorterStrings(list);
        }
        sc.close();
    }
}