
package com.eventmanagement.ui.cli;

import java.util.Scanner;

public class CLIMenu {
    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        while (true) {
            System.out.println("1. Create Event\n2. View Today's Events\n3. Exit");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("[Create Event selected]");
                    break;
                case "2":
                    System.out.println("[View Today's Events selected]");
                    break;
                case "3":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
} 