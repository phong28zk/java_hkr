import java.util.*;
import java.lang.*;
import java.lang.String.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("all")

class Note {
    String date, noted;
    int id;

    Note(int id, String date, String noted) {
        this.id = id;
        this.date = date;
        this.noted = noted;
    }
}

class User {
    String id, username;
@SuppressWarnings("all")
static int nextId;
    List<Note> notes = new ArrayList<Note>();

    User(String username) {
        this.username = username;
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

    void addNewNoted(Note newNote) {
        notes.add(newNote);
    }

    void printUser() {
        System.out.println("Account: " + username);
        for(Note note : notes) {
            System.out.println(note.date + " | " + note.noted);
        }
    }
}



class Utils {

    static String formatDateInput(String input) {
        if(input.length()!=7) return null;
        return input.substring(3,5) + " " + input.substring(0,3) + " " + input.substring(5,7);
    }

    static int getNextNoteId(User user) {
        return user.notes.size() + 1;
    }

    static User findUserById(List<User> users, String id) {
        for(User user : users) {
            if(user.id.equals(id)) return user;
        }
        return null;
    }

    static Note findNoteById(List<Note> notes, int id) {
        for(Note note : notes) {
            if(note.id==id) return note;
        }
        return null;
    }

}

public class elab2315 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<User> users = new ArrayList<User>();
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0) {
            String acc = sc.nextLine();
            User newUser = new User(acc);
            users.add(newUser);
            // System.out.println("Account: " + newUser.username + " | ID: " + newUser.id); // debug account
        }
        while(sc.hasNextLine()) {
            String userId = sc.next();
            User user1 = Utils.findUserById(users, userId);
            String opr = sc.next();
            // System.out.println(userId + " " + opr); 
            if(!opr.equals("Add") && !opr.equals("Share")) {
                System.out.println("invalid input");
                return;
            }
            if(opr.equals("Add")) {
                String dateInp = sc.next();
                String note = sc.nextLine();
                int noteId = Utils.getNextNoteId(user1);
                String date = Utils.formatDateInput(dateInp);
                if(date==null) {
                    System.out.println("invalid input");
                    return;
                }
                Note newNote = new Note(noteId, date, note.substring(1, note.length()));
                user1.addNewNoted(newNote);
            } else {
                String userId2 = sc.next();
                User user2 = Utils.findUserById(users, userId2);
                if(user2==null) {
                    System.out.println("invalid input");
                    return;
                }
                int noteId = sc.nextInt();
                Note sharedNote = Utils.findNoteById(user1.notes, noteId);
                if(sharedNote == null) {
                    System.out.println("invalid input");
                    return;
                }
                int noteId2 = Utils.getNextNoteId(user2);
                user2.addNewNoted(new Note(noteId2, sharedNote.date, sharedNote.noted));
            }
        }
        for(User user : users) user.printUser();

    }
}