package linkedlist;

import datastructures.LinkedList;

/**
 * Sum Lists: You have two numbers represented by a linked list, where each node
 * contains a single digit. The digits are stored in normal order, such that the
 * 1 's digit is at the tail of the list. Write a function that adds the two
 * numbers and returns the sum as a linked list.
 * <p>
 * EXAMPLE Input:(7-> 1 -> 6) + (5 -> 9 -> 2).That is, 716 + 592. Output:1 -> 4
 * -> 0 -> 8.That is, 1408.
 */
class _02_05_SumList {
    LinkedListNode appendtohead(LinkedListNode head, LinkedListNode append) {
        if (head == null) {
            head = append;
            return append;
        }
        append.next = head;
        return append;
    }

    LinkedListNode getTail(LinkedListNode head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    LinkedListNode delTail(LinkedListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        LinkedListNode curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    LinkedListNode sum(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode answerHead = null;
        LinkedListNode tail1 = null, tail2 = null;
        int carry = 0;
        int value = 0;
        while (l1 != null && l2 != null) {

            tail1 = getTail(l1);
            tail2 = getTail(l2);

            value = tail1.val + tail2.val + carry;
            if (value >= 10) {
                carry = value / 10;
                value = value % 10;
            } else {
                carry = 0;
            }
            System.out.println(carry);
            answerHead = appendtohead(answerHead, new LinkedListNode(value));
            l1 = delTail(l1);
            l2 = delTail(l2);
        }
        if (carry != 0 && l1 == null && l2 == null) {
            answerHead = appendtohead(answerHead, new LinkedListNode(carry));
        }

        while (l1 != null) {
            tail1 = getTail(l1);
            value = tail1.val + carry;
            System.out.println(value);
            if (value >= 10) {
                carry = value / 10;
                value = value % 10;
            } else {
                carry = 0;
            }

            answerHead = appendtohead(answerHead, new LinkedListNode(value));
            l1 = delTail(l1);
        }
        while (l2 != null) {
            tail2 = getTail(l2);
            value = tail2.val + carry;
            if (value >= 10) {
                carry = value / 10;
                value = value % 10;
            } else {
                carry = 0;
            }

            answerHead = appendtohead(answerHead, new LinkedListNode(value));
            l2 = delTail(l2);
        }

        return answerHead;
    }

    public static void main(String[] args) {
        _02_05_SumList obj = new _02_05_SumList();
        LinkedListNode l1 = LinkedListNode.of(7, 1, 6);
        LinkedListNode l2 = LinkedListNode.of(5, 9);
        LinkedListNode answer = obj.sum(l1, l2);
        System.out.println(answer.toString());
    }
}
