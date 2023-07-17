public class Solution {
    ListNode result;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1 = 0;
        int size2 = 0;
        ListNode start = l1;
        while(l1 != null){
            size1++;
            l1 = l1.next;
        }
        l1 = start;
        start = l2;
        while(l2 != null){
            size2++;
            l2 = l2.next;
        }
        l2 = start;
        
        if(size1 > size2){
            for(int i = 0; i < size1 - size2; i++){
                ListNode addedNode = new ListNode(0);
                addedNode.next = l2;
                l2 = addedNode;
            }
        }
        else if(size2 > size1){
            for(int i = 0; i < size2 - size1; i++){
                ListNode addedNode = new ListNode(0);
                addedNode.next = l1;
                l1 = addedNode;
            }
        }

        result = new ListNode(0);
        if(solve(l1, l2, result) == 1){
            ListNode addedNode = new ListNode(1, result);
            result = addedNode;
        }
        return result;
    }

    int solve(ListNode l1, ListNode l2, ListNode result){
        int carry = 0;
        if(l1.next != null && l2.next != null){
            result.next = new ListNode(0);
            carry = solve(l1.next, l2.next, result.next);
        }

        int val = l1.val + l2.val + carry;
        if(val >= 10){
            val -= 10;
            result.val = val;
            return 1;
        }
        else{
            result.val = val;
            return 0;
        }
    }
}