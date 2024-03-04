import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("all")

public class elab2312 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = "\\d";   // Regex matches any single digit
        while(sc.hasNextLine()) {
            String a = sc.nextLine();
            if(a.isEmpty()) {
                break;
            }
        
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(a);

            // System.out.println(a);
            
            int count = 0;
            while(matcher.find()) {
                count++;
            }
            System.out.println(count);
        }
    }    
}
