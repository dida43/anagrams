package org.dida43.anagrams;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.junit.Assert.assertTrue;

public class MainAppSystemTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testPositiveAnagramCheck() {
        systemInMock.provideLines("1", "listen", "silent", "3");

        runApp();

        assertTrue(systemOutRule.getLog().contains("They are anagrams."));
    }

    @Test
    public void testNegativeAnagramCheck() {
        systemInMock.provideLines("1", "listen", "listening", "3");

        runApp();

        assertTrue(systemOutRule.getLog().contains("They are not anagrams."));
    }

    @Test
    public void testAnagramRecords() {
        systemInMock.provideLines(
            "1",
            "artist",
            "strait",
            "1",
            "artist",
            "not an anagram",
            "1",
            "artist",
            "traits",
            "2",
            "artist",
            "2",
            "strait",
            "2",
            "not an anagram",
            "3"
        );

        runApp();

        assertTrue(systemOutRule.getLog().contains("[strait, traits]"));
        assertTrue(systemOutRule.getLog().contains("[artist, traits]"));
        assertTrue(systemOutRule.getLog().contains("[]"));
    }

    private static void runApp() {
        MainApp app = new MainApp();
        app.run();
    }

}
