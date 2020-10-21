package Amazon;

import java.util.LinkedList;
import java.util.Queue;

import Trees.TreeNode;

public class MaximumLevelSum
{
    static class TreeNodeLevel {
        private TreeNode node;
        private int level;

        private TreeNodeLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    private static int maxLevelSum(TreeNode root) {
        int maxLevelSum = Integer.MIN_VALUE;
        int maxLevel = -1;
        Queue<TreeNodeLevel> queue = new LinkedList<>();
        queue.offer(new TreeNodeLevel(root, 0));
        int currentLevelSum = 0;
        while (!queue.isEmpty()) {
            TreeNodeLevel temp = queue.poll();
            int currentLevel = temp.level;
            // check if it is a new level or not
            // if it is a new level then do levelSum = temp.node.val
            // else do levelSum += temp.node.val
            if (maxLevel < currentLevel) {
                maxLevel = currentLevel;
                currentLevelSum = temp.node.val;
            } else {
                currentLevelSum += temp.node.val;
            }
            if (maxLevelSum < currentLevelSum) {
                maxLevelSum = currentLevelSum;
            }
            if (temp.node.left != null) {
                queue.offer(new TreeNodeLevel(temp.node.left, currentLevel + 1));
            }
            if (temp.node.right != null) {
                queue.offer(new TreeNodeLevel(temp.node.right, currentLevel + 1));
            }
        }
        return maxLevelSum;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        System.out.println(maxLevelSum(root));
    }
}
