import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

/**
 * This Java class contains a method to check if a given sentence is a pangram (contains all letters of
 * the alphabet) and a main method to read input sentences and output whether they are pangrams.
 */

public class string_005 {
    public static boolean isPangram(String sentence) {
        //  Set to store all the characters in the sentence
        Set<Character> set = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            if (Character.isLetter(c)) {
                set.add(Character.toLowerCase(c));
            }
        }
        return set.size() == 26;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = Integer.parseInt(sc.nextLine());
        while(tt-->0) {
            String line = sc.nextLine();
            System.out.println(isPangram(line));
        }
    }
}