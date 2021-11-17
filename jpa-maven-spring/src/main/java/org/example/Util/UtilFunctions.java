package org.example.Util;

import org.example.entity.Customer;
import org.example.entity.Employee;
import org.example.entity.Office;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UtilFunctions {

    public void showMenu() {
        try {
            System.out.println("1- Get all customer's names and surnames");
            System.out.println("2- Get order status");
            System.out.println("3- Add an employee");
            System.out.println("4- Find office of customer");
            System.out.println("5- Find number of orders in a certain date");
            System.out.println("6- Delete an employee");
            System.out.println("Enter the number of an option or -1 to end:");
        } catch (InputMismatchException ime) {
            System.out.println("Wrong input! Run again!");
            System.exit(1);
        }
    }

    public void printCustomers(List<Customer> customers){
        for (Customer c : customers) {
            System.out.println(c.toString());
        }
    }

}
