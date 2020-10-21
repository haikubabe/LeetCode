package Amazon;

import Trees.TreeNode;

public class HeightOfBinaryTree
{
    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(3);
        root.right.right.left = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        System.out.println(height(root));
    }
}
