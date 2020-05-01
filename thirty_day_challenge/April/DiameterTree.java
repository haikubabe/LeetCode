package thirty_day_challenge.April;

/**
 * Leetcode - #543
 */
public class DiameterTree
{
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hLeft = height(root.left);
        int hRight = height(root.right);
        int dLeft = diameterOfBinaryTree(root.left);
        int dRight = diameterOfBinaryTree(root.right);
        return Math.max(hLeft+hRight,Math.max(dLeft,dRight));
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1+Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }
}
