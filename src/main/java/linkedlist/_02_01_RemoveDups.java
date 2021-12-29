package linkedlist;

/**
 * Remove Dups! Write code to remove duplicates from an unsorted linked list.
 */
class _02_01_RemoveDups {

    LinkedListNode removeDups(LinkedListNode head) {
        if (head == null)
            return null;
        LinkedListNode current = head;
        while (current.next != null) {
            LinkedListNode key = current;
            LinkedListNode j = current;
            while (j.next != null) {
                if (j.next.val == key.val) {
                    j.next = j.next.next;
                } else {
                    j = j.next;
                }
            }
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedListNode list = LinkedListNode.of(1, 2, 2, 4);
        System.out.println(list.toString());
        _02_01_RemoveDups obj = new _02_01_RemoveDups();
        obj.removeDups(list);
        System.out.println(list.toString());
    }
}
