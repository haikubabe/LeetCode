package Amazon;

import java.util.Stack;

import Trees.TreeNode;

public class IterativePreorderTraversal
{
    private static void preorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                stack.push(temp);
                System.out.print(temp.val + " ");
                temp = temp.left;
            }
            TreeNode node = stack.pop();
            if (node.right != null) {
                temp = node.right;
            }
        }
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.right = new TreeNode(23);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(2);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(6);
        preorder(root);
        System.out.println();
    }
}
