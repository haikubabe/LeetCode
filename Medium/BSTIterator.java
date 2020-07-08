package Medium;

import java.util.ArrayList;
import java.util.List;

import Trees.TreeNode;

/**
 * Leetcode - #173
 */
public class BSTIterator
{
    private List<Integer> nodes;
    private static int current;

    public BSTIterator(TreeNode root) {
        nodes = new ArrayList<>();
        inorder(root);
        current = 0;
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            nodes.add(root.val);
            inorder(root.right);
        }
    }

    public int next() {
        if (current < nodes.size()) {
            int element = nodes.get(current);
            current++;
            return element;
        }
        return -1;
    }

    public boolean hasNext() {
        return current < nodes.size();
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }
}
