import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;
class NotJavaFileException extends Exception {
    NotJavaFileException(String msg) {
        super(msg);
    }
}
public class Main {
    public static int CheckFileExtension(String fileName) throws NotJavaFileException {
        if(fileName.endsWith(".java")) {
            return 1;
        } else if(fileName.equals(null) || fileName.equals("")) {
            throw new NotJavaFileException("Not java file exception.Mark is -1");
        } else return 0;
    }

    static Scanner sc = new Scanner(System.in);
    static Scanner getScanner() {
        return sc;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = Integer.parseInt(sc.nextLine());
        while(tt-->0) {
            String line = sc.nextLine();
            try {
                System.out.println(CheckFileExtension(line));
            } catch (NotJavaFileException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
}