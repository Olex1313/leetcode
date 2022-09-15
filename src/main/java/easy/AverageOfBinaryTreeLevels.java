package easy;

import java.util.ArrayList;
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
        var ans = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            queue.add(node.left);
            queue.add(node.right);
        }
        return ans;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
