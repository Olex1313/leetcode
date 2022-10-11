package medium;

public class LongestSubstringWithoutRepeatingChars {

    /**
     * @param s some string
     * @return longest substring without repeating characters
     * Example: "bbbbb" -> 1
     * Example: "abcabcbb" -> 3
     * Example: "pwwkew" -> 3
     * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Task</a>
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        var charsToIndexes = new int[127];
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = (charsToIndexes[s.charAt(i)] > 0) ? Math.max(j, charsToIndexes[s.charAt(i)]) : j;
            charsToIndexes[s.charAt(i)] = i + 1;
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

}
