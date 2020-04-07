package Trees;

public class MaximumDepth {
    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(maxDepth(treeNode));
    }
}