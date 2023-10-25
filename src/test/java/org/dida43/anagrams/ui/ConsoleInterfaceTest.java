package org.dida43.anagrams.ui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class ConsoleInterfaceTest {

    private ConsoleInterface consoleInterface;

    @ParameterizedTest
    @CsvSource({
        "1, CHECK_ANAGRAMS",
        "2, DISPLAY_ANAGRAMS",
        "3, EXIT",
        "5, INVALID_CHOICE",
        "asdf, INVALID_CHOICE"
    })
    void testGetChoice(String input, MenuChoice expectedChoice) {
        InputStream in = new ByteArrayInputStream((input + "\n").getBytes());
        consoleInterface = new ConsoleInterface(in);
        assertEquals(expectedChoice, consoleInterface.getChoice());
    }

    @ParameterizedTest
    @CsvSource({
        "test, test",
        "te st, te st",
        "  test   , test"
    })
    void testGetFirstText(String input, String processedInput) {
        InputStream in = new ByteArrayInputStream((input + "\n").getBytes());
        consoleInterface = new ConsoleInterface(in);
        assertEquals(processedInput, consoleInterface.getFirstText());
    }

    @ParameterizedTest
    @CsvSource({
        "test, test",
        "te st, te st",
        "  test   , test"
    })
    void testGetSecondText(String input, String processedInput) {
        InputStream in = new ByteArrayInputStream((input + "\n").getBytes());
        consoleInterface = new ConsoleInterface(in);
        assertEquals(processedInput, consoleInterface.getSecondText());
    }

    @ParameterizedTest
    @CsvSource({
        "test, test",
        "te st, te st",
        "  test   , test"
    })
    void testGetTextForAnagrams(String input, String processedInput) {
        InputStream in = new ByteArrayInputStream((input + "\n").getBytes());
        consoleInterface = new ConsoleInterface(in);
        assertEquals(processedInput, consoleInterface.getTextForAnagrams());
    }
}
