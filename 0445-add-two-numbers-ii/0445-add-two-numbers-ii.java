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
public ListNode addTwoNumbers(ListNode num1, ListNode num2) {
int len1 = findLength(num1);
int len2 = findLength(num2);

    if (len1 < len2) {
        num1 = paddWithZeros(num1, len2 - len1);
    } else if (len2 < len1) {
        num2 = paddWithZeros(num2, len1 - len2);
    }
    
    ListNode result = new ListNode(0);
    result = addTwoNumbersUtil(num1, num2, result);
    
    if (result.val == 0) {
        return result.next;
    }
    
    return result;
}

public ListNode addTwoNumbersUtil(ListNode num1, ListNode num2, ListNode result) {
    if (num1 == null && num2 == null) {
        return result;
    } else {
        result = addTwoNumbersUtil(num1.next, num2.next, result);

        int sum = num1.val + num2.val + result.val;
        int carry = sum / 10;
        sum = sum % 10;
        result.val = sum;
        ListNode carryNode = new ListNode(carry);
        carryNode.next = result;
        result = carryNode;

        return result;
    }
}

public int findLength(ListNode node) {
    int len = 0;
    while (node != null) {
        len++;
        node = node.next;
    }

    return len;
}

public ListNode paddWithZeros(ListNode node, int lenDiff) {
    while (lenDiff > 0) {
        ListNode newNode = new ListNode(0);
        newNode.next = node;
        node = newNode;
        lenDiff--;
    }
    return node;
}
}

