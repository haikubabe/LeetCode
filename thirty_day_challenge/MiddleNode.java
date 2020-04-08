package thirty_day_challenge;

/**
 * Leetcode - #876
 */
public class MiddleNode
{
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        ListNode middle = head;
        int i=0;
        while (i<count/2 && middle != null) {
            middle = middle.next;
            i++;
        }
        return middle;
    }

    /**
     * another approach - using slow and fast pointer
     * @param head
     * @return
     */
    private static ListNode middleNode1st(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode middle = middleNode1st(head);
        printLinkedList(middle);
    }
}
