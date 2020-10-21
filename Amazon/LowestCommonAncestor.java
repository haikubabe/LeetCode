package Amazon;

import java.util.*;

import Trees.TreeNode;

public class LowestCommonAncestor
{
    private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            map.put(root, null);
            queue.offer(root);
        }
        while (!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                map.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                map.put(node.right, node);
                queue.offer(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = map.get(p);
        }
        while (!ancestors.contains(q)) {
            q = map.get(q);
        }
        return q;
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
        TreeNode node = lca(root, root.left, root.left.left);
        System.out.println(node.val);
    }
}
