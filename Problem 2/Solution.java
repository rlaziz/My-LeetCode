class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode currentL1 = l1;
        ListNode currentL2 = l2;

        ArrayList<Integer> result = new ArrayList<>();

        int currentSum = 0;
        int carry = 0;
        int reminder = 0;

        while (currentL1 != null || currentL2 != null){
            currentSum = 0;

            if(currentL1 == null){
                currentSum += currentL2.val;
                currentL2 = currentL2.next;
            }else if (currentL2 == null){
                currentSum += currentL1.val;
                currentL1 = currentL1.next;

            }else {
                currentSum += currentL1.val + currentL2.val;

                currentL1 = currentL1.next;
                currentL2 = currentL2.next;
            }

            currentSum += carry;

            if (currentSum > 9){ // i.e carry
                carry = currentSum / 10;
                reminder = currentSum % 10;
            }else {
                carry = 0;
                reminder = currentSum;
            }


            result.add(reminder);
        }
        if ( carry != 0 ) {
            result.add(1);
        }
        ListNode root = asLinkedList(result,0);
        return root;
    }

    static ListNode asLinkedList(ArrayList<Integer> from, int index){
        if (index >= from.size()){
            return null;
        }
        ListNode newNode = new ListNode(from.get(index));
        newNode.next = asLinkedList(from, index + 1);
        return newNode;
    }


}