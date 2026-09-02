/*25. Reverse Nodes in k-Group
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes 
is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.
Example 1: Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5] */
package Patterns.InPlaceReversalLinkedList;

public class P04_ReverseNodesinKgroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head==null || k==1)
            return head;

        ListNode prev = null;
        ListNode first = head;

        while (first != null) {
            // Check whether k nodes exist
            ListNode check = first;
            int count = 0;

            while (check != null && count < k) {
                check = check.next;
                count++;
            }

            if (count<k)
                break;

            // Reverse k nodes
            ListNode curr = first;
            ListNode prevNode = null;

            count=0;

            while (count < k) {
                ListNode next = curr.next;
                curr.next = prevNode;
                prevNode = curr;
                curr = next;
                count++;
            }

            // First group
            if (prev==null)
                head = prevNode;
            else
                prev.next = prevNode;

            // Connect tail to remaining list
            first.next = curr;

            // Move pointers
            prev = first;
            first = curr;
        }
        return head;
    }
}
//T.C:O(n)
//S.C:O(1)
