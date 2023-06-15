package medium;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {

    /**
     * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
     * Example: s = "cbaebabacd", p = "abc"-> [0, 6]
     * Example: s = "abab", p = "ab" -> [0, 1, 2]
     * @see <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/">Task</a>
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>(s.length());
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (isAnagram(p, s.substring(i, i + p.length()))) {
                answer.add(i);
            }
        }
        return answer;
    }

    private boolean isAnagram(String first, String second) {
        int[] firstChars = new int[127];
        int[] secondChars = new int[127];
        for (int i = 0; i < second.length(); i++) {
            firstChars[first.charAt(i) - 'a'] += 1;
            secondChars[second.charAt(i) - 'a'] += 1;
        }
        for (char c : first.toCharArray()) {
            if (firstChars[c - 'a'] != secondChars[c - 'a']) return false;
        }
        return true;
    }
}
