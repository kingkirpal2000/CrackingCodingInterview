package datastructures;

public class LinkedList {
  Node head;

  public static class Node {
    int data;
    Node next;

    public Node(int num) {
      data = num;
    }
  }

  public void append(Node N) {
    Node begin = this.head;
    while (begin.next != null) {
      begin = begin.next;
    }
    begin.next = N;
    return;
  }

  public void delete(Node n) {
    if (head == null || n == null) {
      return;
    }
    if (this.head == n) {
      Node next = this.head.next;
      this.head = next;
      return;
    }
    Node nPrevious = this.head;
    while (nPrevious.next != n && nPrevious != null) {
      nPrevious = nPrevious.next;
    }
    nPrevious.next = n.next;
  }

  public Node search(int d) {
    if (head == null) {
      return null;
    }
    Node begin = this.head;
    if (begin.data == d) {
      return begin;
    }
    while (begin.next != null) {
      begin = begin.next;
      if (begin.data == d) {
        return begin;
      }
    }
    return null;
  }

  public void printList() {
    if (head == null) {
      return;
    }
    Node begin = this.head;
    System.out.print(begin.data + " ");
    while (begin.next != null) {
      begin = begin.next;
      System.out.print(begin.data + " ");
    }
    System.out.print("\n");
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.head = new Node(1);
    System.out.print("Printing list with 1 in it: ");
    list.printList();
    for (int i = 2; i <= 10; i++) {
      Node temp = new Node(i);
      list.append(temp);
    }
    System.out.print("Printing list with 10 consecutive numbers: ");
    list.printList();
    Node delete = list.search(4);
    list.delete(delete);
    System.out.print("Printing list after deleting 4: ");
    list.printList();
    delete = list.search(1);
    list.delete(delete);
    // System.out.println("Debug " + delete.data);
    System.out.println("Printing list after deleting head: ");
    list.printList();
    delete = list.search(10);
    list.delete(delete);
    System.out.println("Printing list after deleting tail: ");
    list.printList();
  }
}
