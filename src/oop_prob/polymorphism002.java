import java.util.*;

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

    
    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }


    @Override
    public String toString() {
        return "x:" + x + ";y:" + y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

class Herd {
    private ArrayList<Organism> organisms;

    public Herd() {
        this.organisms = new ArrayList<>();
    }

    public void addToHerd(Moveable moveable) {
        if (moveable instanceof Organism) {
            this.organisms.add((Organism) moveable);
        }
    }

    public void moveAll(int dx, int dy) {
        for (Organism organism : this.organisms) {
            organism.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.organisms.size(); i++) {
            Organism organism = this.organisms.get(i);
            sb.append("x:").append(organism.getX()).append(";y:").append(organism.getY());
            if (i != this.organisms.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    
}

public class polymorphism002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        int tt = Integer.parseInt(t);
        Herd herd = new Herd();

        while(tt-->0) {
            String[] line = sc.nextLine().split(" ");
            herd.addToHerd(new Organism(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }
        herd.moveAll(1,1);
        System.out.println(herd);
    }
}