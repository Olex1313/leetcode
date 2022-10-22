package medium;

public class StringCompression {

    /**
     * @param chars array of characters representing string
     * @return compressed array
     * Example: ["a","a","b","b","c","c","c"] -> ["a","2","b","2","c","3"]
     * @see <a href="https://leetcode.com/problems/string-compression/">Task</a>
     */
    public int compress(char[] chars) {
        int i = 0, j = 0, count = 0;
        char cur = chars[0];
        for (; i < chars.length; i++) {
            if (cur != chars[i]) {
                chars[j++] = cur;
                if (count > 1) {
                    String countS = Integer.toString(count);
                    for (char c : countS.toCharArray()) {
                        chars[j++] = c;
                    }
                }
                cur = chars[i];
                count = 1;
            } else {
                count++;
            }
        }
        chars[j++] = cur;
        if (count > 1) {
            String countS = Integer.toString(count);
            for (char c : countS.toCharArray()) {
                chars[j++] = c;
            }
        }
        return j;
    }

}
