/*2095. Delete the Middle Node of a Linked List
You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, 
where ⌊x⌋ denotes the largest integer less than or equal to x.
For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
Example 1: Input: head = [1,3,4,7,1,2,6]  ,  Output: [1,3,4,1,2,6] 
Example 2: Input: head = [1,2,3,4]  ,  Output: [1,2,4]
Example 3: Input: head = [2,1]  ,  Output: [2]
Constraints:
The number of nodes in the list is in the range [1, 105].
1 <= Node.val <= 105*/
package LinkedList.LL;
public class P13_DeleteTheMiddleNodeOfALinkedList {
    public static  ListNode deleteMiddle(ListNode head) {
        if(head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=slow.next;
        return head;
    }
    public static void main(String[] args) {

        // Creating the linked list:
        // 1 → 3 → 4 → 7 → 1 → 2 → 6

        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);

        // Delete middle node
        head = deleteMiddle(head);

        // Print the linked list
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
// TC: O(n)
// SC: O(1)