public class MergeSortedLists {
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode l3 = new ListNode(0);
        ListNode t3 = l3;
        ListNode t1 = l1, t2 = l2;
        while (t1 != null && t2 != null) {
            if (t1.val <= t2.val) {
                t3.next = new ListNode(t1.val);
                t1 = t1.next;
            } else {
                t3.next = new ListNode(t2.val);
                t2 = t2.next;
            }
            t3 = t3.next;
        }
        if (t1 != null) {
            t3.next = t1;
        }
        if (t2 != null) {
            t3.next = t2;
        }
        return l3.next;
    }

    private static ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode l3;
        if (l1.val <= l2.val) {
            l3 = new ListNode(l1.val);
            l3.next = mergeTwoListsRecursive(l1.next, l2);
        } else {
            l3 = new ListNode(l2.val);
            l3.next = mergeTwoListsRecursive(l1, l2.next);
        }
        return l3;
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
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = null;

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = null;

        ListNode l = mergeTwoLists(l1, l2);
        printList(l);

        printList(mergeTwoListsRecursive(l1, l2));
    }
}
