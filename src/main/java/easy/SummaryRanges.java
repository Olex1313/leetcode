package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();
        List<String> answer = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                if (start == i) {
                    answer.add("%d".formatted(nums[i]));
                }
                else {
                    answer.add("%d->%d".formatted(nums[start], nums[i]));
                }
                start = i + 1;
            }
        }
        if (start == nums.length - 1) {
            answer.add("%d".formatted(nums[nums.length - 1]));
        }
        else {
            answer.add("%d->%d".formatted(nums[start], nums[nums.length - 1]));
        }
        return answer;
    }
}
