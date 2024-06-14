import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class Note {
    int id = 0;
    String noted, date;
    Note(int id, String date, String noted) {
        this.id = id;
        this.noted = noted;
        this.date = date;
    }
}

class User { 
    private static int nextId = 1;
    String id, userName;
    List<Note> notes = new ArrayList<Note>();

    User(String userName) {
        this.id = getNextId();
        this.userName = userName;
    }

    String getNextId() {
        String ans = "";
        if(nextId==0) nextId++;
        else if(nextId<10) ans="00" + nextId;
        else if(nextId<100) ans="0" + nextId;
        else ans="" + nextId;
        nextId++;
        return ans;
    }

    public void newNote(Note note) {
        notes.add(note);
    }

    public void printUser() {
        System.out.printf("Account: %s\n", userName);
        for(Note note : notes) {
            System.out.printf("%s | %s\n", note.date, note.noted);
        }
    }
}

class Utils {
    public static String formatDate(String date) {
        if(date.length()!=7) return null;
        String month = date.substring(0,3);
        String day = date.substring(3,5);
        String year = date.substring(5,7);
        return String.format("%s %s %s", day, month, year);

    }

    static int getNextNodeId(User user) {
        return user.notes.size() + 1;
    }

    public static User findUserById(List<User> users, String id) {
        for(User user : users) {
            if(user.id.equals(id)) {
                return user;
            }
        }
        return null;
    }

    public static Note findNoteById(List<Note> notes, int id) {
        for(Note note : notes) {
            if(note.id==id) return note;
        }
        return null;
    }

}

public class elab2315_2 {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int tt = Integer.parseInt(sc.nextLine());
        List<User> users = new ArrayList<User>();
        while(tt-->0) {
            String line = sc.nextLine();
            User user = new User(line);
            users.add(user);
        }
        // for(User user : users) {
        //     System.out.println(user.id + " " + user.userName);
        // }
        while(sc.hasNextLine()) {
            String id = sc.next();
            User user1 = Utils.findUserById(users, id);
            String method = sc.next();
            
            if(!method.equals("Add") && !method.equals("Share")) {
                System.out.println("invalid input");
                return;
            } else {
                if(method.equals("Add")) {
                    String date = Utils.formatDate(sc.next());
                    String noted = sc.nextLine();
                    int idNote = Utils.getNextNodeId(user1);

                    if(date==null) {
                        System.out.println("invalid input");
                		return;
                    }
                    
                    Note newNoted = new Note(idNote, date, noted.trim());
                    user1.newNote(newNoted);
                } else {
                    String id2 = sc.next();
                    User user2 = Utils.findUserById(users, id2);
                    if(user2==null) {
                        System.out.println("invalid input");
                        return;
                    }
                    int noteId = sc.nextInt();
                    Note shareNote = Utils.findNoteById(user1.notes, noteId);
                    if(shareNote==null) {
                        System.out.println("invalid input");
                        return;
                    }
                    int noteId2 = Utils.getNextNodeId(user2);
                    user2.newNote(new Note(noteId2, shareNote.date, shareNote.noted));
                }
            }
        }
        for(User user : users) {
            user.printUser();
        }
    }
}