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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        int length = lists.length;
        while(length > 1) {
            for(int i = 0; i < length/2; i++) { 
                lists[i] = mergeTwoLists(lists[i], lists[length - 1 - i]);
            }
            length = (length + 1)/2;
        }
        return lists[0];
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode cursor = preHead;
        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                ListNode temp = l2;
                l2 = l1;
                l1 = temp;
            }
            cursor.next = l1;
            l1 = l1.next;
            cursor = cursor.next;
        }
        cursor.next = l1 == null? l2 : l1;
        return preHead.next;
    }
}