package linkedlist;

/**
 * Sum Lists: You have two numbers represented by a linked list, where each node
 * contains a single digit. The digits are stored in reverse order, such that
 * the 1 's digit is at the head of the list. Write a function that adds the two
 * numbers and returns the sum as a linked list.
 * <p>
 * EXAMPLE Input:(7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295. Output:2 -> 1
 * -> 9.That is,912.
 */
class _02_05_SumListReverse {
    LinkedListNode append(LinkedListNode head, LinkedListNode app) {
        if (head == null) {
            head = app;
            return head;
        }
        LinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = app;
        return head;
    }

    LinkedListNode sum(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode answerHead = null;
        LinkedListNode l1Curr = l1, l2Curr = l2;
        int carry = 0;
        while (l1Curr != null && l2Curr != null) {
            int computed = l1Curr.val + l2Curr.val + carry;
            if (computed >= 10) {
                carry = computed / 10;
                computed = computed % 10;
            } else {
                carry = 0;
            }
            LinkedListNode val = new LinkedListNode(computed);
            answerHead = append(answerHead, val);
            l1Curr = l1Curr.next;
            l2Curr = l2Curr.next;
        }
        if (carry != 0 && l1Curr == null && l2Curr == null) {
            answerHead = append(answerHead, new LinkedListNode(carry));
            return answerHead;
        } else if (carry == 0 && l1Curr == null && l2Curr == null) {
            return answerHead;
        }
        while (l2Curr != null) {
            int computed = l2Curr.val + carry;
            if (computed >= 10) {
                carry = computed / 10;
                computed = computed % 10;
            } else {
                carry = 0;
            }
            answerHead = append(answerHead, new LinkedListNode(computed));
            l2Curr = l2Curr.next;
        }
        while (l1Curr != null) {
            int computed = l1Curr.val + carry;
            if (computed >= 10) {
                carry = computed / 10;
                computed = computed % 10;
            } else {
                carry = 0;
            }
            answerHead = append(answerHead, new LinkedListNode(computed));
            l1Curr = l1Curr.next;
        }
        return answerHead;
    }
}
