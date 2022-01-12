package stackqueue;

import java.util.Stack;

/**
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack,
 * but you may not copy the elements into any other data structure (such as an
 * array).
 * The stack supports the following operations: push, pop, peek, and isEmpty.
 */
class _03_05_SortStack {

    private int maxVal;
    private Stack<Integer> sorted;

    _03_05_SortStack() {
        maxVal = Integer.MIN_VALUE;
        sorted = new Stack<Integer>();
    }

    Stack<Integer> sort(Stack<Integer> stack) {
        int counter = stack.size();
        for (int i = 0; i < counter; i++) {
            int max = Integer.MIN_VALUE;
            Stack<Integer> temp = new Stack<Integer>();
            while (!stack.empty()) {
                if (stack.peek() > max) {
                    if (max != Integer.MIN_VALUE) {
                        temp.push(max);
                    }
                    max = stack.peek();
                    stack.pop();

                } else {
                    temp.push(stack.pop());
                }
            }
            sorted.push(max);
            while (!temp.empty()) {
                stack.push(temp.pop());
            }
            printStack();
        }

        return sorted;

    }

    void printStack() {
        Stack<Integer> s = (Stack<Integer>) sorted.clone();
        while (!s.empty()) {
            System.out.print(s.pop() + ";");
        }
        System.out.println();
    }

    void printStack(Stack<Integer> stack) {
        Stack<Integer> s = (Stack<Integer>) stack.clone();
        while (!s.empty()) {
            System.out.print(s.pop() + ";");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        _03_05_SortStack obj = new _03_05_SortStack();
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(5);
        s.push(4);
        s.push(3);
        obj.sort(s);

    }
}
