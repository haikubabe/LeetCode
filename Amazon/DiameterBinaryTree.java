package Amazon;

import Trees.TreeNode;

public class DiameterBinaryTree
{
    private static int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int rootDiameter = 1 + leftHeight + rightHeight;
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(19);
        root.right = new TreeNode(18);
        root.left.left = new TreeNode(17);
        root.left.right = new TreeNode(16);
        root.left.left.left = new TreeNode(15);
        root.left.left.right = new TreeNode(14);
        root.left.left.right.left = new TreeNode(12);
        root.left.left.right.left.right = new TreeNode(9);
        root.left.right.right = new TreeNode(13);
        root.left.right.right.left = new TreeNode(11);
        root.left.right.right.right = new TreeNode(10);
        root.left.right.right.right.left = new TreeNode(8);
        System.out.println(diameter(root));
    }
}
