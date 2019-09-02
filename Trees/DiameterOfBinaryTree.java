public class DiameterOfBinaryTree {
    private static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = height(root.left);
        int leftR = height(root.right);
        int leftD = diameterOfBinaryTree(root.left);
        int rightD = diameterOfBinaryTree(root.right);
        return Math.max(leftH+leftR, Math.max(leftD, rightD));
    }

    private static int height(TreeNode root) {
        if (root == null) return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(diameterOfBinaryTree(treeNode));
    }
}
