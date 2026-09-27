/*234. Palindrome Linked List
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
Example 1: Input: head = [1,2,2,1]  ,  Output: true
Example 2: Input: head = [1,2]  ,  Output: false
Constraints:
The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
Follow up: Could you do it in O(n) time and O(1) space? */
package LinkedList.SlowAndFast;
public class P06_PalindromeLinkedList {
    public static  boolean isPalindrome(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=null;
        while(slow!=null){
            ListNode next=slow.next;
            slow.next=prev;
            prev=slow;
            slow=next;
        }
        ListNode firsthalf=head;
        ListNode sechalf=prev;
        while(sechalf!=null){
            if(firsthalf.val!=sechalf.val){
                return false;
            }else{
                firsthalf=firsthalf.next;
                sechalf=sechalf.next;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        // 1 → 1 → 2 → 3 → 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        boolean result = isPalindrome(head);
        System.out.println(result);
    }
}
//Time Complexity  = O(n)
// Space Complexity = O(1)

/*Find the middle using slow and fast
Reverse the second half
Compare first half with reversed second half */