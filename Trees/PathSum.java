public class PathSum {

    private static int pathHasSum(TreeNode root, int sum, int current) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val + current == sum) {
            count = 1;
        }
        return count + pathHasSum(root.left, sum, root.val+current) + pathHasSum(root.right, sum, root.val+current);
    }

    private static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathHasSum(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(-3);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.left.left = new TreeNode(3);
        treeNode.left.left.right = new TreeNode(-2);
        treeNode.left.right.right = new TreeNode(1);
        treeNode.right.right = new TreeNode(11);
        System.out.println(pathSum(treeNode, 8));
    }
}
