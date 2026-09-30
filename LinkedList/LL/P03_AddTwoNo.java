/*2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, 
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example 1: Input: l1 = [2,4,3], l2 = [5,6,4]  ,  Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2: Input: l1 = [0], l2 = [0]  ,  Output: [0]
Example 3: Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]  ,  Output: [8,9,9,9,0,0,0,1]
Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros. */
package LinkedList.LL;
public class P03_AddTwoNo {
    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int val1=(l1!=null)? l1.val : 0;
            int val2=(l2!=null)? l2.val : 0;
            int sum=val1+val2+carry;
            int digit=sum%10;//7 % 10 = 7
            carry=sum/10;//7/10=0
            curr.next=new ListNode(digit);
            curr=curr.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        return dummy.next;
    }
    public static void printList(ListNode head) { 
        while (head != null) { 
            System.out.print(head.val); 
            if (head.next != null) { 
                System.out.print(" -> "); 
            } head = head.next; } System.out.println(); 
        } 
    public static void main(String[] args) { 
        ListNode l1 = new ListNode(2); 
        l1.next = new ListNode(4); 
        l1.next.next = new ListNode(3); 

        ListNode l2 = new ListNode(5); 
        l2.next = new ListNode(6); 
        l2.next.next = new ListNode(4); 

        ListNode result = addTwoNumbers(l1, l2); 
        printList(result); 
    }
}
//Time: O(max(n, m))
//Space: O(max(n, m)) for the result list.