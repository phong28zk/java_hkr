import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

@SuppressWarnings("all")
public class string {
    public static String findLongestWord(String sentence) {
        List<String> inp = new ArrayList<>();
        inp.addAll(Arrays.asList(sentence.split(" ")));
        String longest = inp.get(0);
        for(int i=0; i<inp.size(); i++) {
			longest = (inp.get(i).length() >= longest.length() ? inp.get(i) : longest);
        }
        return longest;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tt = Integer.parseInt(sc.nextLine());
        while(tt-->0) {
            String line = sc.nextLine();
			System.out.println(findLongestWord(line));     
        }
    }
}