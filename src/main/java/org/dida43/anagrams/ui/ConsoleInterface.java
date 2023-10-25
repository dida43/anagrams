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
    private static final String INVALID_INPUT_MSG = "Invalid input. Please try again.";
    private static final String EXIT_MSG = "Exiting...";
    private static final String POSITIVE_ANAGRAM_MSG = "They are anagrams.";
    private static final String NEGATIVE_ANAGRAM_MSG = "They are not anagrams.";
    private static final String ANAGRAMS_FOUND_MSG = "Anagrams found: {}";
    private static final String FIRST_TEXT_PROMPT = "Enter the first text:";
    private static final String SECOND_TEXT_PROMPT = "Enter the second text:";
    private static final String ANAGRAMS_TEXT_PROMPT = "Enter the text to find its anagrams:";

    private final Scanner scanner = new Scanner(System.in);
    private final Logger logger = LoggerFactory.getLogger(ConsoleInterface.class);


    public void displayMenu() {
        logger.info(MENU_OPTIONS);
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

    private String getInputText() {
        return scanner.nextLine().trim();
    }

    public void displayInvalidInputMessage() {
        logger.info(INVALID_INPUT_MSG);
    }

    public void displayExitMessage() {
        logger.info(EXIT_MSG);
        scanner.close();
    }

    public void displayPositiveAnagramMessage() {
        logger.info(POSITIVE_ANAGRAM_MSG);
    }

    public void displayNegativeAnagramMessage() {
        logger.info(NEGATIVE_ANAGRAM_MSG);
    }

    public void displayFoundAnagramsMessage(Set<String> anagrams) {
        logger.info(ANAGRAMS_FOUND_MSG, anagrams);
    }

    public String getFirstText() {
        logger.info(FIRST_TEXT_PROMPT);
        return getInputText();
    }

    public String getSecondText() {
        logger.info(SECOND_TEXT_PROMPT);
        return getInputText();
    }

    public String getTextForAnagrams() {
        logger.info(ANAGRAMS_TEXT_PROMPT);
        return getInputText();
    }
}
