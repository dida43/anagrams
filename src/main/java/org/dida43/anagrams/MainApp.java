package org.dida43.anagrams;

import org.dida43.anagrams.service.AnagramService;
import org.dida43.anagrams.ui.ConsoleInterface;

public class MainApp {

    private final AnagramService anagramService = new AnagramService();
    private final ConsoleInterface consoleInterface = new ConsoleInterface();

    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.run();
    }

    private void run() {
        while (true) {
            consoleInterface.displayMenu();
            int choice = consoleInterface.getChoice();
            
            switch (choice) {
                case 1 -> checkAnagrams();
                case 2 -> displayAnagrams();
                case 3 -> {
                    consoleInterface.displayMessage("Exiting...");
                    return;
                }
                default -> consoleInterface.displayMessage("Invalid choice! Try again.");
            }
        }
    }

    private void checkAnagrams() {
        String firstText = consoleInterface.getInputText("Enter first text:");
        String secondText = consoleInterface.getInputText("Enter second text:");

        if (anagramService.areAnagrams(firstText, secondText)) {
            consoleInterface.displayMessage("They are anagrams!");
            anagramService.storeAnagramPair(firstText, secondText);
        } else {
            consoleInterface.displayMessage("They are not anagrams.");
        }
    }

    private void displayAnagrams() {
        String text = consoleInterface.getInputText("Enter the text to find its anagrams:");
        var anagrams = anagramService.getAnagramsForText(text);
        consoleInterface.displayMessage("Anagrams: " + anagrams);
    }
}
