import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.util.regex.*;

class Note {
    int id;
    String date;
    String noted;
    Note(int id, String date, String noted) {
        this.id = id;
        this.date = date;
        this.noted = noted;
    }
}

class User {
    private static int nextId = 1;
    String id, name;
    List<Note> notes = new ArrayList<Note>();

    User(String name) {
        this.name = name;
        this.id = getNextId();
    }

    String getNextId() {
        String ans="";
        if(nextId==0) nextId++;
        else if(nextId<10) ans= "00" + nextId;
        else if(nextId<100) ans= "0" + nextId;
        else ans= "" + nextId;
        nextId++;
        return ans;
    }

    void addNotes(Note noted) {
        notes.add(noted);
    }

    public void printUser() {
        System.out.printf("Account: %s\n", name);
        for(Note note : notes) {
            System.out.printf("%s | %s\n", note.date, note.noted);
        }
    }
    
}

class Utils {
    static int getNextNodeId(User user) {
        return user.notes.size() + 1;
    }
    
    static User findUserById(List<User> users, String id) {
        for(User user : users) {
            if(user.id.equals(id)) return user;
        }
        return null;
    }
    static String formatDate(String input) {
        if(input.length()!=7) {
            return null;
        }
        else {
            return input.substring(3,5) + " " + input.substring(0,3) + " " + input.substring(5,7);
        }
    }
    static Note findNoteById(List<Note> notes, int id) {
        for(Note note : notes) {
            if(note.id==id) return note;
        }
        return null;
    }

}

public class noteClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = Integer.parseInt(sc.nextLine());
        List<User> users = new ArrayList<User>();
        while(tt-->0) {
            String user = sc.nextLine();
            User newUser = new User(user);
            users.add(newUser);
        }
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String regexAdd = ("(\\d+)\\s+(Add)\\s+(.{7})\\s+(.+)");
            String regexShare = ("(\\d+)\\s+(Share)\\s+([0-9]+)\\s+(.+)");
            Matcher mtAdd = Pattern.compile(regexAdd).matcher(line);
            Matcher mtShare = Pattern.compile(regexShare).matcher(line);
            while(mtAdd.find()) {
                String id = mtAdd.group(1);
                User user1 = Utils.findUserById(users, id);
                String method = mtAdd.group(2);
                String dateS = mtAdd.group(3);
                if(!method.equals("Add")) {
                    System.out.println("invalid input");
                    return;
                } else {
                    String date = Utils.formatDate(dateS);
                    String noted = mtAdd.group(4);
                    int idNote = Utils.getNextNodeId(user1);
                    
                    if(date==null) {
                        System.out.println("invalid input");
                        return;
                    }

                    Note newNoted = new Note(idNote, date, noted.trim());
                    user1.addNotes(newNoted);
                }
            }
            while(mtShare.find()) {
                String id1 = mtAdd.group(1);
                String method = mtAdd.group(2);
                String id2 = mtAdd.group(3);
                User user1 = Utils.findUserById(users, id1);
                User user2 = Utils.findUserById(users, id2);
                
                if(!method.equals("Share")) {
                    System.out.println("invalid input");
                    return;
                } else {
                    int idNote1 = Integer.parseInt(mtAdd.group(4));
                    Note shareNote = Utils.findNoteById(user1.notes, idNote1);
                    int idNote2 = Utils.getNextNodeId(user2);
                    user2.addNotes(new Note(idNote2, shareNote.date, shareNote.noted));
                }
            }
        }
        for(User user : users) {
            user.printUser();
        }
    }
}