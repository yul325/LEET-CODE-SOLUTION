import java.util.List;

class Solution {
    public static void main(String args[]){
        ListNode head = new ListNode();
        ListNode l1 = new ListNode();
        l1.val = 2;
        head = l1;
        l1.next = new ListNode(4);
        l1 = l1.next;
        l1.next = new ListNode(3);
        l1 = head;
        ListNode l2 = new ListNode();
        l2.val = 5;
        head = l2;
        l2.next = new ListNode(6);
        l2 = l2.next;
        l2.next = new ListNode(4);
        l2 = head;
        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;
        ListNode pre = null;
        int adder = 0;
        while(l1 != null && l2 != null){
            int sum = (l1.val + l2.val) % 10;
            result.val = sum + adder;

            if( (l1.val + l2.val + adder) >= 10 )
                adder = 1;
            else 
                adder = 0;
            l1 = l1.next;
            l2 = l2.next;
            pre = result;
            result.next = new ListNode();
            result = result.next;
        }
        pre.next = null;
        result = head;
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }
}