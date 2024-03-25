import java.util.*;

@SuppressWarnings("all")

interface Packable {
    double weight();
}

class Book implements Packable {
    String author;
    String name;
    double weight;

    Book(String author, String name, double weight) {
        this.author = author;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return this.weight;
    }

}

class CD implements Packable {
    String artist;
    String name;
    int year;
    double weight;

    CD(String artist, String name, int year) {
        this.artist = artist;
        this.name = name;
        this.year = year;
        this.weight = 0.1;
    }

    @Override
    public double weight() {
        return 0.1;
    }
}

public class interface001 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Book b1 = new Book("Fyodor Dostoevsky", "Crime and Punishment", 2);
        Book b2 = new Book("Robert Martin", "Clean Code", 1);
        Book b3 = new Book("Kent Beck", "Test Driven Development", 0.5);

        CD c1 = new CD("Pink Floyd", "Dark Side of the Moon", 1973);
        CD c2 = new CD("Wigwam", "Nuclear Nightclub", 1975);
        CD c3 = new CD("Rendezvous Park", "Closer to Being Here", 2012);

        System.out.println(b1.author + ": " + b1.name);
        System.out.println(b2.author + ": " + b2.name);
        System.out.println(b3.author + ": " + b3.name);

        System.out.println(c1.artist + ": " + c1.name + " (" + c1.year + ")");
        System.out.println(c2.artist + ": " + c2.name + " (" + c2.year + ")");
        System.out.println(c3.artist + ": " + c3.name + " (" + c3.year + ")");


        
        
    }
}