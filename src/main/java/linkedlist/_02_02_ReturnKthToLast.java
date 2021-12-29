package linkedlist;

import datastructures.LinkedList;

/**
 * Implement an algorithm to find the kth to last element of a singly linked
 * list
 * 
 */
class _02_02_ReturnKthToLast {

    LinkedListNode kthToLast(LinkedListNode head, int k) {
        int size = 0;
        LinkedListNode current = head;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        if (k > size || k < 0)
            return null;
        current = head;
        int index = size - k;
        int it = 0;
        while (it < index && current.next != null) {
            current = current.next;
            it = it + 1;
        }
        return current;
    }

    public static void main(String[] args) {
        _02_02_ReturnKthToLast obj = new _02_02_ReturnKthToLast();
        LinkedListNode list = LinkedListNode.of(1, 3, 5, 7, 9);
        int k = 2;
        obj.kthToLast(list, k);
    }
}
