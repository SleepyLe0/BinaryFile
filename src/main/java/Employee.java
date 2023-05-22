import java.io.Serializable;

public class Employee implements Serializable {

    private int id;
    private String name;
    private int age;
    private String department;

    public Employee(int id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return String.format("ID : %d\nName : %s\nAge : %d\nDepartment : %s", id, name, age, department);
    }
}
