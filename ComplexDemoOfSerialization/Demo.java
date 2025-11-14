package ComplexDemoOfSerialization;
import java.io.*;
import java.util.ArrayList;

// --------------------- Address Class -----------------------
class Address implements Serializable {
    private static final long serialVersionUID = 1001L;

    private String city;
    private String state;
    private int pincode;

    public Address(String city, String state, int pincode) {
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return city + ", " + state + " - " + pincode;
    }
}

// --------------------- Person Class (Parent) -----------------------
class Person implements Serializable {
    private static final long serialVersionUID = 2001L;

    protected String name;
    protected int age;
    protected Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}

// --------------------- Student Class (Child) -----------------------
class Student extends Person {
    private static final long serialVersionUID = 3001L;

    private String course;
    private double marks;

    // transient fields are NOT serialized
    private transient String secretNote;

    public Student(String name, int age, Address address,
                   String course, double marks, String secretNote) {

        super(name, age, address);
        this.course = course;
        this.marks = marks;
        this.secretNote = secretNote;
    }

    // ------------ Custom Serialization Logic ------------
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();    // Write non-transient fields
        oos.writeUTF("MASKED");      // Store masked secret instead of real secret
    }

    private void readObject(ObjectInputStream ois)
            throws IOException, ClassNotFoundException {

        ois.defaultReadObject();     // Read non-transient fields
        this.secretNote = ois.readUTF(); // Set placeholder secret
    }

    @Override
    public String toString() {
        return "\nName: " + name +
               "\nAge: " + age +
               "\nCourse: " + course +
               "\nMarks: " + marks +
               "\nSecret Note: " + secretNote +
               "\nAddress: " + address;
    }
}

// --------------------- MAIN CLASS -----------------------
public class Demo {

    public static void main(String[] args) {

        // Create complex objects (nested + inheritance)
        Address a1 = new Address("Hyderabad", "Telangana", 500072);
        Address a2 = new Address("Chennai", "Tamil Nadu", 600028);

        Student s1 = new Student("Satish", 22, a1, "Java", 91.5, "Top Performance!");
        Student s2 = new Student("Kumar", 21, a2, "Python", 88.7, "Excellent Logic!");

        // Store students in an ArrayList
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);

        // ---------------- Serialization ----------------
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("studentsData.ser"))) {

            oos.writeObject(studentList);
            System.out.println("✔ Complex Object Serialized Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ---------------- Deserialization ----------------
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("studentsData.ser"))) {

            ArrayList<Student> list = (ArrayList<Student>) ois.readObject();

            System.out.println("\n✔ Complex Object Deserialized Successfully!");
            System.out.println("\n========= STUDENT DETAILS =========");

            for (Student s : list) {
                System.out.println(s);
                System.out.println("---------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
