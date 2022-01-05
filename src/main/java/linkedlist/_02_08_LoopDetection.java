package linkedlist;

import java.util.HashSet;

/**
 * Loop Detection: Given a circular linked list, implement an algorithm that
 * returns the node at the beginning of the loop.
 * <p>
 * DEFINITION Circular linked list: A (corrupt) linked list in which a node's
 * next pointer points to an earlier node, so as to make a loop in the linked
 * list.
 * <p>
 * EXAMPLE Input: A -> B -> C -> D -> E -> C[the same C as earlier] Output: C
 */

class _02_08_LoopDetection {

    LinkedListNode detect(LinkedListNode head) {
        if (head == null) {
            return null;
        }
        LinkedListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                break;
            }
        }
        if (slow == null || slow.next == null || fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }

    public static void main(String[] args) {
        _02_08_LoopDetection obj = new _02_08_LoopDetection();
        LinkedListNode list = LinkedListNode.of(1, 2, 3, 4, 5);
        list.next.next.next.next.next = list;

        LinkedListNode answer = obj.detect(list);
        System.out.println(answer.val);
    }
}
