package thirty_day_challenge.June;

/**
 * Leetcode - #237
 */
public class DeleteNode
{
    static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static void printList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * delete a node from the linked list given the head pointer
     * @param head
     * @param node
     * @return
     */
    public static ListNode deleteNodeWithHead(ListNode head, ListNode node) {
        if (head.val == node.val) {
            head = head.next;
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        while (temp.val != node.val) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        return head;
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode(4);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(1);
        ListNode fourth = new ListNode(9);
        head.next = second;
        second.next = third;
        third.next = fourth;
        printList(head);
        ListNode newHead = deleteNodeWithHead(head, fourth);
        printList(newHead);
        deleteNode(second);
        printList(head);
    }
}
