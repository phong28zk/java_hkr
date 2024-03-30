import java.lang.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

class FlightBooking {
    public String flightId="OOP24";
    private static int seatAvailable = 180;

    public FlightBooking(){
        seatAvailable = 180;
    }

    public void bookSeat() {
        if(seatAvailable>0) {
            seatAvailable--;
        }
    }

    public void cancelSeat() {
        if(seatAvailable<180) {
            seatAvailable++;
        }
    }

    public void confirmBooking() {
        return;
    }

    public int getSeatAvailable() {
        return seatAvailable;
    }
}

public class lab02_flightbooking {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String test = sc.nextLine();
        int t = Integer.parseInt(test);
            while(t-->0) {
                String line = sc.nextLine();
                String[] splitLine = line.split(" ");
                String res = "";

                FlightBooking fb = new FlightBooking();
                ArrayList<Integer> userBooked = new ArrayList<Integer>();
                int lth = splitLine.length;

                for(int i=0; i<lth; i+=2) {
                    // System.out.println(splitLine[i]+" "+splitLine[i+1]);
                    if(splitLine[i+1].equals("Booking")) {
                        fb.bookSeat();
                        // userBooked.add(Integer.parseInt(splitLine[i]));
                        res += String.format("[Seat Available: %d]", fb.getSeatAvailable());

                    }
                    else if(splitLine[i+1].equals("Cancel")) {
                        fb.cancelSeat();
                        // userBooked.remove(Integer.parseInt(splitLine[i]));
                        res += String.format("[Seat Available: %d]", fb.getSeatAvailable());

                    } else if(splitLine[i+1].equals("Confirmed")) {
                        fb.confirmBooking();
                        res += String.format("--User %s Confirmed--[Seat Available: %d]", splitLine[i], fb.getSeatAvailable());

                    }
                }
                System.out.println(res);
            }
    }
}