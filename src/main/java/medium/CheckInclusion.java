package medium;

import java.util.*;

public class CheckInclusion {

    /**
     * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
     *
     * @param s1 first string
     * @param s2 second string
     * @return return true if s2 contains a permutation of s1
     * Example: s1 = "ab", s2 = "eidbaooo" -> true
     * Example: s1 = "ab", s2 = "eidboaoo" -> false
     * @see <a href="https://leetcode.com/problems/permutation-in-string/">Task</a>
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] firstChars = new int[26];
        int[] windowChars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            firstChars[s1.charAt(i) - 'a'] += 1;
            windowChars[s2.charAt(i) - 'a'] += 1;
        }
        for (int i = 0, j = s1.length(); j < s2.length(); i++, j++) {
            if (checkPermutation(windowChars, firstChars)) return true;
            windowChars[s2.charAt(i) - 'a']--;
            windowChars[s2.charAt(j) - 'a']++;
        }
        return checkPermutation(windowChars, firstChars);
    }

    private boolean checkPermutation(int[] substr, int[] secondChars) {
        for (int i = 0; i < 26; i++) {
            if (substr[i] != secondChars[i]) return false;
        }
        return true;
    }

}
