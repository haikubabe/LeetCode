package Trees;

import java.util.Stack;

public class PathSumI
{

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum-root.val == 0) {
            return true;
        }
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }

    public static boolean hasPathSumI(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> node_stack = new Stack<>();
        Stack<Integer> sum_stack = new Stack<>();
        node_stack.push(root);
        sum_stack.push(sum-root.val);
        while (!node_stack.isEmpty()) {
            TreeNode current_node = node_stack.pop();
            int current_sum = sum_stack.pop();
            if (current_node.left == null && current_node.right == null && current_sum == 0) {
                return true;
            }
            if (current_node.left != null) {
                node_stack.push(current_node.left);
                sum_stack.push(current_sum-current_node.left.val);
            }
            if (current_node.right != null) {
                node_stack.push(current_node.right);
                sum_stack.push(current_sum-current_node.right.val);
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(root,22));
    }
}
