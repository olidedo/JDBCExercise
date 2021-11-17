package org.example;

import org.example.Util.UtilFunctions;
import org.example.config.AppConfig;
import org.example.controller.CustomerController;
import org.example.controller.EmployeeController;
import org.example.controller.OfficeController;
import org.example.controller.OrderController;
import org.example.entity.Customer;
import org.example.entity.Employee;
import org.example.entity.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Application {
    @Autowired
    CustomerController customerController;
    @Autowired
    OrderController orderController;
    @Autowired
    OfficeController officeController;
    @Autowired
    EmployeeController employeeController;

    private static int choice = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner choiceInput = new Scanner(System.in);
        UtilFunctions utilFunctions = new UtilFunctions();
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Application main = context.getBean(Application.class);
        utilFunctions.showMenu();
        do {
            try {

                choice = choiceInput.nextInt();
                if (choice == 1) {
                    utilFunctions.printCustomers(main.customerController.getAllCustomers());
                    utilFunctions.showMenu();
                    choice = choiceInput.nextInt();
                }
                if (choice == 2) {
                    System.out.println("Enter order number:");
                    int orderNumber = input.nextInt();
                    System.out.println(main.orderController.getOrderStatus(orderNumber));
                    utilFunctions.showMenu();
                    choice = choiceInput.nextInt();
                }
                if (choice == 3) {
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
                    Office office = main.officeController.getOffice(officeCode);
                    Employee reportsToEmployee = main.employeeController.findEmployee(reportsTo);
                    Employee employee = new Employee(employeeCode, lastName, firstName, extension, email, office, reportsToEmployee, jobTitle);
                    main.employeeController.addEmployee(employee);
                    System.out.println("Employee added");
                    utilFunctions.showMenu();
                    choice = choiceInput.nextInt();
                }
                if (choice == 4) {
                    System.out.println("Input customer number");
                    int customerNumber = input.nextInt();
                    System.out.println("Address: " + main.customerController.findOffice(customerNumber).toString());
                    utilFunctions.showMenu();
                    choice = choiceInput.nextInt();
                }
                if (choice == 5) {
                    System.out.println("Enter date in format YYYY-MM-DD:");
                    String inputDate = input.next();
                    Date date = Date.valueOf(inputDate);
                    System.out.println(main.orderController.getNumberOfOrders(date));
                    utilFunctions.showMenu();
                    choice = choiceInput.nextInt();
                }
                if (choice == 6) {
                    System.out.println("Enter employee number:");
                    int employeeNumber = input.nextInt();
                    Employee employeeToDelete = main.employeeController.findEmployee(employeeNumber);
                    main.employeeController.deleteEmployee(employeeToDelete);
                    utilFunctions.showMenu();
                    choice = choiceInput.nextInt();
                }
                if (choice == -1) {
                    System.exit(0);
                }
            } catch (InputMismatchException exp) {
                System.out.println("Wrong input! Run again!");
                System.exit(1);
            } catch (NoResultException exp){
                System.out.println("No entity with this code. Run again!");
                System.exit(1);
            } catch (IllegalArgumentException exp){
                System.out.println("Trying to delete an employee that doesn't exist. Run again!");
                System.exit(1);
            }
        } while (true);
    }

}
