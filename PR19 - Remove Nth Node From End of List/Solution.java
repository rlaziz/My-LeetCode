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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode current = head;
        while (current != null){
            nodes.add(current);
            current = current.next;
        }
        ListNode nth = nodes.get(nodes.size() - n);
        if (nodes.size() - n - 1 >= 0){
            nodes.get(nodes.size() - n - 1).next = nth.next;
        }else {
            head = nth.next;
        }
        return head;
    }
}