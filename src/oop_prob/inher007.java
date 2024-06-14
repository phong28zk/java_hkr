import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

abstract class TestQuestion {
    protected String question;
    protected abstract void readQuestion();
}

class Essay extends TestQuestion {
	private int lineEssay;
    
    @Override
    protected void readQuestion() {
    	Scanner sc = Main.getScanner();
        lineEssay = Integer.parseInt(sc.nextLine());
        question = sc.nextLine();
    }
    
    public String toString() {
        return String.format("%d\n%s\n", lineEssay, question);
    }
}

class MultiChoice extends TestQuestion {
    List<String> choices = new ArrayList<String>();
    int cs;
    @Override
    protected void readQuestion() {
        Scanner sc = Main.getScanner();
        cs = Integer.parseInt(sc.nextLine());
        question = sc.nextLine();
        for(int i=0; i<cs; i++) {
            String choice = sc.nextLine();
            choices.add(choice);
        }
    }
    
    public String toString() {
        System.out.println(cs);
		StringBuilder sb = new StringBuilder(question).append("\n");
        for(String choice : choices) {
            sb.append(choice + "\n");
        }
        return sb.toString().trim();
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner sc = getScanner();
        int tt = Integer.parseInt(sc.nextLine());
        while(tt-->0) {
            System.out.println(tt+1);
			String type = sc.nextLine();
            System.out.println(type);
            if(!type.equals("m") && !type.equals("e")) {
                System.out.println("invalid input");
                return;
            } else {
                if(type.equals("e")) {
                    Essay e = new Essay();
                    e.readQuestion();
                    System.out.println(e.toString());
                } else {
                    MultiChoice m = new MultiChoice();
                    m.readQuestion();
                    System.out.println(m.toString());
                    
				}
            }
        }
    }
     static Scanner getScanner() {
         return sc;
     }
}