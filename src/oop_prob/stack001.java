import java.util.*;
import java.lang.*;
@SuppressWarnings("all")

class Utils {
    public void compressDuplicates(List<Integer> list) {
        Stack<Integer> temp = new Stack<>();
        int n = list.size();
        int times = 1;
        temp.push(list.get(0));
        for(int i=1; i<n; i++) {
            if(temp.peek() != list.get(i)) {
                if(times > 1) {
                    System.out.print(times + " " + temp.peek() + " ");
                    times = 1;
                } else {
                    System.out.print(times + " " + temp.peek() + " ");
                }
                temp.pop();
                temp.push(list.get(i));
            } else {
                times++;
            }
        }

        if (!temp.isEmpty()) {
            System.out.println(times + " " + temp.peek());
        }

    }
    
}

public class stack001 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0) {
            while(sc.hasNextLine()) {
                String s = sc.nextLine();
                Utils util = new Utils();

                List<Integer> list = new ArrayList<>();
                String[] arr = s.split(" ");
                
                for(String i: arr) {
                    list.add(Integer.parseInt(i));
                }

                // for(int i: list) {
                //     System.out.print(i + " ");
                // }
                util.compressDuplicates(list);

            }
        }
        
    }
}