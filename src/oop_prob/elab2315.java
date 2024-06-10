import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class Note {
    int id;
    String date, noted;
    Note(int id, String date, String noted) {
        this.id = id;
        this.date = date;
        this.noted = noted;
    }
}

class Account {
    static int nextId;
    String id, name;
    List<Note> notes = new ArrayList<Note>();
    
    Account(String name) {
        this.name = name;
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
    
    void newNote(Note note) {
        notes.add(note);
    }
    
    void printUser() {
        System.out.println("Account: " + name);
        for(Note note : notes) {
            System.out.println(note.date + " | " + note.noted);
        }
    }
}

class Utils {
    // Format Date
    static String formatDate(String input) {
        if(input.length()!=7) {
            return null;
        }
        else {
            return input.substring(3,5) + " " + input.substring(0,3) + " " + input.substring(5,7);
        }
    }
    
    // Get size of Note list and assign new note id
    static int getNextNodeId(Account acc) {
        return acc.notes.size() + 1;
    }
    
    // Find User by Id
    static Account findUserById(List<Account> acc, String id) {
        for(Account a : acc) {
            if(a.id.equals(id)) return a;
        }
        return null;
    }
    
    // Find note by Id
    static Note findNoteById(List<Note> notes, int id) {
        for(Note note : notes) {
            if(note.id == id) return note;
        }
        return null;
    }
}

public class elab2315 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        List<Account> accs = new ArrayList<Account>();
        int tt = Integer.parseInt(sc.nextLine());
        while(tt-->0) {
            String acc = sc.nextLine();
            Account newUser = new Account(acc);
            accs.add(newUser);
        }
        while(sc.hasNextLine()) {
            String accId1 = sc.next();
            Account acc1 = Utils.findUserById(accs, accId1);
            String opr = sc.next();
            // System.out.println(accId);
            // System.out.println(opr);
            if(!opr.equals("Add") && !opr.equals("Share")) {
                System.out.println("invalid input");
                return;
            } else {
                if(opr.equals("Add")) {
                    String dateInp = sc.next();
                    String note = sc.nextLine();
                    int noteId = Utils.getNextNodeId(acc1);
                    String date = Utils.formatDate(dateInp);
                    // System.out.println(date);
                    if(date==null) {
                        System.out.println("invalid input");
                		return;
                    }
                    Note newNoted = new Note(noteId, date, note.substring(1, note.length()));
                    acc1.newNote(newNoted);
                } else {
                    String accId2 = sc.next();
                    Account acc2 = Utils.findUserById(accs, accId2);
                    if(acc2==null) {
                        System.out.println("invalid input");
                		return;
                    }
                    int noteId = sc.nextInt();
                    Note sharedNote = Utils.findNoteById(acc1.notes, noteId);
                    if(sharedNote==null) {
                        System.out.println("invalid input");
                		return;
                    }
                    int noteId2 = Utils.getNextNodeId(acc2);
                    acc2.newNote(new Note(noteId2, sharedNote.date, sharedNote.noted));
                }
            }
        }
        for(Account acc : accs) {
            acc.printUser();
        }
        
    }
}

