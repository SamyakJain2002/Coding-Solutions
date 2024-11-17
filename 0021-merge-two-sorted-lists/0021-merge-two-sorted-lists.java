/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode temp = null;
        ListNode a = list1, b = list2;
        while (a != null && b != null) {
            if (a.val > b.val) {
                while (b != null && a.val > b.val) {
                    temp = b;
                    b = b.next;
                }
                temp.next = a;
            } else {
                while (a != null && b.val >= a.val) {
                    temp = a;
                    a = a.next;
                }
                temp.next = b;
            }
        }
        if (list1.val <= list2.val) {
            return list1;
        }
        return list2;
    }
}