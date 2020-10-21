package Amazon;

import Trees.TreeNode;

public class ConvertBinaryTreeToDLL
{
    private static Node head;
    private static Node curr;

    static class Node {
        private int val;
        private Node prev;
        private Node next;

        Node(int val) {
            this.val = val;
            this.prev =null;
            this.next = null;
        }
    }

    private static void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        convert(root.left);
        if (head == null) {
            head = new Node(root.val);
            curr = head;
        } else {
            Node node = new Node(root.val);
            curr.next = node;
            node.prev = curr;
            curr = node;
        }
        convert(root.right);
    }

    private static void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        convert(root);
        print();
    }
}
