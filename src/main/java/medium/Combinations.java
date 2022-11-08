package medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(k, n,1, current, answer);
        return answer;
    }

    private void backtrack(int k, int n, int i, List<Integer> current, List<List<Integer>> answer) {
        if (current.size() == k) {
            answer.add(new ArrayList<>(current));
            return;
        }
        for (int j = i; j <= n; j++) {
            current.add(j);
            backtrack(k - 1, n, j, current, answer);
            current.remove(current.size() - 1);
        }
    }

}
