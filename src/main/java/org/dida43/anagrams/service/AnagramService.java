package org.dida43.anagrams.service;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
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
        String anagramKey = sorted(normalizeString(cleanString(firstText)));
        anagramRecords.computeIfAbsent(anagramKey, k -> new LinkedHashSet<>()).add(firstText);
        anagramRecords.get(anagramKey).add(secondText);
    }

    public Set<String> getAnagramsForText(String text) {
        String anagramKey = sorted(normalizeString(cleanString(text)));
        // Create a new copy of the original set
        Set<String> allAnagramRecords = new LinkedHashSet<>(anagramRecords.getOrDefault(anagramKey, Collections.emptySet()));
        allAnagramRecords.remove(text);
        return allAnagramRecords;
    }
}
