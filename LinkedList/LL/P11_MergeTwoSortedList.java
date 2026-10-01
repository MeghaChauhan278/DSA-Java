/*21. Merge Two Sorted Lists
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes 
of the first two lists.
Return the head of the merged linked list.
Example 1: Input: list1 = [1,2,4], list2 = [1,3,4]  ,  Output: [1,1,2,3,4,4]
Example 2: Input: list1 = [], list2 = []  ,  Output: []
Example 3: Input: list1 = [], list2 = [0]
Output: [0]
Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.*/
package LinkedList.LL;
public class P11_MergeTwoSortedList {
    public static  ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                curr.next=list1;
                list1=list1.next;
            }else{
                curr.next=list2;
                list2=list2.next;
            }
            curr=curr.next;
        }
        if(list1!=null){
            curr.next=list1;
        }else{
            curr.next=list2;
        }
        return dummy.next;
    }
    public static void printList(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // list1 = [1, 2, 4]
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // list2 = [1, 3, 4]
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // Merge
        ListNode result = mergeTwoLists(list1, list2);

        // Print result
        printList(result);
    }
}
// TC = O(n + m)
// SC = O(1)