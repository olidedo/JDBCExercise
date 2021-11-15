import entity.Employee;
import entity.Office;
import service.*;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static CustomerService customerService = new CustomerServiceImpl();
    private static OrderService orderService = new OrderServiceImpl();
    private static EmployeeService employeeService = new EmployeeServiceImpl();
    private static OfficeService officeService = new OfficeServiceImpl();
    private static int choice;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
        switch (choice) {
            case 1:
                customerService.getAllCustomers();
                showMenu();
            case 2:
                System.out.println("Input order number");
                int orderNumber = input.nextInt();
                orderService.getOrderStatus(orderNumber);
                showMenu();
            case 3:
                System.out.println("Employee Code:");
                int employeeCode = input.nextInt();
                System.out.println("First Name:");
                String firstName = input.next();
                System.out.println("Last Name:");
                String lastName = input.next();
                System.out.println("Extension:");
                String extension = input.next();
                System.out.println("Email:");
                String email = input.next();
                System.out.println("Office Code:");
                String officeCode = input.next();
                System.out.println("Reports to:");
                int reportsTo = input.nextInt();
                System.out.println("Job Title:");
                String jobTitle = input.next();
                Office office = officeService.getOffice(officeCode);
                Employee reportsToEmployee = employeeService.findEmployee(reportsTo);
                Employee employee = new Employee(employeeCode, lastName, firstName, extension, email, office, reportsToEmployee, jobTitle);
                employeeService.addEmployee(employee);
                showMenu();
            case 4:
                System.out.println("Input customer number");
                int customerNumber = input.nextInt();
                customerService.getCustomerOffice(customerNumber);
                showMenu();
            case 5:
                System.out.println("Enter date in format YYYY-MM-DD:");
                String inputDate = input.next();
                Date date = Date.valueOf(inputDate);
                orderService.getNumberOfOrders(date);
                showMenu();
            case 6:
                System.out.println("Enter employee number:");
                int employeeNumber = input.nextInt();
                Employee employeeToDelete = employeeService.findEmployee(employeeNumber);
                employeeService.deleteEmployee(employeeToDelete);
                showMenu();
            case 7:
                System.out.println("Enter employee number:");
                int employeeNumber1 = input.nextInt();
                Employee foundEmployee = employeeService.findEmployee(employeeNumber1);
                if (foundEmployee != null) {
                    System.out.println(foundEmployee);
                } else {
                    System.out.println("Employee not found!");
                }
                showMenu();
            case 8:
                orderService.getNumberOfInProcessOrders();
                showMenu();
            default:
                break;
        }
    }

    private static void showMenu() {
        try {
            System.out.println("1- Get all customer's names and surnames");
            System.out.println("2- Get order status");
            System.out.println("3- Add an employee");
            System.out.println("4- Find office of customer");
            System.out.println("5- Find number of orders in a certain date");
            System.out.println("6- Delete an employee");
            System.out.println("7- Find employee");
            System.out.println("8- Find number of orders in process");
            System.out.println("Enter the number of an option or -1 to end:");
            choice = input.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("Wrong input! Run again!");
            System.exit(1);
        }

    }
}
