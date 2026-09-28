/*237. Delete Node in a Linked List
There is a singly-linked list head and we want to delete a node node in it.
You are given the node to be deleted node. You will not be given access to the first node of head.
All the values of the linked list are unique, and it is guaranteed that the given node node is not the 
last node in the linked list.
Example 1: Input: head = [4,5,1,9], node = 5  ,  Output: [4,1,9]
Example 2: Input: head = [4,5,1,9], node = 1  ,  Output: [4,5,9] 
Constraints:
The number of the nodes in the given list is in the range [2, 1000].
-1000 <= Node.val <= 1000
The value of each node in the list is unique.
The node to be deleted is in the list and is not a tail node. */
package LinkedList.LL;
public class P09_DeleteNodeInLL {
    public static  void deleteNode(ListNode node){
        node.val=node.next.val;
        node.next=node.next.next;
    }
    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    public static void main(String[] args) {

        // 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        // Node to delete = 5
        ListNode node = head.next;

        deleteNode(node);

        printList(head);
    }
}
// Time Complexity: O(1)
// Space Complexity: O(1)

/*
Copy 1 into 5:
4 → 1 → 1 → 9
Then skip the duplicate 1:
4 → 1 → 9 */