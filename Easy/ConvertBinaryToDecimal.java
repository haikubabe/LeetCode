package Easy;

import LinkedList.ListNode;

/**
 * Leetcode - #1290
 */
public class ConvertBinaryToDecimal
{
    public static int getDecimalValue1(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp!= null) {
            len++;
            temp = temp.next;
        }
        temp = head;
        int decimal = 0;
        for (int i=len-1;i>=0;i--) {
            decimal += (temp.val * Math.pow(2,i));
            temp = temp.next;
        }
        return decimal;
    }

    public static int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = ans << 1 | head.val; // equivalent to ans = ans * 2 + head.val
            head = head.next;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(0);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(1);
        ListNode fifth = new ListNode(0);
        ListNode sixth = new ListNode(0);
        ListNode seventh = new ListNode(1);
        ListNode eighth = new ListNode(1);
        ListNode ninth = new ListNode(1);
        ListNode tenth = new ListNode(0);
        ListNode eleventh = new ListNode(0);
        ListNode twelfth = new ListNode(0);
        ListNode thirtheenth = new ListNode(0);
        ListNode fourtheenth = new ListNode(0);
        ListNode fiftheenth = new ListNode(0);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eighth;
        eighth.next = ninth;
        ninth.next = tenth;
        tenth.next = eleventh;
        eleventh.next = twelfth;
        twelfth.next = thirtheenth;
        thirtheenth.next = fourtheenth;
        fourtheenth.next = fiftheenth;

        System.out.println(getDecimalValue(head));
    }
}
