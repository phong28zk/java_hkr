import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

public class lab02_staticAccount {
    static class User {
        String id, userName;
        static int nextId;
        BigDecimal balance;
        User(String userName, BigDecimal balance) {
            this.userName = userName;
            this.balance = balance;
            this.id = getNextId();
        }
        
        String getNextId() {
            String ans = "";
            if(nextId==0) nextId++;
            if(nextId<10) ans="00"+nextId;
            else if(nextId<100) ans="0"+nextId;
            else ans=""+nextId;
            nextId++;
            return ans;
        }
        
        String getName() {
            return this.userName;
        }
        
        BigDecimal getBalance() {
            return balance;
        }
        
        static User findUserById(List<User> users, String id) {
            int idInt = Integer.parseInt(id);
            for(User user : users) {
                if(Integer.parseInt(user.id) == idInt) return user;
            }
            return null;
        }
        
        static boolean isExistUser(List<User> users, String id) {
            int idInt = Integer.parseInt(id);
            for(User user : users) {
                if(Integer.parseInt(user.id) == idInt) return true;
            }
            return false;
        }
        
        static void increaseBalance(User user, BigDecimal amount) {
            user.balance = user.balance.add(amount);
        }
        
        static void decreaseBalance(User user, BigDecimal amount) {
            user.balance = user.balance.subtract(amount);
        }
        
        static void printUser(List<User> users) {
            for(User user : users) {
                System.out.print("[" + user.id + ", " + user.userName + ", " + user.balance + "]");
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = Integer.parseInt(sc.nextLine());
        List<User> users = new ArrayList<User>();
        while(tt-->0) {
            String input = sc.nextLine();
            String[] splitInput = input.split(" ");
                
            int numberOfAccount = Integer.parseInt(splitInput[0]);
            String userName = "";
            BigDecimal balance = BigDecimal.ZERO;
            String regex = "\\d+";
            // System.out.println(numberOfAccount);
            for(int i=1; i<splitInput.length; i++) {
                if(!splitInput[i].matches(regex)) {
                    userName += splitInput[i];
                    if(!splitInput[i+1].matches(regex)) {
                        userName += " ";
                    }
                } else {
                    balance = new BigDecimal(splitInput[i]);
                    users.add(new User(userName, balance));
                    userName = "";
                    balance = BigDecimal.ZERO;
                }
            }

            if(!sc.hasNextLine()) {
                User.printUser(users);
            }

            String transaction = sc.nextLine();
            String[] splitTransaction = transaction.split(" ");

            for(int i=1; i<splitTransaction.length;) {
                if(!splitTransaction[i].equals("nap")
                && !splitTransaction[i].equals("rut")
                && !splitTransaction[i].equals("chuyen"))
                {
                    System.out.println("invalid input");
                    i+=3;
                } else if(splitTransaction[i].equals("nap")) {
                    User user = User.findUserById(users, splitTransaction[i+1]);
                    BigDecimal amount = new BigDecimal(splitTransaction[i+2]);
                    if(!User.isExistUser(users, splitTransaction[i+1])) {
                        i+=3;
                    } else {
                        User.increaseBalance(user, amount);
                        i+=3;
                    }
                } else if(splitTransaction[i].equals("rut")) {
                    User user = User.findUserById(users, splitTransaction[i+1]);
                    BigDecimal amount = new BigDecimal(splitTransaction[i+2]);

                    if(!User.isExistUser(users, splitTransaction[i+1])) {
                        i+=3;
                    } else if(user.balance.compareTo(amount) < 0) {
                        i+=3;
                    } else {
                        User.decreaseBalance(user, amount);
                        i+=3;
                    }
                } else if(splitTransaction[i].equals("chuyen")) {
                    User user1 = User.findUserById(users, splitTransaction[i+1]);
                    User user2 = User.findUserById(users, splitTransaction[i+2]);

                    BigDecimal amount = new BigDecimal(splitTransaction[i+3]);

                    if(!User.isExistUser(users, splitTransaction[i+1]) || !User.isExistUser(users, splitTransaction[i+2])) {
                        i+=4;
                    } else if (user1.balance.compareTo(amount) < 0){
                        i+=4;
                    } else {
                        User.decreaseBalance(user1, amount);
                        User.increaseBalance(user2, amount);
                        i+=4;
                    }
                }
            }

            User.printUser(users);
            System.out.println();
            users = new ArrayList<User>();
            User.nextId = 0;
        }
	}
}