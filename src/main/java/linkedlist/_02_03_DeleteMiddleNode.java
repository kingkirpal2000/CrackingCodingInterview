package linkedlist;

/**
 * Implement an algorithm to delete a node in the middle(i.e., any node but the
 * first and last node, not necessarily the exact middle) of a singly linked
 * list, given only access to that node.
 */
class _02_03_DeleteMiddleNode {

    boolean deleteMiddleNode(LinkedListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        int data = node.next.val;
        node.val = data;
        node.next = node.next.next;
        return true;
    }

    public static void main(String[] args) {
        _02_03_DeleteMiddleNode obj = new _02_03_DeleteMiddleNode();
        LinkedListNode list = LinkedListNode.of(1, 2, 3, 4, 5, 6);
        LinkedListNode n = list.next.next.next;
        System.out.println(list.toString());
        obj.deleteMiddleNode(n);
        System.out.println(list.toString());
    }
}
