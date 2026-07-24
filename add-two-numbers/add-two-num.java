class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy head to easily return the final list
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        // Loop until both lists are empty and no carry remains
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            // Add value from the first list if it exists
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add value from the second list if it exists
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Calculate the new carry and the single digit to store
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return dummyHead.next;
    }
}
