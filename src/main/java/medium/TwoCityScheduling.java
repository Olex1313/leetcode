package medium;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {

    /**
     * A company is planning to interview 2n people.
     * Given the array costs where costs[i] = [aCost_i, bCost_i],
     * the cost of flying the ith person to city A is aCosti,
     * and the cost of flying the ith person to city B is bCosti.
     *
     * @param costs costs[i] = [aCost_i, bCost_i]
     * @return minimum cost to fly every person to a city,
     * such that exactly n people arrive in each city.
     * x3 > x1 && x4 > x2
     * Example: [[10,20],[30,200],[400,50],[30,20]] -> 110
     * Example: [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]] -> 3086
     * @see <a href="https://leetcode.com/problems/two-city-scheduling/">Task</a>
     */
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int totalCost = 0;
        int[] refund = new int[n];
        for (int i = 0; i < n; i++) {
            totalCost += costs[i][0];
            refund[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(refund);
        for (int i = 0; i < n / 2; i++) {
            totalCost += refund[i];
        }
        return totalCost;
    }

    /**
     * sorting is done based on (costs[i][1]-costs[i][0]) and arranged in decreasing order.
     */
    public int twoCitySchedCostWithPureSort(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (b[1] - a[1]) - (b[0] - a[0]));
        int n = costs.length;
        return Arrays.stream(costs, 0, n / 2).mapToInt(cost -> cost[0]).sum()
                + Arrays.stream(costs, n / 2, n).mapToInt(cost -> cost[1]).sum();
    }

}
