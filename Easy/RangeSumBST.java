package Easy;

import java.util.Stack;

import Trees.TreeNode;

/**
 * Leetcode - #938
 */
public class RangeSumBST
{

    /**
     * Approach 1
     */
    public static int rangeSumBST(TreeNode root, int L, int R) {
        // base case
        if (root == null) {
            return 0;
        }
        //when root node falls outside the range [L,R]
        //case 1: when root node is less than L, consider only the right branch
        //no need to consider the left branch
        if (root.val < L) {
            return rangeSumBST(root.right,L,R);
        }
        //case 2: when root node is greater than R, consider only the left branch
        //no need to consider the right branch
        if (root.val > R) {
            return rangeSumBST(root.left,L,R);
        }
        //when root node is in between L and R i.e. L<=root.val<=R
        //consider both the children
        return root.val + rangeSumBST(root.left,L,R) + rangeSumBST(root.right,L,R);
    }

    /**
     * Approach 2
     */
    public static int rangeSumBST1(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        return (L <= root.val && root.val <= R ? root.val : 0) + rangeSumBST1(root.left,L,R) + rangeSumBST1(root.right,L,R);
    }

    /**
     * Approach 3
     */
    public static int rangeSumBST2(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int sum=0;
        //if root node is in between L and R
        if (L <= root.val && root.val <= R) {
            sum += root.val;
        }
        // left child is a possible candidate
        if (L < root.val) {
            sum += rangeSumBST2(root.left,L,R);
        }
        //right child is a possible candidate
        if (root.val < R) {
            sum += rangeSumBST2(root.right,L,R);
        }
        return sum;
    }

    /**
     * Approach 4
     */
    public static int rangeSumBSTI(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (L <= current.val && current.val <= R) {
                sum += current.val;
            }
            if (L < current.val && current.left != null) {
                stack.push(current.left);
            }
            if (current.val < R && current.right != null) {
                stack.push(current.right);
            }
        }
        return sum;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(root,3,7));
    }
}
