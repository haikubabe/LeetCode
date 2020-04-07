package Trees;

public class RangeSumBST {
    private static int rangeSumBST(TreeNode root, int L, int R) {
        int sum=0;
        if (root != null) {
            if (root.val >= L && root.val <= R) {
                sum += root.val;
            }
            if (root.val>L) {
                sum += rangeSumBST(root.left,L,R);
            }
            if (root.val<R) {
                sum += rangeSumBST(root.right,L,R);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(treeNode, 7, 15));
    }
}
