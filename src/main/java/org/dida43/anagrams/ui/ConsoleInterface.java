package org.dida43.anagrams.ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleInterface {

    private static final String MENU_OPTIONS = """
        Select an option:
        1. Check if two texts are anagrams
        2. Get all anagrams for a given text
        3. Exit
        """;

    private static final Logger logger = LoggerFactory.getLogger(ConsoleInterface.class);

    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        logger.info(MENU_OPTIONS);
    }

    public MenuChoice getChoice() {
        try {
            int choice = scanner.nextInt();
            consumeNewline();
            return MenuChoice.fromChoiceValue(choice);
        } catch (InputMismatchException e) {
            consumeNewline();
            displayInvalidInputMessage();
            return MenuChoice.INVALID_CHOICE;
        }
    }

    private void consumeNewline() {
        scanner.nextLine();
    }

    public void displayInvalidInputMessage() {
        logger.info("Invalid input. Please try again.");
    }

    public void displayExitMessage() {
        logger.info("Exiting...");
    }

    public void displayPositiveAnagramMessage() {
        logger.info("They are anagrams.");
    }

    public void displayNegativeAnagramMessage() {
        logger.info("They are not anagrams.");
    }

    public void displayFoundAnagramsMessage(Set<String> anagrams) {
        logger.info("Anagram app records for provided text: {}", anagrams);
    }

    public String getFirstText() {
        return promptForInput("Enter the first text:");
    }

    public String getSecondText() {
        return promptForInput("Enter the second text:");
    }

    public String getTextForAnagrams() {
        return promptForInput("Enter the text to find its anagrams:");
    }

    private String promptForInput(String promptMessage) {
        logger.info(promptMessage);
        return scanner.nextLine().trim();
    }
}
