package Medium;

import Trees.TreeNode;

/**
 * Leetcode - #449
 * Idea - using postorder
 */
public class SerializeBST1
{
    public static String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serialize(root, str);
        return str.toString();
    }

    private static void serialize(TreeNode root, StringBuilder str) {
        if (root != null) {
            serialize(root.left, str);
            serialize(root.right, str);
            str.append(root.val).append(",");
        }
    }

    public static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(",");
        int[] index = new int[]{nodes.length-1};
        return deserialize(nodes, index, Integer.MIN_VALUE);
    }

    private static TreeNode deserialize(String[] nodes, int[] index, int lower) {
        if (index[0] < 0 || Integer.parseInt(nodes[index[0]]) < lower) {
            return null;
        }
        int val = Integer.parseInt(nodes[index[0]--]);
        TreeNode root = new TreeNode(val);
        root.right = deserialize(nodes, index, val);
        root.left = deserialize(nodes, index, lower);
        return root;
    }

    private static void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(2);
        root.left.right.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(10);

        String data = serialize(root);
        System.out.println(data);
        postorder(deserialize(data));
    }
}
