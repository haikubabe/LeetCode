package thirty_day_challenge.May;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Trees.TreeNode;

/**
 * Leetcode - #1008
 */
public class BSTFromPreorderTraversal
{

    private static int index;

    /**
     * Iterative approach
     * @param preorder
     * @return
     */
    public static TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i=1;i<preorder.length ;i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (preorder[i] < stack.peek().val) {
                stack.peek().left = node;
            } else {
                TreeNode parent = stack.peek();
                while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }
        return root;
    }

    /**
     * 1st recursive approach, Time Complexity = O(n^2)
     * @param preorder
     * @return
     */
    public static TreeNode bstFromPreorderRecursive(int[] preorder) {
        if (preorder == null) {
            return null;
        }
        return bstFromPreorderRecursiveUtil(preorder, 0, preorder.length - 1);
    }

    private static TreeNode bstFromPreorderRecursiveUtil(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        // first element of the preorder array will be the root of the tree
        TreeNode root = new TreeNode(preorder[start]);

        // find the element which is greater than the root, as all the elements between the root (excluding) and this element (excluding)
        // will be the part of the left subtree of the root
        // and all the elements including the element greater than the root till the end of the element in the
        // preorder array will be the part of the right subtree of the root
        int i;
        for (i=start;i<=end;i++) {
            if (preorder[i] > root.val) {
                break;
            }
        }
        root.left = bstFromPreorderRecursiveUtil(preorder, start + 1, i - 1);
        root.right = bstFromPreorderRecursiveUtil(preorder, i, end);
        return root;
    }

    /**
     * 2nd recursive approach, Time Complexity = O(n)
     * @param preorder
     * @return
     */
    public static TreeNode bstFromPreorderLowerAndUpperBound(int[] preorder) {
        if (preorder == null) {
            return null;
        }
        index = 0;
        return bstFromPreorderLowerAndUpperBoundUtil(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Using Lower and Upper bound for each node
     * @param preorder
     * @param min
     * @param max
     * @return
     */
    private static TreeNode bstFromPreorderLowerAndUpperBoundUtil(int[] preorder, int min, int max) {
        if (preorder.length == index || preorder[index] < min || preorder[index] > max) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = bstFromPreorderLowerAndUpperBoundUtil(preorder, min, root.val);
        root.right = bstFromPreorderLowerAndUpperBoundUtil(preorder, root.val, max);
        return root;
    }

    /**
     * 3rd recursive approach, Time Complexity = O(n)
     * @param preorder
     * @return
     */
    private static TreeNode bstFromPreorderUpperBound(int[] preorder) {
        if (preorder == null) {
            return null;
        }
        index = 0;
        return bstFromPreorderUpperBoundUtil(preorder,Integer.MAX_VALUE);
    }

    /**
     * Using only upper bound
     * @param preorder
     * @param max
     * @return
     */
    private static TreeNode bstFromPreorderUpperBoundUtil(int[] preorder, int max) {
        if (preorder.length == index || preorder[index] > max) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = bstFromPreorderUpperBoundUtil(preorder,root.val);
        root.right = bstFromPreorderUpperBoundUtil(preorder,max);
        return root;
    }

    /**
     * BFS for printing the tree
     * @param root
     */
    private static void breadthFirstSearch(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args)
    {
        int[] preorder = {8,5,1,7,10,12};
        TreeNode root = bstFromPreorder(preorder);
        breadthFirstSearch(root);
    }
}
