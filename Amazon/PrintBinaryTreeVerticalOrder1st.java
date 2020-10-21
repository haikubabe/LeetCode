package Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Trees.TreeNode;

public class PrintBinaryTreeVerticalOrder1st
{
    private static void printNodeAtVerticalLine(TreeNode root, int hd, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(hd)) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(hd, list);
        } else {
            map.get(hd).add(root.val);
        }

        printNodeAtVerticalLine(root.left, hd-1, map);
        printNodeAtVerticalLine(root.right, hd+1, map);
    }

    private static void printVerticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        printNodeAtVerticalLine(root, 0, map);
        for (List<Integer> nodes : map.values()) {
            for (int node : nodes) {
                System.out.print(node + " ");
            }
            System.out.println();
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
        root.right.right.left = new TreeNode(10);
        root.right.right.right = new TreeNode(9);
        root.right.right.left.right = new TreeNode(11);
        root.right.right.left.right.right = new TreeNode(12);
        printVerticalOrder(root);
    }
}
