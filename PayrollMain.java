package payroll;

import java.util.Scanner;

public class PayrollMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while(true) {

            System.out.println("\n--- Payroll Menu ---");
            System.out.println("1 Add Employee");
            System.out.println("2 View Employees");
            System.out.println("3 Update Salary");
            System.out.println("4 Delete Employee");
            System.out.println("5 Exit");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name=sc.nextLine();

                    System.out.print("Department: ");
                    String dept=sc.nextLine();

                    System.out.print("Basic Salary: ");
                    double basic=sc.nextDouble();

                    dao.addEmployee(name,dept,basic);
                    break;

                case 2:
                    dao.viewEmployees();
                    break;

                case 3:
                    System.out.print("Employee ID: ");
                    int id=sc.nextInt();

                    System.out.print("New Basic Salary: ");
                    double sal=sc.nextDouble();

                    dao.updateSalary(id,sal);
                    break;

                case 4:
                    System.out.print("Employee ID: ");
                    int del=sc.nextInt();

                    dao.deleteEmployee(del);
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
