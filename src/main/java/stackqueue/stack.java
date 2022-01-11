package stackqueue;

import java.util.EmptyStackException;

public class stack<T> {

    private static class stackNode<T> {
        private T data;
        private stackNode<T> next;

        stackNode(T data) {
            this.data = data;
        }
    }

    private stackNode<T> top;

    T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }

        return top.data;
    }

    T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        stackNode<T> temp = top;
        top = top.next;

        return temp.data;
    }

    void push(T entry) {
        stackNode<T> newNode = new stackNode<T>(entry);

        newNode.next = top;
        top = newNode;

    }

    boolean isEmpty() {
        if (top == null) {
            return true;
        } else {
            return false;
        }
    }

    void print() {
        stackNode<T> it = top;
        while (it != null) {
            System.out.print(it.data + "; ");
            it = it.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        stack<Integer> t = new stack<Integer>();
        t.isEmpty();
        // t.push(55);
        // t.push(89);
        // t.push(25);
        // t.push(34);
        // t.print();
        // System.out.println(t.peek());
        // t.pop();
        // t.print();
    }
}
