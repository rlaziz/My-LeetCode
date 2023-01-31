/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = getNext(list1,list2);
        if (newHead == null){
            return null;
        }
        if (newHead == list1){
            newHead.next = mergeTwoLists(list1.next,list2);
        }else {
            newHead.next = mergeTwoLists(list1,list2.next);
        }
        return newHead;
    }
    ListNode getNext(ListNode l1, ListNode l2){
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val > l2.val){
            return l2;
        }else {
            return l1;
        }
    }
}