/*82. Remove Duplicates from Sorted List II
You are given the head of a sorted linked list.
Delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
Return the linked list sorted as well.
Example 1:  Input: head = [1,2,3,3,4,4,5]  ,  Output: [1,2,5]
Example 2:  Input: head = [1,1,1,2,3]  ,  Output: [2,3]
Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order. */
package LinkedList.LL;

public class P02_RemoveDuplicatesfromSortedListII {
    public static  ListNode deleteDuplicates(ListNode head){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=head;
        ListNode prev=dummy;
        while(curr!=null && curr.next!=null){
            if(curr.val==curr.next.val){
                int duplicate=curr.val;
                while(curr!=null && curr.val==duplicate){
                    curr=curr.next;
                }
                prev.next=curr;
            }else{
                prev=prev.next;
                curr=curr.next;
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {

        // 1 → 1 → 2 → 3 → 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

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