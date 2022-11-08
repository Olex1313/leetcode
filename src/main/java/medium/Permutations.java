package medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(answer, new ArrayList<>(), nums);
        return answer;
    }

    private void backtrack(List<List<Integer>> answer, List<Integer> current, int[] nums) {
        if (current.size() == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (current.contains(nums[i])) continue;
            current.add(nums[i]);
            backtrack(answer, current, nums);
            current.remove(current.size() - 1);
        }
    }

}
