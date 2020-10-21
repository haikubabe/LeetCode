package Amazon;

import Trees.TreeNode;

public class LeftView
{
    private static int maxLevel = -1;

    private static void printLeftView(TreeNode root) {
        printLeftViewUtil(root, 0);
    }

    private static void printLeftViewUtil(TreeNode root, int currLevel) {
        if (root == null) {
            return;
        }
        if (maxLevel < currLevel) {
            System.out.print(root.val + " ");
            maxLevel = currLevel;
        }
        printLeftViewUtil(root.left, currLevel + 1);
        printLeftViewUtil(root.right, currLevel + 1);
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(2);
        printLeftView(root);
        System.out.println();
    }
}
