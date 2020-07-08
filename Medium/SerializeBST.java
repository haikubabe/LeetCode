package Medium;

import Trees.TreeNode;

/**
 * Leetcode - #449
 * Idea - using preorder
 */
public class SerializeBST
{
    public static String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serialize(root, str);
        return str.toString();
    }

    private static void serialize(TreeNode root, StringBuilder str) {
        if (root != null) {
            str.append(root.val).append(",");
            serialize(root.left, str);
            serialize(root.right, str);
        }
    }

    public static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(",");
        int[] index = new int[]{0};
        return deserialize(nodes, index, Integer.MAX_VALUE);
    }

    private static TreeNode deserialize(String[] nodes, int[] index, int upper) {
        if (index[0] == nodes.length || Integer.parseInt(nodes[index[0]]) > upper) {
            return null;
        }
        int val = Integer.parseInt(nodes[index[0]++]);
        TreeNode root = new TreeNode(val);
        root.left = deserialize(nodes, index, val);
        root.right = deserialize(nodes, index, upper);
        return root;
    }

    private static void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
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

        String res = serialize(root);
        System.out.println(res);
        preorder(deserialize(res));
    }
}
