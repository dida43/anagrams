package org.dida43.anagrams.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleInterface {

    private final Scanner scanner = new Scanner(System.in);
    private final Logger logger = LoggerFactory.getLogger(ConsoleInterface.class);

    public void displayMenu() {
        logger.info("Select an option:");
        logger.info("1. Check if two texts are anagrams");
        logger.info("2. Get all anagrams for a given text");
        logger.info("3. Exit");
    }

    public MenuChoice getChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline left-over
            return MenuChoice.fromChoiceValue(choice);
        } catch (InputMismatchException e) {
            scanner.nextLine();  // Consume the newline left-over
            return MenuChoice.INVALID_CHOICE;
        }
    }

    public String getInputText(String message) {
        logger.info(message);
        return scanner.nextLine().trim();
    }

    public void displayMessage(String message) {
        logger.info(message);
    }
}
