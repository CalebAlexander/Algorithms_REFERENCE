import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Your implementations of various string searching algorithms.
 *
 * @author Caleb Alexander
 * @userid calexander49
 * @GTID 903133971
 * @version 1.0
 */
public class PatternMatching {

    /**
     * Knuth-Morris-Pratt (KMP) algorithm that relies on the failure table (also
     * called failure function). Works better with small alphabets.
     *
     * Make sure to implement the failure table before implementing this method.
     *
     * @throws IllegalArgumentException if the pattern is null or of length 0
     * @throws IllegalArgumentException if text or comparator is null
     * @param pattern the pattern you are searching for in a body of text
     * @param text the body of text where you search for pattern
     * @param comparator you MUST use this for checking character equality
     * @return list containing the starting index for each match found
     */
    public static List<Integer> kmp(CharSequence pattern, CharSequence text,
                                    CharacterComparator comparator) {
        if (pattern == null || pattern.length() == 0 || text == null
                || text.length() == 0) {
            throw new java.lang.IllegalArgumentException("Error searching"
                    + " using KMP.  An input was null or length 0");
        } else if (pattern.length() > text.length()) {
            List<Integer> matches = new ArrayList<>();
            return matches;
        } else {
            List<Integer> matches = new ArrayList<>();
            int[] table = buildFailureTable(pattern, comparator);
            int textIndex = 0;
            int patternIndex = 0;

            while (textIndex + (pattern.length() - patternIndex)
                    <= text.length()) {
                if (comparator.compare(text.charAt(textIndex),
                        pattern.charAt(patternIndex)) == 0) {
                    textIndex++;
                    patternIndex++;
                    // Is it a full match?
                    if (patternIndex == pattern.length()) {
                        matches.add(textIndex - patternIndex);
                        patternIndex = table[pattern.length() - 1];
                        //textIndex = textIndex - patternIndex;
                    }
                } else {
                    if (patternIndex == 0) {
                        textIndex++;
                    } else {
                        patternIndex = table[patternIndex - 1];
                    }
                }
            }
            return matches;
        }
    }

    /**
     * Builds failure table that will be used to run the Knuth-Morris-Pratt
     * (KMP) algorithm.
     *
     * The table built should be the length of the input text.
     *
     * Note that a given index i will be the largest prefix of the pattern
     * indices [0..i] that is also a suffix of the pattern indices [1..i].
     * This means that index 0 of the returned table will always be equal to 0
     *
     * Ex. ababac
     *
     * table[0] = 0
     * table[1] = 0
     * table[2] = 1
     * table[3] = 2
     * table[4] = 3
     * table[5] = 0
     *
     * If the pattern is empty, return an empty array.
     *
     * @throws IllegalArgumentException if the pattern or comparator is null
     * @param pattern a {@code CharSequence} you're building a failure table for
     * @param comparator you MUST use this for checking character equality
     * @return integer array holding your failure table
     */
    public static int[] buildFailureTable(CharSequence pattern,
                                          CharacterComparator comparator) {
        if (pattern == null || comparator == null) {
            throw new java.lang.IllegalArgumentException("Cannot build "
                    + "failure table with a null pattern or comparator");
        } else if (pattern.length() == 0) {
            int[] table = new int[0];
            return table;
        } else if (pattern.length() == 1) {
            int[] table = new int[1];
            table[0] = 0;
            return table;
        } else {
            int[] table = new int[pattern.length()];
            int i = 0;
            int j = 1;
            table[i] = 0;
            while (j < pattern.length()) {
                if (comparator.compare(pattern.charAt(i),
                        pattern.charAt(j)) == 0) {
                    table[j++] = ++i;
                } else {
                    if (i == 0) {
                        table[j++] = 0;
                    } else {
                        i = table[i - 1];
                    }
                }
            }
            return table;
        }
    }

    /**
     * Boyer Moore algorithm that relies on last occurrence table. Works better
     * with large alphabets.
     *
     * Make sure to implement the last occurrence table before implementing this
     * method.
     *
     * @throws IllegalArgumentException if the pattern is null or of length 0
     * @throws IllegalArgumentException if text or comparator is null
     * @param pattern the pattern you are searching for in a body of text
     * @param text the body of text where you search for the pattern
     * @param comparator you MUST use this for checking character equality
     * @return list containing the starting index for each match found
     */
    public static List<Integer> boyerMoore(CharSequence pattern,
                       CharSequence text, CharacterComparator comparator) {
        if (pattern == null || pattern.length() == 0 || text == null
                || text.length() == 0 || comparator == null) {
            throw new java.lang.IllegalArgumentException("Error searching using"
                    + " Boyer Moore.  An input was null or length 0");
        } else if (pattern.length() > text.length()) {
            List<Integer> matches = new ArrayList<>();
            return matches;
        } else {
            List<Integer> matches = new ArrayList<>();
            Map<Character, Integer> table = buildLastTable(pattern);
            int textIndex = pattern.length() - 1;
            int patternIndex = textIndex;

            while (textIndex < text.length()) {
                if (comparator.compare(text.charAt(textIndex),
                        pattern.charAt(patternIndex)) == 0) {
                    textIndex--;
                    patternIndex--;
                    // Is it a full match?
                    if (patternIndex < 0) {
                        matches.add(textIndex + 1);
                        patternIndex = pattern.length() - 1;
                        textIndex += pattern.length() + 1;
                    }
                } else {
                    Integer shift = table.get(text.charAt(textIndex));
                    patternIndex = pattern.length() - 1;
                    textIndex += pattern.length() - 1;
                    textIndex -= (shift == null ? -1 : shift);
                }
            }
            return matches;
        }
    }

    /**
     * Builds last occurrence table that will be used to run the Boyer Moore
     * algorithm.
     *
     * Note that each char x will have an entry at table.get(x).
     * Each entry should be the last index of x where x is a particular
     * character in your pattern.
     * If x is not in the pattern, then the table will not contain the key x,
     * and you will have to check for that in your Boyer Moore implementation.
     *
     * Ex. octocat
     *
     * table.get(o) = 3
     * table.get(c) = 4
     * table.get(t) = 6
     * table.get(a) = 5
     * table.get(everything else) = null, which you will interpret in
     * Boyer-Moore as -1
     *
     * If the pattern is empty, return an empty map.
     *
     * @throws IllegalArgumentException if the pattern is null
     * @param pattern a {@code CharSequence} you are building last table for
     * @return a Map with keys of all of the characters in the pattern mapping
     *         to their last occurrence in the pattern
     */
    public static Map<Character, Integer> buildLastTable(CharSequence pattern) {
        if (pattern == null) {
            throw new java.lang.IllegalArgumentException("Cannot build "
                    + "last occurrence table of a null pattern.");
        } else if (pattern.length() == 0) {
            Map<Character, Integer> table = new HashMap<>();
            return table;
        } else {
            Map<Character, Integer> table = new HashMap<>();

            for (int i = 0; i < pattern.length(); i++) {
                table.put(pattern.charAt(i), i);
            }
            return table;
        }
    }

    /**
     * Prime base used for Rabin-Karp hashing.
     * DO NOT EDIT!
     */
    private static final int BASE = 137;

    /**
     * Runs the Rabin-Karp algorithm. This algorithms generates hashes for the
     * pattern and compares this hash to substrings of the text before doing
     * character by character comparisons.
     *
     * When the hashes are equal and you do character comparisons, compare
     * starting from the beginning of the pattern to the end, not from the end
     * to the beginning.
     *
     * You must use the Rabin-Karp Rolling Hash for this implementation. The
     * formula for it is:
     *
     * sum of: c * BASE ^ (pattern.length - 1 - i), where c is the integer
     * value of the current character, and i is the index of the character
     *
     * For example: Hashing "bunn" as a substring of "bunny" with base 137 hash
     * = b * 137 ^ 3 + u * 137 ^ 2 + n * 137 ^ 1 + n * 137 ^ 0 = 98 * 137 ^ 3 +
     * 117 * 137 ^ 2 + 110 * 137 ^ 1 + 110 * 137 ^ 0 = 254203747
     *
     * Note that since you are dealing with very large numbers here, your hash
     * will likely overflow, and that is fine for this implementation.
     *
     * Another key step for this algorithm is that updating the hashcode from
     * one substring to the next one must be O(1). To update the hash:
     *
     *  remove the oldChar times BASE raised to the length - 1, multiply by
     *  BASE, and add the newChar.
     *
     * For example: Shifting from "bunn" to "unny" in "bunny" with base 137
     * hash("unny") = (hash("bunn") - b * 137 ^ 3) * 137 + y * 137 ^ 0 =
     * (254203747 - 98 * 137 ^ 3) * 137 + 121 * 137 ^ 0 = 302928082
     *
     * Keep in mind that calculating exponents is not O(1) in general, so you'll
     * need to keep track of what BASE^{m - 1} is for updating the hash.
     *
     * @throws IllegalArgumentException if the pattern is null or of length 0
     * @throws IllegalArgumentException if text or comparator is null
     * @param pattern a string you're searching for in a body of text
     * @param text the body of text where you search for pattern
     * @param comparator the comparator to use when checking character equality
     * @return list containing the starting index for each match found
     */
    public static List<Integer> rabinKarp(CharSequence pattern,
                      CharSequence text, CharacterComparator comparator) {
        if (pattern == null || pattern.length() == 0 || text == null
                || text.length() == 0 || comparator == null) {
            throw new java.lang.IllegalArgumentException("Error searching using"
                    + " Rabin Karpe.  An input was null or length 0");
        } else if (pattern.length() > text.length()) {
            List<Integer> matches = new ArrayList<>();
            return matches;
        } else {
            List<Integer> matches = new ArrayList<>();
            int rhText = 0;
            int rhPattern = 0;
            int compareIndex = 0;
            int baseM = 1;
            for (int i = 0; i < pattern.length(); i++) {
                rhText *= BASE;
                rhText += Character.hashCode(text.charAt(i));
                rhPattern *= BASE;
                rhPattern += Character.hashCode(pattern.charAt(i));
                baseM *= BASE;
            }
            baseM /= BASE;
            for (int j = pattern.length(); j < text.length(); j++) {
                if (rhText == rhPattern) {
                    compareIndex = 0;
                    while (compareIndex < pattern.length()
                            && comparator.compare(
                            text.charAt(j - pattern.length()
                                    + compareIndex), pattern.charAt(
                                    compareIndex)) == 0) {
                        compareIndex++;
                        if (compareIndex >=  pattern.length()) {
                            matches.add(j - pattern.length());
                        }
                    }
                }
                rhText -= Character.hashCode(text.charAt(j - pattern.length()))
                        * baseM;
                rhText *= BASE;
                rhText += Character.hashCode(text.charAt(j));
            }
            if (rhText == rhPattern) {
                compareIndex = 0;
                while (compareIndex < pattern.length()
                        && comparator.compare(
                        text.charAt(text.length() - pattern.length()
                                + compareIndex), pattern.charAt(
                                compareIndex)) == 0) {
                    compareIndex++;
                    if (compareIndex >=  pattern.length()) {
                        matches.add(text.length() - pattern.length());
                    }
                }
            }
            return matches;
        }
    }

}