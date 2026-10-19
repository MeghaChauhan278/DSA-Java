/*86. Partition List
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes 
greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
Example 1: Input: head = [1,4,3,2,5,2], x = 3  ,  Output: [1,2,2,4,3,5]
Example 2: Input: head = [2,1], x = 2  ,  Output: [1,2]
Constraints:
The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200 */
package LinkedList.LL;
public class P07_PartitionList {
    public static  ListNode partition(ListNode head, int x){
        ListNode lessdummy=new ListNode(0);
        ListNode greaterdummy=new ListNode(0);
        ListNode less=lessdummy;
        ListNode greater=greaterdummy;
        while(head!=null){
            if(head.val<x){
                less.next=head;
                less=less.next;
            }else{
                greater.next=head;
                greater=greater.next;
            }
            head=head.next;
        }
        greater.next=null;
        less.next=greaterdummy.next;
        return lessdummy.next;
    }
    public static void main(String[] args) {
        // Input: [1, 4, 3, 2, 5, 2], x = 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int x = 3;

        head = partition(head, x);

        System.out.print("Output: [");
        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(", ");
            }
            curr = curr.next;
        }
        System.out.println("]");
    }
}
// TC:O(n)
// SC:O(1)