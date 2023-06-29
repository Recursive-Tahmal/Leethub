
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        int tmp = 0;
        do {
            int x = head1.val;
            head1.val = (head1.val + head2.val + tmp) % 10;
            tmp = (x + head2.val + tmp) / 10;

            if (head1.next == null && head2.next != null) {
                head1.next = new ListNode(0, null);
            } else if (head1.next != null && head2.next == null) {
                head2.next = new ListNode(0, null);
            } else if (head1.next == null && head2.next == null && tmp != 0) {
                head1.next = new ListNode(0, null);
                head2.next = new ListNode(0, null);
            }

            head1 = head1.next;
            head2 = head2.next;
        } while (head1 != null && head2 != null || tmp != 0);
        return l1;
    }
}
