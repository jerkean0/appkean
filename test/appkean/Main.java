package appkean;

import java.util.Scanner;
import banking.bankApp;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int response;
            
            // An array to hold up to 99 bank accounts
            bankApp bapp[] = new bankApp[99];
            // A counter to keep track of the number of registered accounts
            int accountCount = 0;
            
            do {
                System.out.println("WELCOME TO MY SYSTEM!");
                System.out.println("What do you feel like doing today?");
                System.out.println("1. Banking");
                System.out.println("2. Shopping");
                System.out.println("3. Pay Bills");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                
                switch (choice) {
                    case 1:
                        int accn, pin;
                        System.out.println("1. Register");
                        System.out.println("2. Login");
                        System.out.println("3. Exit");
                        System.out.print("Enter Action: ");
                        int action = sc.nextInt();
                        
                        switch (action) {
                            case 1:
                                if (accountCount < bapp.length) {
                                    // Create a new bankApp object for the new user
                                    bapp[accountCount] = new bankApp();
                                    
                                    System.out.print("Enter Account No.: ");
                                    bapp[accountCount].setAccNo(sc.nextInt());
                                    System.out.print("Enter Pin No.: ");
                                    bapp[accountCount].setPin(sc.nextInt());
                                    
                                    System.out.println("Registered Account No: " + bapp[accountCount].getAccNo());
                                    // Increment the account counter
                                    accountCount++;
                                } else {
                                    System.out.println("Maximum number of accounts reached.");
                                }
                                break;
                            case 2:
                                System.out.print("Enter Account No.: ");
                                accn = sc.nextInt();
                                System.out.print("Enter Pin No.: ");
                                pin = sc.nextInt();
                                
                                int attempts = 3;
                                boolean loginSuccess = false;
                                
                                // Use a for loop to iterate through all registered accounts
                                for (int i = 0; i < accountCount; i++) {
                                    if (bapp[i].verifyAccount(accn, pin)) {
                                        System.out.println("LOGIN SUCCESS!");
                                        loginSuccess = true;
                                        break;
                                    }
                                }
                                
                                if (!loginSuccess) {
                                    while (!loginSuccess && attempts > 1) {
                                        attempts--;
                                        System.out.println("Invalid account. Attempts Left: " + attempts);
                                        System.out.print("Enter Account No.: ");
                                        accn = sc.nextInt();
                                        System.out.print("Enter Pin No.: ");
                                        pin = sc.nextInt();
                                        
                                        for (int i = 0; i < accountCount; i++) {
                                            if (bapp[i].verifyAccount(accn, pin)) {
                                                System.out.println("LOGIN SUCCESS!");
                                                loginSuccess = true;
                                                break;
                                            }
                                        }
                                    }
                                    
                                    if (!loginSuccess) {
                                        System.out.println("MAX ATTEMPT LIMIT REACHED!");
                                        System.exit(0);
                                    }
                                }
                                break;
                            case 3:
                                //EXIT
                                break;
                            default:
                                System.out.println("INVALID ACTION");
                        }
                        break;
                    case 2:
                        System.out.println("Shopping feature not implemented yet.");
                        break;
                    case 3:
                        System.out.println("Pay Bills feature not implemented yet.");
                        break;
                    default:
                        System.out.println("INVALID ACTION!");
                }
                System.out.print("Continue? (1/0): ");
                response = sc.nextInt();
            } while (response == 1);
            
            System.out.println("Thank you for using our system!");
        }
    }
}