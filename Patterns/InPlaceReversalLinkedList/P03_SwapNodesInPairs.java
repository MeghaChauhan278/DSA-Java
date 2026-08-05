/*24. Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head. You must solve the
problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
Example 1:Input: head = [1,2,3,4] , Output: [2,1,4,3]
Constraints: The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100 */
package Patterns.InPlaceReversalLinkedList;

public class P03_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode first=head;
        ListNode sec=head.next;

        while(first!=null && first.next!=null){
            ListNode third=sec.next;

            sec.next=first;//Reverse the pair.
            first.next=third;//Connect the first node to the remaining list.

//Only for the first pair, update the head because the second node becomes the new head after swapping. 
            if(prev==null){
                head=sec;
            }else{//Connect the previous swapped pair to the current swapped pair.
                prev.next=sec;
            }

            prev=first;//After swapping, first is now the last node of the current pair.
            first=third;//Move to the next pair.

//If another node exists after third, make it the second node of the next pair.
            if(third!=null){
                sec=third.next;
            }else{
                sec=null;
            }
        }
        return head;
    }
}
//T.C=O(n)
//S.C=O(1)
