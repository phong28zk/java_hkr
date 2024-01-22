

import java.util.Scanner;

public class output_formatting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            //Complete this line
            System.out.printf("%-15s%s%n",s1,String.format("%03d",x));
        }
        System.out.println("================================");

    }
}



