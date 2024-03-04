import java.util.*;
import java.lang.*;
import java.lang.String.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class User {
    String id, username;
    long balance;
    static long nextId;

    User(String username, long balance) {
        this.username = username;
        this.balance = balance;
        this.id = getNextId();
    }

    String getNextId() {
        String ans = "";
        if(nextId==0) nextId++;
        if(nextId<10) ans = "00" + nextId;
        else if(nextId<100) ans = "0" + nextId;
        else ans = "" + nextId;
        nextId++;
        return ans;
    }

    String getName() {
        return this.username;
    }

    long getBalance() {
        return this.balance;
    }
}

class Utils {
    static User findUserById(List<User> users, String id) {
        for(User user : users) {
            if(user.id.equals(id)) return user;
            // System.out.println("User: " + user.id + " " + user.username + " " + user.balance);
        }
        return null;
    }

    static void increaseBalance(User user, long amount) {
        user.balance += amount;
    }

    static void decreaseBalance(User user, long amount) {
        user.balance -= amount;
    }

    static void printUser(List<User> users) {
        for(User user: users) {
            System.out.print("[" + user.id + ", " + user.username + ", " + user.balance + "]");
        }
    }

}

public class lab02_staticClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<User> users = new ArrayList<User>();
        long t = sc.nextInt();
        sc.nextLine();
        while(t-->0) {
            String input = sc.nextLine();
            String[] splitInput = input.split("\\s+");
            String regex = "\\d+";
            String username = "";
            long balance = 0;
            for(int i=1; i<splitInput.length; i++) {
                // System.out.println(splitInput[i]);
                if(!splitInput[i].matches(regex)) {
                    username += splitInput[i];
                    if(!splitInput[i+1].matches(regex)) {
                        username += " ";
                    }
                } else {
                    balance = Integer.parseInt(splitInput[i]);
                    users.add(new User(username, balance));
                    username = "";
                    balance = 0;
                }
            }

            if(!sc.hasNextLine()) {
                for(User user: users) {
                    System.out.print("[" + user.id + ", " + user.username + ", " + user.balance + "]");
                }
                break;
            }

            String transaction = sc.nextLine();
            String[] splitTransaction = transaction.split("\\s+");
            
            for(int i=1; i<splitTransaction.length; ) {
                if(!splitTransaction[i].equals("nap")
                && !splitTransaction[i].equals("rut")
                && !splitTransaction[i].equals("chuyen")) {
                    System.out.println("Invalid Input");
                    return;
                } else if(splitTransaction[i].equals("nap")) {
                    String id = splitTransaction[i+1];
                    long amount = Integer.parseInt(splitTransaction[i+2]);
                    User user = Utils.findUserById(users, id);
                    Utils.increaseBalance(user, amount);
                    i += 3;
                } else if(splitTransaction[i].equals("rut")) {
                    String id = splitTransaction[i+1];
                    long amount = Integer.parseInt(splitTransaction[i+2]);
                    User user = Utils.findUserById(users, id);
                    if(user.balance < amount) {
                        for(User userX: users) {
                            System.out.print("[" + userX.id + ", " + userX.username + ", " + userX.balance + "]");
                        }
                        System.out.println("Invalid Input");
                        return;
                    } else {
                        Utils.decreaseBalance(user, amount);
                    }
                    i += 3;
                } else if(splitTransaction[i].equals("chuyen")) {
                    String id1 = splitTransaction[i+1];
                    String id2 = splitTransaction[i+2];
                    long amount = Integer.parseInt(splitTransaction[i+3]);
                    User user1 = Utils.findUserById(users, id1);
                    User user2 = Utils.findUserById(users, id2);
                    if(user1.balance < amount) {
                        for(User user: users) {
                            System.out.print("[" + user.id + ", " + user.username + ", " + user.balance + "]");
                        }
                        System.out.println();
                        System.out.println("Invalid Input");
                        return;
                    } else {
                        Utils.decreaseBalance(user1, amount);
                        Utils.increaseBalance(user2, amount);
                    }
                    i += 4;
                }
            }
            
            Utils.printUser(users);
        }
    }
}