package thirty_day_challenge.April;

import java.util.LinkedList;
import java.util.Queue;

import Trees.TreeNode;

/**
 * Leetcode - #1008
 */
public class BSTFromPreorder
{
    private static TreeNode constructBST(int[] preorder, int start, int end) {
        TreeNode root = null;
        if (start <= end) {
            root = new TreeNode(preorder[start]);
            int new_end = start+1;
            if (new_end < preorder.length && preorder[start+1] < preorder[start]) {
                while (new_end < preorder.length && preorder[new_end] < preorder[start]) {
                    new_end++;
                }
                root.left = constructBST(preorder,start+1,new_end-1);
            }
            root.right = constructBST(preorder,new_end, end);
        }
        return root;
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        return constructBST(preorder,0,preorder.length-1);
    }

    private static void breadthFirstSearch(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
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
