import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class Rectangle {
    int x, y, width, height; 
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return String.format("Rectangle[x=%d,y=%d,width=%d,height=%d]", x,y,width,height);
    }
}

public class oop002 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tt = Integer.parseInt(sc.nextLine());
        while(tt-->0) {
            String[] inp = sc.nextLine().split(" ");
            int x = Integer.parseInt(inp[0]);
            int y = Integer.parseInt(inp[1]);
            int width = Integer.parseInt(inp[2]);
            int height = Integer.parseInt(inp[3]);
            Rectangle r = new Rectangle(x,y,width,height);
            System.out.println(r.toString());
        }
    }
}