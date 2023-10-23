package org.dida43.anagrams.ui;

import java.util.Scanner;

public class ConsoleInterface {

    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("Select an option:");
        System.out.println("1. Check if two texts are anagrams");
        System.out.println("2. Get all anagrams for a given text");
        System.out.println("3. Exit");
    }

    public int getChoice() {
        return scanner.nextInt();
    }

    public String getInputText(String message) {
        System.out.println(message);
        scanner.nextLine();  // Consume the newline left-over
        return scanner.nextLine().trim();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
