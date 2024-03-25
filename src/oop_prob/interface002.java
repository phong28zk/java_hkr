import java.util.*;

@SuppressWarnings("all")

interface TacoBox {
    int tacoRemaining();
    void eat();
}

class TripleTacobox implements TacoBox {
    int tacos;

    TripleTacobox() {
        this.tacos = 3;
    }

    @Override
    public int tacoRemaining() {
        return this.tacos;
    }

    @Override
    public void eat() {
        if (this.tacos > 0) {
            this.tacos--;
        }
    }

}

class CustomTacoBox implements TacoBox {
    int tacos;

    CustomTacoBox(int tacos) {
        this.tacos = tacos;
    }

    @Override
    public int tacoRemaining() {
        return this.tacos;
    }

    @Override
    public void eat() {
        if(this.tacos > 0) {
            this.tacos--;
        }
    }
}

public class interface002 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        TripleTacobox t1 = new TripleTacobox();
        CustomTacoBox t2 = new CustomTacoBox(8);

        t1.eat();
        t1.eat();
        System.out.println("Triple taco boxes left: " + t1.tacoRemaining());

        t2.eat();
        System.out.println("Custom taco boxes left: " + t2.tacoRemaining());


    }
}