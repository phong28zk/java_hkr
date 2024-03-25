import java.util.*;

@SuppressWarnings("all")

class Student {
    String name;
    int age;
    static int noOfStudents = 0;
    Student(String name, int age) {
        this.name = name;
        this.age = age;
        noOfStudents++;
    }
    void display() {
        if(age>=18) {
            System.out.println(name);
        }
    }
}

public class elab2302 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        try {
            while(sc.hasNextLine()) {
                String name = sc.nextLine();
                String age_x = sc.nextLine();
                int age = Integer.parseInt(age_x);
                Student s = new Student(name, age);
                students.add(s);
            }
        } catch (Exception e) {
        }
        for(Student s: students) {
            s.display();
        }
        System.out.println(Student.noOfStudents);
    }
}