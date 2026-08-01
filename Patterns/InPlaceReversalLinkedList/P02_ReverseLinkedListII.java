/*92. Reverse Linked List II
Given the head of a singly linked list and two integers left and right where left <= right,
reverse the nodes of the list from position left to position right, and return the reversed list.
Example 1: Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Constraints:
The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n*/
package Patterns.InPlaceReversalLinkedList;
import java.util.*;
public class P02_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right){
        //if 1 element
        if(head==null && left==right){
            return head;
        }
        ListNode prev=null;
        ListNode curr=head;
        //moving prev, curr -> correct position
        for(int i=0;curr!=null && i<left-1;i++){
            prev=curr;
            curr=curr.next;
        }
        //store prev and curr ,bcoz at last we will join them
        ListNode firstpart=prev;
        ListNode lastnodeSublist=curr;

        //reverse elements
        for(int i=0;curr!=null && i<right-left+1;i++){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //joining remaining elements
        if(firstpart!=null){
            firstpart.next=prev;
        }else{
            head=prev;
        }
        lastnodeSublist.next=curr;
        return head;
    }
}
// T.C = O(n)
// S.C = O(1)