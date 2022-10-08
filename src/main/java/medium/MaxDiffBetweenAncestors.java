package medium;


import model.TreeNode;

public class MaxDiffBetweenAncestors {

    int result;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        result = 0;
        traverse(root, root.val, root.val);
        return result;
    }

    private void traverse(TreeNode node, int currentMax, int currentMin) {
        if (node == null) return;
        int possibleMax = Math.max(Math.abs(node.val - currentMax), Math.abs(node.val - currentMin));
        result = Math.max(result, possibleMax);
        currentMax = Math.max(currentMax, node.val);
        currentMin = Math.min(currentMin, node.val);
        traverse(node.left, currentMax, currentMin);
        traverse(node.right, currentMax, currentMin);
    }

}
