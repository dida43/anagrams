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

    public boolean areAnagrams(String firstText, String secondText) {
        String normalizedFirstText = processStringForAnagramComparison(firstText);
        String normalizedSecondText = processStringForAnagramComparison(secondText);

        return normalizedFirstText.equals(normalizedSecondText);
    }

    public void storeAnagramPair(String firstText, String secondText) {
        String anagramKey = processStringForAnagramComparison(firstText);

        storeToAnagramRecords(anagramKey, firstText);
        storeToAnagramRecords(anagramKey, secondText);
    }

    public Set<String> getAnagramsForText(String text) {
        String anagramKey = processStringForAnagramComparison(text);

        Set<String> allAnagramRecordsForKey = new LinkedHashSet<>(
            anagramRecords.getOrDefault(anagramKey, Collections.emptySet())
        );
        //remove provided anagram from results
        allAnagramRecordsForKey.remove(text);

        return allAnagramRecordsForKey;
    }

    private String processStringForAnagramComparison(String s) {
        return sorted(normalize(clean(s)));
    }

    private String clean(String s) {
        //retain only alphabetic characters and remove everything else
        return s.replaceAll("[^\\p{L}]", "").toLowerCase();
    }

    private String normalize(String s) {
        //it will decompose characters into their canonical forms.
        // For example, the character ć (c with an acute accent) would be normalized into two separate characters: c and ´
        return Normalizer.normalize(s, Normalizer.Form.NFD);
    }

    private String sorted(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    private void storeToAnagramRecords(String key, String value) {
        anagramRecords.computeIfAbsent(key, k -> new LinkedHashSet<>()).add(value);
    }
}
