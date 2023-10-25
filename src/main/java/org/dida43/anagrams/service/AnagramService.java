package org.dida43.anagrams.service;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnagramService {

    private final Map<String, Set<String>> anagramRecords = new HashMap<>();

    public boolean areAnagrams(String s1, String s2) {
        String normalizedS1 = normalizeString(cleanString(s1));
        String normalizedS2 = normalizeString(cleanString(s2));

        return sorted(normalizedS1).equals(sorted(normalizedS2));
    }

    private String cleanString(String s) {
        // Remove all non-letter characters and convert to lowercase
        return s.replaceAll("[^\\p{L}]", "").toLowerCase();
    }

    private String normalizeString(String s) {
        // Normalize Unicode text to separate special characters from their base letters
        return Normalizer.normalize(s, Normalizer.Form.NFD);
    }

    private String sorted(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public void storeAnagramPair(String firstText, String secondText) {
        anagramRecords.computeIfAbsent(firstText, k -> new HashSet<>()).add(secondText);
        anagramRecords.computeIfAbsent(secondText, k -> new HashSet<>()).add(firstText);
    }

    public Set<String> getAnagramsForText(String text) {
        return anagramRecords.getOrDefault(text, Collections.emptySet());
    }
}
