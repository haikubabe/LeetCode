package Amazon;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import Trees.TreeNode;

public class TopView
{
    static class TreeNodeHd {
        private TreeNode node;
        private int hd;

        public TreeNodeHd(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    private static void printTree(TreeNode root) {
        Queue<TreeNodeHd> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.offer(new TreeNodeHd(root, 0));
        while (!queue.isEmpty()) {
            TreeNodeHd temp = queue.poll();
            if (!map.containsKey(temp.hd)) {
                map.put(temp.hd, temp.node.val);
            }
            if (temp.node.left != null) {
                queue.offer(new TreeNodeHd(temp.node.left, temp.hd-1));
            }
            if (temp.node.right != null) {
                queue.offer(new TreeNodeHd(temp.node.right, temp.hd+1));
            }
        }
        for (Integer val : map.values()) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        printTree(root);
        System.out.println();
    }
}
