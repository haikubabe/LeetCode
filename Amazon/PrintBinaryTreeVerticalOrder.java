package Amazon;

import Trees.TreeNode;

public class PrintBinaryTreeVerticalOrder
{
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    private static void findMinMaxHorizontalDist(TreeNode root, int hd) {
        if (root == null) {
            return;
        }
        if (hd < min) {
            min = hd;
        }
        if (hd > max) {
            max = hd;
        }
        findMinMaxHorizontalDist(root.left, hd-1);
        findMinMaxHorizontalDist(root.right, hd+1);
    }

    private static void printNodeAtVerticalLine(TreeNode root, int lineNo, int hd) {
        if (root == null) {
            return;
        }
        if (lineNo == hd) {
            System.out.print(root.val + " ");
        }
        printNodeAtVerticalLine(root.left, lineNo, hd-1);
        printNodeAtVerticalLine(root.right, lineNo, hd+1);
    }

    private static void printVerticalOrder(TreeNode root) {
        findMinMaxHorizontalDist(root, 0);
        for (int lineNo = min; lineNo <= max; lineNo++) {
            printNodeAtVerticalLine(root, lineNo, 0);
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        printVerticalOrder(root);
    }
}
