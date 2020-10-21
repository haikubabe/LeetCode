package Amazon;

import java.util.Stack;

import Trees.TreeNode;

public class IterativePostorderTraversal
{
    private static void postorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root, prev = null;
        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            TreeNode node = stack.peek();
            // node.right != prev this is done to keep
            // track of the previously visited right child
            if (node.right != null && node.right != prev) {
                temp = node.right;
            } else {
                node = stack.pop();
                prev = node;
                System.out.print(node.val + " ");
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
        postorder(root);
        System.out.println();
    }
}
