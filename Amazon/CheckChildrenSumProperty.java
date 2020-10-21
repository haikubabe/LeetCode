package Amazon;

import Trees.TreeNode;

public class CheckChildrenSumProperty
{
    private static boolean checkChildrenSumProperty(TreeNode root) {
        // check if the root is null or if it is a leaf node
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        int leftChild = 0, rightChild = 0;
        if (root.left != null) {
            leftChild = root.left.val;
        }
        if (root.right != null) {
            rightChild = root.right.val;
        }
        return  (root.val == leftChild + rightChild &&
                 checkChildrenSumProperty(root.left) &&
                 checkChildrenSumProperty(root.right));
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(checkChildrenSumProperty(root));
    }
}
