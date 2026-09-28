/*19. Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Example 1: Input: head = [1,2,3,4,5], n = 2  ,  Output: [1,2,3,5]
Example 2: Input: head = [1], n = 1  ,  Output: []
Example 3: Input: head = [1,2], n = 1  ,  Output: [1]
Constraints:
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
Follow up: Could you do this in one pass? */
package LinkedList.LL;

public class P10_RemoveNthNodeFromEndofList {
    public static  ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        // Move fast n steps ahead
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        // If head has to be deleted
        if(fast==null){
            return head.next;
        }
        // Move both pointers
        while(fast.next!=null) {
            slow=slow.next;
            fast=fast.next;
        }
        // Delete the target node
        slow.next=slow.next.next;
        return head;
    
    }
    public static void main(String[] args) {

        // 1 → 2 → 3 → 4 → 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;

        head = removeNthFromEnd(head, n);

        // Print list
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)