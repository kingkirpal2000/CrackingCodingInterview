package stackqueue;

import java.util.EmptyStackException;

/**
 * How would you design a stack which, in addition to push and pop, has a
 * function min which returns the minimum element? Push, pop and min should all
 * operate in 0(1) time.
 */
class _03_02_MinStack<T> {
    private static class stackNode<T> {
        private int value;
        private int min;
        private stackNode<T> next;

        public stackNode(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    private stackNode<Integer> top;

    void push(int val) {
        int newMin = Math.min(val, min());
        stackNode<Integer> t = new stackNode<Integer>(val, newMin);
        t.next = top;
        top = t;
    }

    int pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        stackNode<Integer> t = top;
        top = top.next;
        return t.value;
    }

    void printStack() {
        System.out.print("Stack = [ ");

        stackNode<Integer> t = top;

        while (t != null) {
            System.out.print(t.value + ", ");
            t = t.next;
        }

        System.out.println(" ]");
    }

    int min() {
        stackNode<Integer> t = top;
        if (t != null) {
            return t.min;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        _03_02_MinStack<Integer> obj = new _03_02_MinStack<Integer>();
        obj.push(5);
        obj.printStack();
        obj.push(4);
        obj.push(6);
        obj.pop();
        System.out.println(obj.min());
        obj.pop();
        System.out.println(obj.min());
    }
}