package linkedlist;

/**
 * Intersection: Given two (singly) linked lists, determine if the two lists
 * intersect. Return the intersecting node. Note that the intersection is de ned
 * based on reference, not value. That is, if the kth node of the first linked
 * list is the exact same node (by reference) as the jth node of the second
 * linked list, then they are intersecting.
 */
class _02_07_Intersection {
    LinkedListNode searching(LinkedListNode f, LinkedListNode i) {
        LinkedListNode curr = i;
        while (curr != f && curr != null) {
            curr = curr.next;
        }
        return curr;
    }

    boolean intersects(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode curr = l1;
        while (curr != null) {
            LinkedListNode returnNode = searching(curr, l2);
            if (returnNode != null) {
                return true;
            } else {
                curr = curr.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _02_07_Intersection obj = new _02_07_Intersection();
        LinkedListNode l1 = LinkedListNode.of(1, 4, 6, 3, 2);
        LinkedListNode l2 = l1.next.next;
        boolean answer = obj.intersects(l1, l2);
        System.out.println(answer);
    }
}
