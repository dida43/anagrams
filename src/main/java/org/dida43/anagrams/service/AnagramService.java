package org.dida43.anagrams.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnagramService {

    private final Map<String, Set<String>> anagramRecords = new HashMap<>();

    public boolean areAnagrams(String firstText, String secondText) {
        return sortedSanitizedText(firstText).equals(sortedSanitizedText(secondText));
    }

    public void storeAnagramPair(String firstText, String secondText) {
        anagramRecords.computeIfAbsent(firstText, k -> new HashSet<>()).add(secondText);
        anagramRecords.computeIfAbsent(secondText, k -> new HashSet<>()).add(firstText);
    }

    public Set<String> getAnagramsForText(String text) {
        return anagramRecords.getOrDefault(text, Collections.emptySet());
    }

    private String sortedSanitizedText(String text) {
        char[] chars = text.replaceAll("[\\W_]+", "").toLowerCase().toCharArray();
        java.util.Arrays.sort(chars);
        return new String(chars);
    }
}
