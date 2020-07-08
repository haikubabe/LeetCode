package Hard;

import Trees.TreeNode;

/**
 * Leetcode - #297
 */
public class SerializeBinaryTrees
{
    public static String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serialize(root, str);
        return str.toString();
    }

    private static void serialize(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("#").append(" ");
        } else {
            str.append(root.val).append(" ");
            serialize(root.left, str);
            serialize(root.right, str);
        }
    }

    public static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(" ");
        int[] index = new int[]{0};
        return deserialize(nodes, index);
    }

    private static TreeNode deserialize(String[] nodes, int[] index) {
        if (index[0] == nodes.length) {
            return null;
        }
        if (nodes[index[0]].equals("#")) {
            index[0]++;
            return null;
        }
        int val = Integer.parseInt(nodes[index[0]++]);
        TreeNode root = new TreeNode(val);
        root.left = deserialize(nodes, index);
        root.right = deserialize(nodes, index);
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String data = serialize(root);
        System.out.println(data);
        preorder(deserialize(data));
    }
}
