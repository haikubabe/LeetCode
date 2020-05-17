package thirty_day_challenge.May;

import Trees.TreeNode;

public class CousinsInBinaryTree
{
    private static int xDepth = -1;
    private static int yDepth = -1;
    private static TreeNode xParent = null;
    private static TreeNode yParent = null;

    public static boolean isCousins(TreeNode root, int x, int y) {
        findDepth(root,x,y);
        findParent(root, x, y);
        return xDepth == yDepth && xParent != yParent;
    }

    private static void findDepth(TreeNode root, int x, int y) {
        findDepthOfNode(root, x, y,0);
    }

    private static void findDepthOfNode(TreeNode root, int x, int y, int parentDepth) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            xDepth = parentDepth;
        } else if (root.val == y) {
            yDepth = parentDepth;
        }
        findDepthOfNode(root.left, x, y,parentDepth + 1);
        findDepthOfNode(root.right, x, y,parentDepth + 1);
    }

    private static void findParent(TreeNode root, int x, int y) {
        findParentOfNode(root, x, y,null);
    }

    private static void findParentOfNode(TreeNode root, int x, int y, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            xParent = parent;
        } else if (root.val == y) {
            yParent = parent;
        }
        findParentOfNode(root.left, x, y, root);
        findParentOfNode(root.right, x, y, root);
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(isCousins(root,2,3));
    }
}
