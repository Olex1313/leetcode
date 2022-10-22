package easy;

public class FirstUniqueChar {

    /**
     * @param s, string, consists of only lowercase English letters
     * @return index of first unique char or -1
     * @see <a href="https://leetcode.com/problems/first-unique-character-in-a-string/">Task</a>
     */
    public int firstUniqChar(String s) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (alphabet[s.charAt(i) - 'a'] == 0) {
                alphabet[s.charAt(i) - 'a'] = 1;
            } else {
                alphabet[s.charAt(i) - 'a'] = -1;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (alphabet[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

}
