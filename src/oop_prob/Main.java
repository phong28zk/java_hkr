import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class FileNameFormatException extends Exception {
    FileNameFormatException(String msg) {
        super(msg);
    }
}

class Test {
    public static void open_file(String s)  {
        try {
            f(s);
        } catch (FileNameFormatException fname) {
            System.out.println(fname.getMessage());
        } catch (Exception e){
            System.out.println("Exception");
        }
    }

    public static void f(String s) throws FileNameFormatException {
        if(s.contains(" ")) {
            throw new FileNameFormatException("File name format");
        }
        System.out.println("File opened");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Test.open_file(s);
        sc.close();
    }
}
