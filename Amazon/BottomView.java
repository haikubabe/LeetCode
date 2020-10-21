package Amazon;

import java.util.Map;
import java.util.TreeMap;

import Trees.TreeNode;

public class BottomView
{
    static class Pair {
        private int val;
        private int depth;

        Pair(int val, int depth) {
            this.val = val;
            this.depth = depth;
        }
    }

    private static void bottomView(TreeNode root, int hd, int depth, Map<Integer, Pair> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(hd)) {
            map.put(hd, new Pair(root.val, depth));
        } else if (depth > map.get(hd).depth) {
            map.put(hd, new Pair(root.val, depth));
        }
        bottomView(root.left, hd-1, depth+1, map);
        bottomView(root.right, hd+1, depth+1, map);
    }

    private static void printBottomView(TreeNode root) {
        Map<Integer, Pair> map = new TreeMap<>();
        bottomView(root, 0, 0, map);
        for (Pair pair : map.values()) {
            System.out.print(pair.val + " ");
        }
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right.right = new TreeNode(25);
        printBottomView(root);
        System.out.println();
    }
}
