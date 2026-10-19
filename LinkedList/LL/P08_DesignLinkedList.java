/*707. Design Linked List
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
Example 1:
Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]
Constraints:
0 <= index, val <= 1000
Please do not use the built-in LinkedList library.
At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex. */
package LinkedList.LL;

public class P08_DesignLinkedList {
    class MyLinkedList {
        class Node {
            int val;
            Node next;

            Node(int val) {
                this.val = val;
                this.next = null;
            }
        }
        Node head;
        public MyLinkedList() {
            head = null;
        }

        public int get(int index) {
            Node curr = head;
            for (int i = 0; i < index; i++) {
                if (curr == null) {
                    return -1;
                }
                curr = curr.next;
            }
            if (curr == null) {
                return -1;
            }
            return curr.val;
        }

        public void addAtHead(int val) {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
        }

        public void addAtTail(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                return;
            }
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }

        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
                return;
            }
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                if (curr == null) {
                    return;
                }
                curr = curr.next;
            }
            if (curr == null) {
                return;
            }
            Node newNode = new Node(val);
            newNode.next = curr.next;
            curr.next = newNode;
        }

        public void deleteAtIndex(int index) {
            if (head == null) {
                return;
            }
            if (index == 0) {
                head = head.next;
                return;
            }
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                if (curr.next == null) {
                    return;
                }
                curr = curr.next;
            }
            if (curr.next == null) {
                return;
            }
            curr.next = curr.next.next;
        }
    }
}
