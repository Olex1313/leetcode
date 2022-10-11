package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GrayCode {

    /**
     * @param n power of 2^n
     * @return valid gray code sequence
     * Example: 2 -> [0,1,3,2]
     * Example: 1 -> [0, 1]
     * @see <a href="https://leetcode.com/problems/gray-code/">Task</a>
     */
    public List<Integer> grayCode(int n) {
        var list = new LinkedList<Integer>();
        int iterations = 1 << n;
        for (int i = 0; i < iterations; i++) list.add(i ^ (i >> 1));
        return list;
    }

}
