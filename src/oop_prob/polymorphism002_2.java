import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class polymorphism002_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        Herd herd = new Herd();
        while (test-- > 0){
            String[] s = sc.nextLine().split(" ");
            herd.addToHerd(new Organism(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }
        herd.move(1, 1);
        System.out.print(herd);
    }
}

interface Moveable {
    void move(int dx, int dy);
}

class Organism implements Moveable {
    private int x;
    private int y;

    public Organism(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public String toString() {
        return String.format("x:%d;y:%d", x, y);
    }
}

class Herd {
    private List<Organism> organisms = new ArrayList<>();

    public void addToHerd(Moveable moveable){
        if(moveable instanceof Organism){
            organisms.add((Organism) moveable);
        }
    }
    public void move(int dx, int dy) {
        for (Organism organism : organisms) {
            organism.move(dx, dy);
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Organism organism : organisms) {
            sb.append(organism.toString()).append(organism.equals(organisms.get(organisms.size()-1)) ? "" : "\n");
        }
        return sb.toString();
    }
}