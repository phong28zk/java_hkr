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

    public Dog(String breed, int age, String name) {
        this.breed = breed;
        this.age = age;
        this.name = name;
    }

    @Override // annotation
    public String toString() {
        return "Dog [age=" + age + ", breed=" + breed + ", name=" + name + "]";
    }
}

public class class_dog {
    
    public static void main(String[] args) {
        Dog dog = new Dog("Pug", 2, "Bolt");
        
        System.out.println(dog);
    }
}