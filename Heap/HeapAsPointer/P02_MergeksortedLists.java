/*23. Merge k Sorted Lists
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Example 2: Input: lists = []  ,  Output: []
Example 3: Input: lists = [[]]  ,  Output: []
Constraints:
k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104. */
package Heap.HeapAsPointer;

import java.util.*;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class P02_MergeksortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.value, b.value));
        for (int i = 0; i < lists.length; i++) {// lists.length means the number of linked lists, not the number of
                                                // nodes
            if (lists[i] != null) {// insert 1st element of every list
                pq.add(lists[i]);
            }
        }
        // new ListNode(0) creates a single linked-list node whose value is 0.
        // new ListNode[0] creates an empty array of ListNode references.
        ListNode dummy = new ListNode(0); // diff b/w (0),[0]
        ListNode temp = dummy;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            // Attach smallest node to answer
            temp.next = curr;
            temp = temp.next;
            // Get next node from the same linked list
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return dummy.next;
    }

    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        for (int num : arr) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode[] lists = {
                createList(new int[] { 1, 4, 5 }),
                createList(new int[] { 1, 3, 4 }),
                createList(new int[] { 2, 6 })
        };

        ListNode result = mergeKLists(lists);

        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
// Time O(N log K) Each node is inserted and removed from the heap
// Space O(K) At most K nodes in the heap