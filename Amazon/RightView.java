package Amazon;

import Trees.TreeNode;

public class RightView
{
    private static int maxLevel = -1;

    private static void rightView(TreeNode root) {
        rightViewUtil(root, 0);
    }

    private static void rightViewUtil(TreeNode root, int currLevel) {
        if (root == null) {
            return;
        }
        if (maxLevel < currLevel) {
            System.out.print(root.val + " ");
            maxLevel = currLevel;
        }
        rightViewUtil(root.right, currLevel+1);
        rightViewUtil(root.left, currLevel+1);
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(2);
        rightView(root);
        System.out.println();
    }
}
