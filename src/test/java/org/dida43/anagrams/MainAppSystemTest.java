package org.dida43.anagrams;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainAppSystemTest {

    @Test
    void testPositiveAnagramCheck() throws Exception {
        String output = SystemLambda
            .tapSystemErrAndOut(() ->
                SystemLambda
                    .withTextFromSystemIn("1", "listen", "silent", "3")
                    .execute(this::runApp));

        assertTrue(output.contains("They are anagrams."));
    }

    @Test
    void testNegativeAnagramCheck() throws Exception {
        String output = SystemLambda
            .tapSystemErrAndOut(() ->
                SystemLambda
                    .withTextFromSystemIn("1", "listen", "listening", "3")
                    .execute(this::runApp));

        assertTrue(output.contains("They are not anagrams."));
    }

    @Test
    void testAnagramRecords() throws Exception {
        String output = SystemLambda
            .tapSystemErrAndOut(() ->
                SystemLambda
                    .withTextFromSystemIn(
                        "1", "artist", "strait",
                        "1", "artist", "not an anagram",
                        "1", "artist", "traits",
                        "2", "artist",
                        "2", "strait",
                        "2", "not an anagram",
                        "3")
                    .execute(this::runApp));

        assertTrue(output.contains("[strait, traits]"));
        assertTrue(output.contains("[artist, traits]"));
        assertTrue(output.contains("[]"));
    }

    private void runApp() {
        MainApp app = new MainApp();
        app.run();
    }
}
