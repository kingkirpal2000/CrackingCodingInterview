package linkedlist;

import datastructures.LinkedList;

/**
 * Partition: Write code to partition a linked list around a value x, such that
 * all nodes less than x come before all nodes greater than or equal to x. If x
 * is contained within the list, the values of x only need to be after the
 * elements less than x (see below). The partition element x can appear anywhere
 * in the "right partition"; it does not need to appear between the left and
 * right partitions. EXAMPLE Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 ->1[partition=5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
class _02_04_Partition {

    LinkedListNode partition(LinkedListNode head, int x) {
        if (head == LinkedListNode.empty()) {
            return LinkedListNode.empty();
        }
        LinkedListNode left = null, right = null, leftCurr = null, rightCurr = null, curr = head;

        while (curr != null) {
            if (curr.val < x) {
                System.out.println("debug1");
                if (left == null) {
                    left = new LinkedListNode(curr.val);
                    leftCurr = left;
                } else {
                    leftCurr.next = new LinkedListNode(curr.val);
                    leftCurr = leftCurr.next;
                }
                curr = curr.next;
            } else {
                System.out.println("debug2");
                if (right == null) {
                    right = new LinkedListNode(curr.val);
                    rightCurr = right;
                } else {
                    rightCurr.next = new LinkedListNode(curr.val);
                    rightCurr = rightCurr.next;
                }
                curr = curr.next;
            }
        }

        if (leftCurr != null) {
            leftCurr.next = right;
            return left;
        } else {
            return right;
        }

    }

    public static void main(String[] args) {
        _02_04_Partition obj = new _02_04_Partition();
        LinkedListNode answer = obj.partition(LinkedListNode.of(3, 4, 2, 6, 1), 5);
        System.out.println(answer.toString());
    }
}
