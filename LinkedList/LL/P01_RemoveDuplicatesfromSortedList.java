/*83. Remove Duplicates from Sorted List
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. 
Return the linked list sorted as well.
Example 1: Input: head = [1,1,2]  ,  Output: [1,2]
Example 2: Input: head = [1,1,2,3,3]  ,  Output: [1,2,3]
Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
 */
package LinkedList.LL;
public class P01_RemoveDuplicatesfromSortedList {
    public static  ListNode deleteDuplicates(ListNode head){
        ListNode curr=head;
        while(curr!=null && curr.next!=null){
            if(curr.val==curr.next.val){
                curr.next=curr.next.next;
            }else{
                curr=curr.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {

        // 1 → 1 → 2 → 3 → 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        head = deleteDuplicates(head);

        // Print linked list
        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
// TC: O(n)
// SC: O(1)