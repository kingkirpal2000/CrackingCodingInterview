package linkedlist;

import datastructures.LinkedList;

/**
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 */
class _02_06_Palindrome {

    LinkedListNode appendtohead(LinkedListNode list, LinkedListNode append) {
        if (list == null) {
            list = append;
            return list;
        } else {
            append.next = list;
            return append;
        }
    }

    boolean isPalindrome(LinkedListNode head) {
        if (head == null) {
            return true;
        }
        LinkedListNode current = head;
        LinkedListNode compare = null;
        while (current != null) {
            compare = appendtohead(compare, new LinkedListNode(current.val));
            current = current.next;
        }
        return head.equals(compare);
    }

}
