import java.lang.*;
import java.io.*;
import java.util.*;

public class exception002 {
    public static void CheckFileExtension(String fileName) throws Exception {
        if(fileName.endsWith(".java")) {
            System.out.println(1);
        } else if(fileName.length()==0) {
            throw new Exception("Not java file exception.Mark is -1");
        } else {
            System.out.println(0);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0) {
            String s = sc.nextLine();
            try {
                CheckFileExtension(s);
            } catch(Exception e) {
                // get Message
                System.out.println(e.getMessage());
            }
        }
    }    
}