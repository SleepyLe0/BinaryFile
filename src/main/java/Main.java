import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int optionInput = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            int id = 0;
            String name = "";
            int age = 0;
            String department = "";
            EmployeeManager employeeManager = new EmployeeManager();
            System.out.println("Welcome to Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee by ID");
            System.out.println("3. Delete Employee by ID");
            System.out.println("4. View All Employee");
            System.out.println("5. Exit");
            System.out.print("Please select option : ");
            optionInput = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (optionInput) {
                case 1 :
                    //Add Employee
                    System.out.print("Enter employee ID : ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter employee name : ");
                    name = scanner.nextLine();
                    System.out.print("Enter employee age : ");
                    age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter employee department : ");
                    department = scanner.nextLine();
                    System.out.println();
                    employeeManager.addEmployee(id,name,age,department);
                    System.out.println("Add Employee Successfully");
                    System.out.println();
                    break;
                case 2 :
                    //View Employee by ID
                    System.out.print("Enter employee ID : ");
                    id = scanner.nextInt();
                    System.out.println();
                    if (employeeManager.viewEmployee(id) == null) {
                        System.out.println("Employee not found");
                    } else {
                        System.out.println(employeeManager.viewEmployee(id));
                    }
                    System.out.println();
                    break;
                case 3 :
                    //Delete Employee by ID
                    System.out.print("Enter employee ID : ");
                    id = scanner.nextInt();
                    System.out.println();
                    if (employeeManager.deleteEmployee(id)) {
                        System.out.println("Delete Employee Successfully");
                    } else {
                        System.out.println("Employee not found");
                    }
                    System.out.println();
                    break;
                case 4 :
                    //View All Employee
                    int isBlank = 0;
                    for (Employee employee : employeeManager.viewAllEmployee()) {
                        System.out.println(employee);
                        System.out.println();
                        isBlank++;
                    }
                    if (isBlank == 0) {
                        System.out.println("No Employee in System");
                    }
                    System.out.println();
                    break;
                case 5 :
                    //Exit
                    System.out.println("Exit from system");
                    break;
                default :
                    System.out.println("Invalid option");
                    break;
            }
        } while (optionInput != 5);
    }
}
