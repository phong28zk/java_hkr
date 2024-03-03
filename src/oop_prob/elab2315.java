import java.util.*;
import java.lang.*;
import java.lang.String.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Account {
    private static int id = 1;
    private String name;
    private String noted;

    public void setId(int id){
        this.id = id++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNoted(String noted) {
        this.noted = noted;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }



}

public class elab2315 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++)
        {
            Account a = new Account();
            a.setId(i+1);
            a.setName(sc.next());
        }

        

    }
}