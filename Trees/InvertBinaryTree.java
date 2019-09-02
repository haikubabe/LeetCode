import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode t = new TreeNode(root.val);
        t.left = invertTree(root.right);
        t.right = invertTree(root.left);
        return t;
    }

    private static TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            TreeNode temp = t.left;
            t.left = t.right;
            t.right = temp;
            if (t.left != null) {
                queue.add(t.left);
            }
            if (t.right != null) {
                queue.add(t.right);
            }
        }
        return root;
    }

    private static void printTree(TreeNode t) {
        if (t == null) {
            return;
        }
        System.out.println(t.val);
        printTree(t.left);
        printTree(t.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);
        printTree(invertTreeIterative(treeNode));
    }
}
