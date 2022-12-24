import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class Testing {


    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Student allan = new Student("Allan", 20);

        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("output.dat")))) {
            locFile.writeObject(allan);
        }

        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream( new FileInputStream("output.dat")))) {
            Student temp = (Student)locFile.readObject();
            System.out.println(temp.toString());
        }
    }
}


class Student implements Serializable{
    private String name;
    private int age;
    private ArrayList<String> goals;

    private long serialVersionUID = 1L;

    public Student(String name, int age, ArrayList<String> goals) {
        this.name = name;
        this.age = age;
        this.goals = goals;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.goals = new ArrayList<>();
    }

    public void addGoal(String goal) {
        goals.add(goal);
    }

    @Override
    public String toString() {
        return ("Name: " + name + "\nAge: " + age);
    }
}
