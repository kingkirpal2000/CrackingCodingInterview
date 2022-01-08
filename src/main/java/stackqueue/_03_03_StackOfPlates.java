package stackqueue;

import java.util.ArrayList;
import java.util.EmptyStackException;

class _03_03_StackOfPlates {

    private static class stackNode<T> {
        private int value;
        private stackNode<T> next;

        public stackNode(int value) {
            this.value = value;
        }
    }

    private ArrayList<stackNode<Integer>> stacks;
    private int threshold;
    private int currentStackCounter;
    private int totalStackSize;

    _03_03_StackOfPlates(int threshold) {
        this.threshold = threshold;
        this.currentStackCounter = 0;
        this.totalStackSize = 0;
        this.stacks = new ArrayList<stackNode<Integer>>();

    }

    void push(int val) {
        stackNode<Integer> t = new stackNode<Integer>(val);

        if (currentStackCounter != 0) {
            t.next = stacks.get(0);
            stacks.remove(0);
        }

        stacks.add(0, t);
        currentStackCounter++;
        totalStackSize++;
        if (currentStackCounter == this.threshold) {
            currentStackCounter = 0;
        }

    }

    int pop() {
        if (stacks.size() == 0) {
            throw new EmptyStackException();
        }

        stackNode<Integer> t = stacks.get(0);
        if (t.next == null) {
            System.out.println("Debgu1" + stacks.size());
            stacks.remove(0);
        } else {
            System.out.println("ddbdg");
            stacks.set(0, stacks.get(0).next);
        }

        currentStackCounter--;
        return t.value;

    }

    int popAt(int stackNum) {
        if (stackNum >= stacks.size()) {
            throw new EmptyStackException();
        }

        stackNode<Integer> t = stacks.get(stackNum);
        if (t.next == null) {
            stacks.remove(stackNum);
        } else {
            if (stackNum != 0) {
                stackNode<Integer> s = stacks.get(stackNum - 1);
                while (s.next != null) {
                    s = s.next;
                }
                stacks.set(stackNum, s);
                s = stacks.get(stackNum - 1);
                while (s.next.next != null) {
                    s = s.next;
                }
                s.next = null;
            }

        }
        return t.value;
    }

    public static void main(String[] args) {
        _03_03_StackOfPlates stack = new _03_03_StackOfPlates(2);

        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        System.out.println(stack.popAt(1));
        System.out.println(stack.popAt(1));
        System.out.println(stack.pop());
        System.out.println(stack.popAt(0));

    }

}

// push(){
// have a pointer to current non empty stack
// throw all stacks in collection of linked list
// if current pointer's stack is not full add it
// else create a new stack, add number to stack, add stack to linkedlist, change
// current pointer
// }
