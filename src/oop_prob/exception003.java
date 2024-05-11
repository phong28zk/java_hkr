import java.lang.*;
import java.io.*;
import java.util.*;

public class exception003 {
    public static void hasVowels(String str) throws Exception{
        boolean flag = false;
        // check if string has vowels use regex
        if(str.matches(".*[aeiouAEIOU].*")) {
            flag = true;
        } else {
            flag = false;
        }
        if(flag) {
            System.out.println("String has vowels");
        } else {
            throw new Exception("String not contain vowels");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0) {
            String s = sc.nextLine();
            try {
                hasVowels(s);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }    
}