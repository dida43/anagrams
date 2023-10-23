package org.dida43;

import java.util.*;

public class AnagramChecker {

    private static final Map<String, Set<String>> anagramPairs = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Check if two texts are anagrams");
            System.out.println("2. Get all anagrams for a given text");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the leftover newline

            switch (choice) {
                case 1:
                    System.out.println("Enter first text:");
                    String text1 = scanner.nextLine();

                    System.out.println("Enter second text:");
                    String text2 = scanner.nextLine();

                    if (areAnagrams(text1, text2)) {
                        System.out.println("They are anagrams!");
                        addAnagramPair(text1, text2);
                    } else {
                        System.out.println("They are not anagrams.");
                    }
                    break;

                case 2:
                    System.out.println("Enter the text to find its anagrams:");
                    String text = scanner.nextLine();
                    Set<String> anagrams = getAnagrams(text);
                    System.out.println("Anagrams: " + anagrams);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static boolean areAnagrams(String s1, String s2) {
        char[] chars1 = s1.replaceAll("[\\W_]+", "").toLowerCase().toCharArray();
        char[] chars2 = s2.replaceAll("[\\W_]+", "").toLowerCase().toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    public static void addAnagramPair(String s1, String s2) {
        anagramPairs.computeIfAbsent(s1, k -> new HashSet<>()).add(s2);
        anagramPairs.computeIfAbsent(s2, k -> new HashSet<>()).add(s1);
    }

    public static Set<String> getAnagrams(String s) {
        return anagramPairs.getOrDefault(s, Collections.emptySet());
    }
}
