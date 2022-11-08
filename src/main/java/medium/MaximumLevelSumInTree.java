package medium;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumInTree {

    public int maxLevelSum(TreeNode root) {
        int max = root.val;
        int curLevel = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int level = 1; !queue.isEmpty(); level++) {
            int levelSum = 0;
            for (int i = queue.size(); i > 0; i--) {
                var node = queue.poll();
                levelSum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (levelSum > max) {
                max = levelSum;
                curLevel = level;
            }
        }
        return curLevel;
    }

    public class TreeNode {
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
