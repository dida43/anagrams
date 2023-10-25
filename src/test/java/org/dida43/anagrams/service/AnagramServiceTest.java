package org.dida43.anagrams.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AnagramServiceTest {

    private AnagramService anagramService;

    @BeforeEach
    void setUp() {
        anagramService = new AnagramService();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/anagram_test_data.csv")
    void testAreAnagrams(String text1, String text2, boolean expected) {
        assertEquals(expected, anagramService.areAnagrams(text1, text2));
    }

    @Test
    void testStoreAnagramPairAndGetAnagramsForText() {
        anagramService.storeAnagramPair("listen", "silent");
        anagramService.storeAnagramPair("listen", "enlist");

        Set<String> anagrams = anagramService.getAnagramsForText("listen");

        assertEquals(2, anagrams.size());
        assertFalse(anagrams.contains("listen")); // it should not contain the input text
        assertTrue(anagrams.contains("silent"));
        assertEquals(0, getPosition(anagrams, "silent"));
        assertTrue(anagrams.contains("enlist"));
        assertEquals(1, getPosition(anagrams, "enlist"));

        anagrams = anagramService.getAnagramsForText("silent");
        assertEquals(2, anagrams.size());
        assertFalse(anagrams.contains("silent")); // it should not contain the input text
        assertTrue(anagrams.contains("listen"));
        assertEquals(0, getPosition(anagrams, "listen"));
        assertTrue(anagrams.contains("enlist"));
        assertEquals(1, getPosition(anagrams, "enlist"));

        anagrams = anagramService.getAnagramsForText("not an anagram");
        assertTrue(anagrams.isEmpty());
    }

    @Test
    void testGetAnagramsForTextWithNoStoredAnagrams() {
        Set<String> anagrams = anagramService.getAnagramsForText("example");
        assertTrue(anagrams.isEmpty());
    }
    
    private int getPosition(Set<String> set, String text) {
        int position = 0;
        for (String item : set) {
            if (item.equals(text)) {
                return position;
            }
            position++;
        }
        return -1; // not found
    }
}
