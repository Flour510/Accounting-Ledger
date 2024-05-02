package com.pluralsight;

/*
Explanation of project goes here
 */

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//***** import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
//*****import java.util.List;
//*****import java.util.ArrayList;
//*****import java.util.HashMap;


public class Main {
    static Scanner userInput = new Scanner(System.in);
    static String userName;
    static int choice = 0;

    public static void main(String[] args) {
        while (choice != 4) {
            // prompt the user for their name
            System.out.println();
            System.out.println("Enter your name: ");
            userName = userInput.nextLine().trim();
            System.out.println();
            addMenu();

        }

    }

    public static void addMenu() {
        try {
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
            choice = Integer.parseInt(userInput.nextLine().trim());

            // create switch statement for options
            switch (choice) {
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
                    System.exit(1); // can recycle this for all exits
                default:
                    System.out.println();
                    System.out.println("Error: Invalid selection ");
                    return;
            }
        } catch (Exception ex) {
            System.out.println();
            System.out.println("Error, invalid input. ");
        }
    }

    public static void addDeposit() {
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

        try (FileWriter fileWriter = new FileWriter(file, true); // try with resources
             PrintWriter writer = new PrintWriter(fileWriter);
        ) {
            writer.println(depositInfo); // write the deposit information to the file
            writer.flush();
            System.out.println("Deposit added successfully. Enjoy " + userName + "!");
            System.out.println();
            addMenu();
        } catch (IOException ex) {
            System.out.println("Error occurred. Deposit did not go through. ");
            ex.printStackTrace();
        }

    }

    public static void makePayment() {
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

        try (FileWriter fileWriter = new FileWriter(file, true);
             PrintWriter writer = new PrintWriter(fileWriter);
        ) {
            writer.println(paymentInfo); // write the payment information to the file
            writer.flush();
            System.out.println("Thank you " + userName + ", your payment was added successfully. ");
            System.out.println();
            addMenu();
        } catch (IOException ex) {
            System.out.println("Error occurred while processing payment. ");
            ex.printStackTrace();
        }
    }

    public static void ledger() {
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
            System.out.println("4 - Reports / Custom Search ");
            System.out.println("5 - Home ");
            System.out.println();
            System.out.println("Make a selection below: ");
            choice = Integer.parseInt(userInput.nextLine().trim());
            System.out.println();

            // create a switch statement for options
            switch (choice) {
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
                    System.out.println("-".repeat(65));
                    System.out.println("                          Payments Only");
                    System.out.println("-".repeat(65));
                    System.out.println();
                    paymentsOnly();
                    break;
                case 4:
                    System.out.println("-".repeat(65));
                    System.out.println("                     Reports / Custom Search");
                    System.out.println("-".repeat(65));
                    System.out.println();
                    reports();
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

    public static void displayAllEntries() {
        Scanner scanner = new Scanner(System.in);

        // file path
        String filePath = "files/transactions.csv";

        // create a file object that points to the text file
        File file = new File(filePath);

        // create a file reader to open the file (Scanner)
        try (Scanner fileScanner = new Scanner(file)) {
            // read the contents of the file
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] words = line.split(" ");

                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("An error has occurred while accessing file. ");
        }

        // prompt user to make their next move
        // provides user with an option to go to previous screen or to go to the home screen
        System.out.println();
        System.out.println("What do you want to do next " + userName + "?");
        System.out.println();
        System.out.println("A - Return to Ledger Menu ");
        System.out.println("B - Return to Home Screen ");
        System.out.println("C - Exit the app ");
        System.out.println();
        System.out.println("Enter your choice below: ");
        String choice = scanner.nextLine();

        // process the users choice
        switch (choice.toUpperCase()) {
            case "A":
                ledger();
                break;
            case "B":
                addMenu();
                break;
            case "C":
                System.out.println();
                System.out.println("Goodbye for now " + userName + "!");
                System.exit(1); // can recycle this for all exits
            default:
                System.out.println();
                System.out.println("An error has occurred while retrieving selection. ");
                break;
        }
    }

    public static void depositsOnly() {
        Scanner scanner = new Scanner(System.in);

        File file = new File("files/transactions.csv");

        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {
            // skip the header line
            String line = reader.readLine();

            // read each line of the file
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split("\\|");

                if (columns.length >= 4) {
                    double depositAmount = Double.parseDouble(columns[4]);

                    // check if the entry represents a deposit by checking if amount is greater than 0
                    if (depositAmount > 0) {
                        // print the line if its a deposit
                        System.out.println(line);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("An error occurred while opening the file. ");
        }

        // prompt user to make their next move
        // provides user with an option to go to previous screen or to go to the home screen
        System.out.println();
        System.out.println("What do you want to do next " + userName + "?");
        System.out.println();
        System.out.println("A - Return to Ledger Menu ");
        System.out.println("B - Return to Home Screen ");
        System.out.println("C - Exit the app ");
        System.out.println();
        System.out.println("Enter your choice below: ");
        String choice = scanner.nextLine();

        // process the users choice
        switch (choice.toUpperCase()) {
            case "A":
                ledger();
                break;
            case "B":
                addMenu();
                break;
            case "C":
                System.out.println();
                System.out.println("Goodbye for now " + userName + "!");
                System.exit(1);
            default:
                System.out.println();
                System.out.println("An error has occurred while retrieving selection. ");
                break;
        }
    }

    public static void paymentsOnly() {
        Scanner scanner = new Scanner(System.in);

        File file = new File("files/transactions.csv");

        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {
            // skip the header line
            String line = reader.readLine();

            // read each line of the file
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split("\\|");

                if (columns.length >= 4) {
                    double depositAmount = Double.parseDouble(columns[4]);

                    // check if the entry represents a payment by checking if amount is less than 0
                    if (depositAmount < 0) {
                        // print the line if it's a payment
                        System.out.println(line);
                    }
                }

            }
        } catch (IOException ex) {
            System.out.println("An error occurred while opening the file. ");
        }

        // prompt user to make their next move
        // provides user with an option to go to previous screen or to go to the home screen
        System.out.println();
        System.out.println("What do you want to do next " + userName + "?");
        System.out.println();
        System.out.println("A - Return to Ledger Menu ");
        System.out.println("B - Return to Home Screen ");
        System.out.println("C - Exit the app ");
        System.out.println();
        System.out.println("Enter your choice below: ");
        String choice = scanner.nextLine();

        // process the users choice
        switch (choice.toUpperCase()) {
            case "A":
                ledger();
                break;
            case "B":
                addMenu();
                break;
            case "C":
                System.out.println();
                System.out.println("Goodbye for now " + userName + "!");
                System.exit(1);
            default:
                System.out.println();
                System.out.println("An error has occurred while retrieving selection. ");
                break;
        }
    }

    // (sub-menu within ledger menu)____________________________________________________________________________________
    public static void reports() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a report: ");
        System.out.println();
        System.out.println("1 - Month To Date ");
        System.out.println("2 - Previous Month ");
        System.out.println("3 - Year To Date ");
        System.out.println("4 - Previous Year ");
        System.out.println("5 - Search by Vendor ");
        System.out.println("6 - Back ");
        System.out.println();

        // prompt the user for input
        System.out.println("Make a selection below: ");
        int choice = Integer.parseInt(scanner.nextLine().strip());

        // process the users choice
        switch (choice) {
            case 1:
                System.out.println();
                System.out.println("-".repeat(65));
                System.out.println("                        Month To Date Report");
                System.out.println("-".repeat(65));
                System.out.println();
                monthToDateReport();
                break;
            case 2:
                System.out.println("-".repeat(65));
                System.out.println("                          Previous Month Report");
                System.out.println("-".repeat(65));
                System.out.println();
                previousMonthReport();
                break;
            case 3:
                System.out.println("-".repeat(65));
                System.out.println("                          Year To Date Report");
                System.out.println("-".repeat(65));
                System.out.println();
                yearToDateReport();
                break;
            case 4:
                System.out.println("-".repeat(65));
                System.out.println("                       Previous Year Report");
                System.out.println("-".repeat(65));
                System.out.println();
                previousYearReport();
                break;
            case 5:
                System.out.println("-".repeat(65));
                System.out.println("                     Search By Vendor Report");
                System.out.println("-".repeat(65));
                System.out.println();
                searchByVendorReport();
                break;
            case 6:
                ledger();
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 6. ");
        }
    }

    public static void monthToDateReport()
    {
        //***** Scanner scanner = new Scanner(System.in);
        String file = "files/transactions.csv";

        // current date objects
        LocalDate CurrentDate = LocalDate.now();
        LocalDate transactionDate;

        int CurrentMonth = CurrentDate.getMonthValue();
        int CurrentYear = CurrentDate.getYear();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine(); // skips the header line in csv file
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fileParts = line.split("\\|");
                transactionDate = LocalDate.parse(fileParts[0].split("\\|")[0]);
                if (transactionDate.getMonthValue() == CurrentMonth && transactionDate.getYear() == CurrentYear)
                {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("File not read.");
        }
    }

    public static void previousMonthReport()
    {
        //*****Scanner scanner = new Scanner(System.in);
        String file = "files/transactions.csv";

        // current date objects
        LocalDate CurrentDate = LocalDate.now();
        LocalDate transactionDate;

        int PreviousMonth = CurrentDate.getMonthValue() - 1;
        int CurrentYear = CurrentDate.getYear();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine(); // skips the header line in csv file
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fileParts = line.split("\\|");
                transactionDate = LocalDate.parse(fileParts[0].split("\\|")[0]);
                if (transactionDate.getMonthValue() == PreviousMonth && transactionDate.getYear() == CurrentYear)
                {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("File not read.");
        }

    }

    public static void yearToDateReport()
    {
        //*****Scanner scanner = new Scanner(System.in);
        String file = "files/transactions.csv";

        // current date objects
        LocalDate CurrentDate = LocalDate.now();
        LocalDate transactionDate;

        int CurrentYear = CurrentDate.getYear();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine(); // skips the header line in csv file
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fileParts = line.split("\\|");
                transactionDate = LocalDate.parse(fileParts[0].split("\\|")[0]);
                if (transactionDate.getYear() == CurrentYear)
                {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("File not read.");
        }

    }

    public static void previousYearReport()
    {
        //*****Scanner scanner = new Scanner(System.in);
        String file = "files/transactions.csv";

        // current date objects
        LocalDate CurrentDate = LocalDate.now();
        LocalDate transactionDate;

        int PreviousYear = CurrentDate.getYear() -1; // subtracted -1 to get previous year

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine(); // skips the header line in csv file
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fileParts = line.split("\\|");
                transactionDate = LocalDate.parse(fileParts[0].split("\\|")[0]);
                if (transactionDate.getYear() == PreviousYear)
                {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("File not read.");
        }
    }

     public static void searchByVendorReport()
     {
         System.out.println("Enter the vendor name below: ");
         Scanner scanner = new Scanner(System.in);
         String userInput = scanner.nextLine(); // read user input for vendor name

         String file = "files/transactions.csv";

         try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
             reader.readLine(); // skips the header line in csv file
             String line;

             while ((line = reader.readLine()) != null)
             {
                 String[] fileParts = line.split("\\|");
                 String vendorName = fileParts[3]; // vendor is on array column 3

                 if (vendorName.equalsIgnoreCase(userInput))
                 {
                     System.out.println(line);
                 }
             }
         } catch (IOException e) {
             System.out.println("File not read.");
         }
     }

}
