package strings;

import java.util.LinkedList;
import java.util.List;

public class LargeGroupPositions {

    /**
     *
     * @param s String with groups of characters ex: aaxxxxbb
     * A group is considered large if it has 3 or more characters.
     * @return List of pairs of substrings borders ex: [[2, 5]]
     */
    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> answer = new LinkedList<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(start)) {
                if (i - start >= 3) {
                    answer.add(List.of(start, i - 1));
                }
                start = i;
            }
        }
        if (s.length() - start >= 3) {
            answer.add(List.of(start, s.length() - 1));
        }
        return answer;
    }

}
