import java.math.BigInteger;
import java.util.*;

class User {
    String id, username;
    BigInteger balance;
    static int nextId;

    User(String username, BigInteger balance) {
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

    BigInteger getBalance() {
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

    static void increaseBalance(User user, BigInteger amount) {
        user.balance = user.balance.add(amount);
    }

    static void decreaseBalance(User user, BigInteger amount) {
        user.balance = user.balance.subtract(amount);
    }

    static void printUser(List<User> users) {
        for(User user: users) {
            System.out.print("[" + user.id + ", " + user.username + ", " + user.balance + "]");
        }
    }

    static boolean isExistUser(List<User> users, String id) {
        for(User user : users) {
            if(user.id.equals(id)) return true;
        }
        return false;
    }

}

public class lab02_staticClass {
    @SuppressWarnings("resource")
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
            BigInteger balance = BigInteger.ZERO;

            for(int i=1; i<splitInput.length; i++) {
                if(!splitInput[i].matches(regex)) {
                    username += splitInput[i];
                    if(!splitInput[i+1].matches(regex)) {
                        username += " ";
                    }
                } else {
                    balance = BigInteger.valueOf(Integer.parseInt(splitInput[i]));
                    users.add(new User(username, balance));
                    username = "";
                    balance = BigInteger.ZERO;
                }
            }

            if(!sc.hasNextLine()) {
                for(User user: users) {
                    System.out.print("[" + user.id + ", " + user.username + ", " + user.balance + "]");
                }
                return;
            }

            String transaction = sc.nextLine();
            String[] splitTransaction = transaction.split("\\s+");
            
            for(int i=1; i<splitTransaction.length; ) {

                if(!splitTransaction[i].equals("nap")
                && !splitTransaction[i].equals("rut")
                && !splitTransaction[i].equals("chuyen")) {
                    i+=3;
                } else if(splitTransaction[i].equals("nap")) {
                    String id = splitTransaction[i+1];
                    BigInteger amount = BigInteger.valueOf(Integer.parseInt(splitTransaction[i+2]));


                    User user = Utils.findUserById(users, id);
                    if(!Utils.isExistUser(users, id)) {
                        i+=3;
                    } else {
                        Utils.increaseBalance(user, amount);
                        i+=3;
                    }
                } else if(splitTransaction[i].equals("rut")) {

                    String id = splitTransaction[i+1];
                    BigInteger amount = new BigInteger(splitTransaction[i+2]);

                    User user = Utils.findUserById(users, id);
                    if(!Utils.isExistUser(users, id)) {
                        i+=3;
                    } else if(user.balance.compareTo(amount) < 0) {
                        i+=3;
                    } else {
                        Utils.decreaseBalance(user, amount);
                        i+=3;
                    }
                } else if(splitTransaction[i].equals("chuyen")) {

                    String id1 = splitTransaction[i+1];
                    String id2 = splitTransaction[i+2];
                    BigInteger amount = BigInteger.valueOf(Integer.parseInt(splitTransaction[i+3]));


                    User user1 = Utils.findUserById(users, id1);
                    User user2 = Utils.findUserById(users, id2);

                    if (!Utils.isExistUser(users, id1) || !Utils.isExistUser(users, id2)) {
                        i += 4;
                    } else if (user1.balance.compareTo(amount) < 0){

                        i += 4;

                    } else {
                        Utils.decreaseBalance(user1, amount);
                        Utils.increaseBalance(user2, amount);
                        i += 4;
                    }
                }
            }
            
            Utils.printUser(users);
            System.out.println();
            users = new ArrayList<User>();
            User.nextId = 0;
        }
    }
}