import java.util.*;

@SuppressWarnings("all")

class Dog {
    private static int id = 1;
    private String breed;
    private int age;
    private String name;

    @SuppressWarnings("static-access")
    public Dog() {
        this.id = id++;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public String setBreed(String breed) {
        return this.breed = breed;
    }

    public int setAge(int age) {
        return this.age = age;
    }

    // @SuppressWarnings("static-access")
    public void printDogDetail() {
        System.out.println("Name:" + this.name + "--" + "Breed:" + this.breed + "--" + "Age:" + this.age);
    }

}

public class test_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            Dog dogScanner = new Dog();
            dogScanner.setName("Micky");
            dogScanner.setBreed("Husky");
            dogScanner.setAge(12);
            dogScanner.printDogDetail();
        }
    }
}