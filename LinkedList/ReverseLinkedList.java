public class ReverseLinkedList {
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null, next;
        ListNode current = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return node;
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
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next = null;
        printList(reverseListRecursive(listNode));
    }
}
