package com.pluralsight;

/*
Explanation of project goes here
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main
{
    static Scanner userInput = new Scanner(System.in);
    static String userName;
    static int choice = 0;

    public static void main(String[] args)
    {
            while (choice != 4)
            {
                // prompt the user for their name
                System.out.println();
                System.out.println("Enter your name: ");
                userName = userInput.nextLine().trim();
                System.out.println();
                addMenu();

            }

    }

    public static void addMenu() {
        // print the home screen
        System.out.println("-".repeat(65));
        System.out.println("                Welcome to your $ Management Tool");
        System.out.println();
        System.out.println("                             Home");
        System.out.println("-".repeat(65));
        System.out.println();
        System.out.println("What do you want to do " + userName + "?");
        System.out.println();
        System.out.println("1 - Add Deposit ");
        System.out.println("2 - Make Payment (Debit) ");
        System.out.println("3 - Ledger ");
        System.out.println("4 - Exit ");
        System.out.println();
        System.out.println("Make a selection below: ");
        choice = Integer.parseInt(userInput.nextLine());

        // create switch statement for options
        switch (choice)
        {
            case 1:
                addDeposit();
                break;
            case 2:
                makePayment();
                break;
            case 3:
                ledger();
                break;
            case 4:
                System.out.println();
                System.out.println("Goodbye for now " + userName + "!");
                return;
            default:
                System.out.println();
                System.out.println("Error: Invalid selection ");
                return;

        }
    }


    public static void addDeposit()
    {
        System.out.println();
        System.out.println("-".repeat(65));
        System.out.println("                          Add Deposit");
        System.out.println("-".repeat(65));
        System.out.println();
        System.out.println("Enter deposit description: ");
        String description = userInput.nextLine(); // prompt user for deposit description
        System.out.println("Enter vendor: ");
        String vendor = userInput.nextLine(); // prompt user for vendor name
        System.out.println("Enter deposit amount below: ");
        double depositAmount = Double.parseDouble(userInput.nextLine()); // prompt user for deposit amount
        System.out.println();

        // get current date and time
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        // format the deposit information
        String depositInfo = formattedDateTime + "|" + description + "|" + vendor + "|" + depositAmount;

        // save the deposit information into the csv file
        File file = new File("files/transactions.csv");

        try(FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter writer = new PrintWriter(fileWriter);
        )
        {
            writer.println(depositInfo); // write the deposit information to the file
            writer.flush();
            System.out.println("Deposit added successfully. Enjoy " + userName + "!");
            System.out.println();
            addMenu();
        }
        catch(IOException ex)
        {
            System.out.println("Error occurred. Deposit did not go through. ");
            ex.printStackTrace();
        }

    }

    public static void makePayment()
    {
        System.out.println();
        System.out.println("-".repeat(65));
        System.out.println("                        Make Payment (Debit)");
        System.out.println("-".repeat(65));
        System.out.println();
        System.out.println("Enter payment description: ");
        String description = userInput.nextLine(); // prompt user from payment description
        System.out.println("Enter vendor: ");
        String vendor = userInput.nextLine(); // prompt user for vendor name
        System.out.println("Enter payment amount below: "); // prompt user to input payment amount
        Double paymentAmount = Double.parseDouble(userInput.nextLine()) * -1; // multiply by -1 to make negative payment
        System.out.println();

        // get current date and time
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);

        // format the payment information
        String paymentInfo = formattedDateTime + "|" + description + "|" + vendor + "|" + paymentAmount;

        // save payment information into the csv file
        File file = new File("files/transactions.csv");

        try(FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter writer = new PrintWriter(fileWriter);
        )
        {
            writer.println(paymentInfo); // write the payment information to the file
            writer.flush();
            System.out.println("Thank you " + userName + ", your payment was added successfully. ");
            System.out.println();
            addMenu();
        }
        catch(IOException ex)
        {
            System.out.println("Error occurred while processing payment. ");
            ex.printStackTrace();
        }
    }

    public static void ledger()
    {
        int choice = 0;

        while (choice != 5) {
            System.out.println();
            System.out.println("-".repeat(65));
            System.out.println("                             Ledger");
            System.out.println("-".repeat(65));
            System.out.println();
            System.out.println("What do you want to do " + userName + "?");
            System.out.println();
            System.out.println("1 - Display all entries ");
            System.out.println("2 - Deposits only ");
            System.out.println("3 - Payments only ");
            System.out.println("4 - Reports ");
            System.out.println("5 - Home ");
            System.out.println();
            System.out.println("Make a selection below: ");
            choice = Integer.parseInt(userInput.nextLine());
            System.out.println();

            // create a switch statement for options
            switch (choice)
            {
                case 1:
                    System.out.println("-".repeat(65));
                    System.out.println("                           All Entries");
                    System.out.println("-".repeat(65));
                    System.out.println();
                    displayAllEntries();
                    break;
                case 2:
                    System.out.println("-".repeat(65));
                    System.out.println("                          Deposits Only");
                    System.out.println("-".repeat(65));
                    System.out.println();
                    depositsOnly();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    addMenu(); // takes user back to the menu/home screen
                    break;
                default:
                    System.out.println();
                    System.out.println("Error, Invalid selection has occurred. ");
                    return;
            }
        }
    }

    public static void displayAllEntries()
    {
        Scanner scanner = new Scanner(System.in);

        // file path
        String filePath = "files/transactions.csv";

        // create a file object that points to the text file
        File file = new File(filePath);

        // create a file reader to open the file (Scanner)
        try(Scanner fileScanner = new Scanner(file))
        {
            // read the contents of the file
            while(fileScanner.hasNext())
            {
                String line = fileScanner.nextLine();
                String[] words = line.split(" ");

                System.out.println(line);
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("An error has occurred while accessing file. ");
        }

        // prompt user to make their next move
        // provides user with an option to go to previous screen or to go to the home screen
        System.out.println();
        System.out.println("What do you want to do next " + userName + "?");
        System.out.println();
        System.out.println("A - Return to Ledger Menu ");
        System.out.println("B - Return to Home Screen ");
        System.out.println();
        System.out.println("Enter your choice below: ");
        String choice = scanner.nextLine();

        // process the users choice
        switch (choice.toUpperCase())
        {
            case "A":
                ledger();
                break;
            case "B":
                addMenu();
                break;
            default:
                System.out.println();
                System.out.println("An error has occurred while retrieving selection. ");
                break;
        }
    }

    public static void depositsOnly()
    {

    }
}