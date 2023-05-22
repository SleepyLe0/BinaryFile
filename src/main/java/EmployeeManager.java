import java.io.*;
import java.util.*;

public class EmployeeManager {

    File file = new File("Employee.dat");

    public void addEmployee(int id, String name, int age, String department) {
        Employee employee = new Employee(id, name, age, department);
        List<Employee> employeeList1 = new ArrayList<>(), employeeList2;
        try {
            if (file.exists()) {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
                employeeList2 = (List<Employee>) input.readObject();
                for (Employee employees : employeeList2) {
                    employeeList1.add(employees);
                }
            }
            employeeList1.add(employee);
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(employeeList1);
            output.flush();
            output.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Employee viewEmployee(int id) {
        List<Employee> employeeList;
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
            employeeList = (List<Employee>) input.readObject();
            for (Employee employee : employeeList) {
                if (employee.getId() == id) {
                    return employee;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean deleteEmployee(int id) {
        boolean isDeleted = false;
        List<Employee> employeeList = new ArrayList<Employee>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
            employeeList = (List<Employee>) input.readObject();
            for (Employee employee : employeeList) {
                if (employee.getId() == id) {
                    employeeList.remove(employee);
                    isDeleted = true;
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
                    output.writeObject(employeeList);
                    output.flush();
                    output.close();
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return isDeleted;
    }

    public List<Employee> viewAllEmployee() {
        List<Employee> employeeList = null;
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
            employeeList = (List<Employee>) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }
}
