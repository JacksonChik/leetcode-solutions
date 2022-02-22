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
        ListNode resultHead = new ListNode();
        ListNode resultCur = resultHead;
        
        if(list1 == null && list2 == null){
            return null;
        }
        
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                resultCur.next = new ListNode(list1.val);
                list1 = list1.next;
                resultCur = resultCur.next;
            }
            else{
                resultCur.next = new ListNode(list2.val);
                list2 = list2.next;
                resultCur = resultCur.next;
            }
        }
        if(list1 == null && list2 != null){
            while(list2 != null){
                resultCur.next = new ListNode(list2.val);
                resultCur = resultCur.next;
                list2 = list2.next;

            }
        }
        else if(list1 !=null && list2 == null){
            while(list1 != null){
                resultCur.next = new ListNode(list1.val);
                resultCur = resultCur.next;
                list1 = list1.next;
            }
        }
        return resultHead.next;
    }
}