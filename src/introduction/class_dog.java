import java.util.Scanner;

class Dog {
    private String breed;
    private int age;
    private String name;

    // constructor
    /**
     * @param breed
     * @param age
     * @param name
     */

    //  Setter
    public Dog(String breed, int age, String name) {
        this.breed = breed;
        this.age = age;
        this.name = name;
    }

    // Getter
    @Override // annotation
    public String toString() {
        return "Dog [age=" + age + ", breed=" + breed + ", name=" + name + "]";
    }

    public void printDogeString() {
        System.out.println(this.name + this.age + this.breed);
    }
}

public class class_dog {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String breed = sc.nextLine();   
        int age = sc.nextInt();

        // System.out.println(dog);
        Dog dogScanner = new Dog(breed, age, name);
        dogScanner.printDogeString();
        // dog2.printDogeString();
    }
}