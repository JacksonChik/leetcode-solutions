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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode resultCur = result;
        while(l1 != null && l2 != null){
            int i = resultCur.next == null? 0 : resultCur.next.val;
            if(l1.val + l2.val + i> 9){
                    resultCur.next = new ListNode(l1.val + l2.val + i - 10);
                    resultCur = resultCur.next;
                    resultCur.next = new ListNode(1);
            }
            else{
                    if(resultCur.next == null){
                        resultCur.next = new ListNode(l1.val + l2.val);
                        resultCur = resultCur.next;
                    }
                    else{
                        resultCur.next.val = resultCur.next.val + l1.val + l2.val;
                        resultCur = resultCur.next;
                    }
            }
            l1=l1.next;
            l2=l2.next;
        }
        
        while(l1 == null && l2 != null){
            int i = resultCur.next == null? 0 : resultCur.next.val;
            
                if( l2.val + i> 9){
                    resultCur.next = new ListNode(l2.val + i - 10);
                    resultCur = resultCur.next;
                    resultCur.next = new ListNode(1);
                }
            
                else{
                    if(resultCur.next == null){
                        resultCur.next = new ListNode(l2.val);
                        resultCur = resultCur.next;
                    }
                    else{
                        resultCur.next.val = resultCur.next.val + l2.val;
                        resultCur = resultCur.next;
                    }
                }
            l2=l2.next;
        }
        
        while(l2 == null && l1 != null){
            int i = resultCur.next == null? 0 : resultCur.next.val;
            
                if( l1.val + i> 9){
                    resultCur.next = new ListNode(l1.val + i - 10);
                    resultCur = resultCur.next;
                    resultCur.next = new ListNode(1);
                }
            
                else{
                    if(resultCur.next == null){
                        resultCur.next = new ListNode(l1.val);
                        resultCur = resultCur.next;
                    }
                    else{
                        resultCur.next.val = resultCur.next.val + l1.val;
                        resultCur = resultCur.next;
                    }
                }
            l1=l1.next;
        }
        
        
        return result.next;
    }
}