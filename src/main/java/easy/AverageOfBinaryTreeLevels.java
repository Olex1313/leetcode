package easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfBinaryTreeLevels {

    /**
     * @param root - tree root
     * @return list of avg of node values at levels from top
     * Example: root = [3,9,20,null,null,15,7] -> [3, 14.5, 11]
     * @see <a href="https://leetcode.com/problems/average-of-levels-in-binary-tree/">Task</a>
     */
    public static List<Double> averageOfLevels(TreeNode root) {
        var ans = new LinkedList<Double>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            long sum = 0;
            long count = queue.size();
            for (int i = 0; i < count; i++) {
                var node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(sum * 1.0 / count);
        }
        return ans;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

}
