import java.io.*;
import java.lang.*;
import java.util.*;

class Point {
    public int x;
    public int y;
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void move(int dx, int dy) {
        this.x = x + dx;
        this.y = y + dy;
    }
    
    public double distanceTo(Point p) {
        return Math.sqrt(Math.pow((this.getX() - p.getX()),2) + Math.pow((this.getY() - p.getY()),2));
    }
}

public class oop004 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0) {
            String inp = sc.nextLine();
            String[] line = inp.split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int x2 = Integer.parseInt(line[2]);
            int y2 = Integer.parseInt(line[3]);
            Point p1 = new Point();
            Point p2 = new Point();
            
            p1.setX(x1); p1.setY(y1);
            p2.setX(x2); p2.setY(y2);
            
            p1.move(1,1);
            
            String roundedNumber = String.format("%.2f", (p1.distanceTo(p2)));
            System.out.println(roundedNumber);
        }
    }
}