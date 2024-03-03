import java.util.*;

class Point {
    private double x;
    private double y;
    public void setPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }


    public double slope(Point p) {
        if(p.getX() == this.x) return -1;
        else return (double)(p.getY() - this.y) / (p.getX() - this.x) != 0 ? (double)(p.getY() - this.y) / (p.getX() - this.x) : 0;
    }
}

public class oop009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            Point p1 = new Point();
            Point p2 = new Point();
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            p1.setPoint(x1, y1);
            p2.setPoint(x2, y2);
            System.out.println(p1.slope(p2));
        }
        
    }
}