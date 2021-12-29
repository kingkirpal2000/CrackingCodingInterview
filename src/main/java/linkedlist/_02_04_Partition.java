package linkedlist;

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
        LinkedListNode leftHead = null, leftCurr = null;
        LinkedListNode rightHead = null, rightCurr = null;
        while (head != null) {
            if (head.val < x) {
                if (leftHead == null) {
                    leftHead = new LinkedListNode(head.val);
                    leftCurr = leftHead;
                } else {
                    leftCurr.next = new LinkedListNode(head.val);
                    leftCurr = leftCurr.next;
                }
            } else {
                if (rightHead == null) {
                    rightHead = new LinkedListNode(head.val);
                    rightCurr = rightHead;
                } else {
                    rightCurr.next = new LinkedListNode(head.val);
                    rightCurr = rightCurr.next;
                }
            }
            head = head.next;
        }
        leftCurr.next = rightHead;
        return leftHead;
    }

    public static void main(String[] args) {
        _02_04_Partition obj = new _02_04_Partition();
        LinkedListNode answer = obj.partition(LinkedListNode.of(8, 7, 3, 6, 5, 2), 5);
        System.out.println(answer.toString());
    }
}
