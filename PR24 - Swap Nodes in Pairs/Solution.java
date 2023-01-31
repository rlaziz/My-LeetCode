class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while(current != null && current.next != null){
            if (current == head){ // Special Case
                ListNode temp = head.next;
                head.next = temp.next;
                temp.next = head;
                head = temp;
            }else {
                ListNode temp = current.next;
                current.next = temp.next;
                temp.next = current;
                prev.next = temp;
            }
            prev = current;
            current = current.next;
        }
        return head;
    }
}