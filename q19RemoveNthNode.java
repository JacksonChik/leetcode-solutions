/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNhttps://leetcode.com/ode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int length = 1;
        while(cur.next != null){
            length++;
            cur = cur.next;
        }
        
        
        cur = head;
        ListNode previousOne = head;
        int secondPointer = 1;
        while(secondPointer != length - n + 1){
            if(secondPointer == length - n) previousOne = cur;
            cur = cur.next;
            secondPointer++;
        }
        
        ListNode nextOne = cur.next;        
        
        cur.next = null;
        previousOne.next = nextOne;
        
        if(n > length) return null;
        if(n == length) return head.next;
        return head;
    }
}