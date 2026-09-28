/*61. Rotate List
Given the head of a linked list, rotate the list to the right by k places.
Example 1: Input: head = [1,2,3,4,5], k = 2  ,  Output: [4,5,1,2,3]
Example 2: Input: head = [0,1,2], k = 4  ,  Output: [2,0,1]
Constraints:
The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109 */
package LinkedList.LL;

public class P06_RotateList {
    public static  ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length
        int n = 1;
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
            n++;
        }

        // Avoid unnecessary rotations
        k = k % n;

        if (k == 0) {
            return head;
        }

        // Make the list circular
        temp.next = head;

        // Find the new tail
        int steps = n - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // New head is after new tail
        ListNode newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }
    public static void main(String[] args) {

        // 1 → 2 → 3 → 4 → 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        head = rotateRight(head, k);

        // Print list
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
// TC: O(n)
// SC: O(1)