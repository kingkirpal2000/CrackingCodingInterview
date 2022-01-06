package stackqueue;

import java.util.EmptyStackException;

/**
 * How would you design a stack which, in addition to push and pop, has a
 * function min which returns the minimum element? Push, pop and min should all
 * operate in 0(1) time.
 */
public class _03_02_MinStack<T> {

    private static class StackNode<T> {
        private int data;
        private StackNode<Integer> next;

        public StackNode(int data) {
            this.data = data;
        }

    }

    private StackNode<Integer> top;
    private StackNode<Integer> min = new StackNode<Integer>(Integer.MAX_VALUE);

    void push(int val) {
        StackNode<Integer> newEntry = new StackNode<Integer>(val);
        newEntry.next = top;
        top = newEntry;

        if (val < min.data) {
            min = top;
        }

    }

    void printStack() {
        System.out.print("Stack = [ ");

        StackNode<Integer> t = top;

        while (t != null) {
            System.out.print(t.data + ", ");
            t = t.next;
        }

        System.out.println(" ]");
    }

    int pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        StackNode<Integer> t = top;

        if (min == top) {
            int newMin = Integer.MAX_VALUE;
            StackNode<Integer> x = top.next;
            if (x == null) {
                min = null;
            }
            StackNode<Integer> y = null;
            while (x != null) {

                if (x.data < newMin) {
                    System.out.println("Hit once");
                    y = x;
                    newMin = y.data;
                }
                x = x.next;
            }

            if (y == null) {
                min = x;
            } else {
                min = y;
            }

        }

        top = top.next;

        return t.data;

    }

    int min() {
        if (min != null) {
            System.out.println("Min = " + min.data);
            return min.data;
        } else {
            System.out.println("Min = STACK EMPTY");
            return Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        _03_02_MinStack<Integer> s = new _03_02_MinStack<Integer>();
        s.pop();
    }
}

// either maintain priority queue as obj attribute
// or you can search through stack eveerytime you pop
// or you can search through stack everytime you ask for min
