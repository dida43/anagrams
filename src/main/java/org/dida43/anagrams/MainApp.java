package org.dida43.anagrams;

import org.dida43.anagrams.service.AnagramService;
import org.dida43.anagrams.ui.ConsoleInterface;
import org.dida43.anagrams.ui.MenuChoice;

public class MainApp {

    private final AnagramService anagramService = new AnagramService();
    private final ConsoleInterface consoleInterface = new ConsoleInterface(System.in);

    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.run();
    }

    private void run() {
        boolean isRunning = true;
        while (isRunning) {
            consoleInterface.displayMenu();
            MenuChoice choice = consoleInterface.getChoice();
            switch (choice) {
                case INVALID_CHOICE -> consoleInterface.displayInvalidInputMessage();
                case CHECK_ANAGRAMS -> processAnagramCheck();
                case ANAGRAMS_FOR_GIVEN_TEXT -> showAnagramsForGivenText();
                case EXIT -> isRunning = false;
            }
        }
        exitApplication();
    }

    private void processAnagramCheck() {
        String firstText = consoleInterface.displayGetFirstTextPrompt();
        String secondText = consoleInterface.displayGetSecondTextPrompt();

        if (areStringsAnagrams(firstText, secondText)) {
            consoleInterface.displayPositiveAnagramMessage();
            storeAnagramPair(firstText, secondText);
        } else {
            consoleInterface.displayNegativeAnagramMessage();
        }
    }

    private boolean areStringsAnagrams(String text1, String text2) {
        return anagramService.areAnagrams(text1, text2);
    }

    private void storeAnagramPair(String text1, String text2) {
        anagramService.storeAnagramPair(text1, text2);
    }

    private void showAnagramsForGivenText() {
        String text = consoleInterface.displayGetTextForAnagramsPrompt();
        var anagrams = anagramService.getAnagramsForText(text);
        consoleInterface.displayFoundAnagramsMessage(anagrams);
    }

    private void exitApplication() {
        consoleInterface.displayExitMessage();
        System.exit(0);
    }
}
