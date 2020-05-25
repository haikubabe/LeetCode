package thirty_day_challenge.May;

import java.util.ArrayList;
import java.util.Stack;

import Trees.TreeNode;

/**
 * Leetcode - #230
 */
public class KthSmallestElement
{
    private static int count = 0;

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int count = 0;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                count++;
                if (count == k) {
                    return current.val;
                }
                current = current.right;
            }
        }
        return -1;
    }

    public static int kthSmallestR(TreeNode root, int k) {
        ArrayList<Integer> arr = inorder(root,k,new ArrayList<>());
        return arr.get(k-1);
    }

    private static ArrayList<Integer> inorder(TreeNode root, int k, ArrayList<Integer> arr) {
        if (root == null) {
            return arr;
        }
        inorder(root.left,k,arr);
        arr.add(root.val);
        inorder(root.right,k,arr);
        return arr;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(9);
        root.left.left.left = new TreeNode(6);
        System.out.println(kthSmallestR(root,3));
    }
}
