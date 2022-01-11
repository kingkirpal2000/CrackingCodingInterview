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

    _03_03_StackOfPlates(int threshold) {
        this.threshold = threshold;
        this.currentStackCounter = 0;
        this.stacks = new ArrayList<stackNode<Integer>>();

    }

    void printStacks() {
        for (int i = 0; i < stacks.size(); i++) {
            stackNode<Integer> t = stacks.get(i);
            System.out.print("Stack " + i + ": ");
            while (t != null) {
                System.out.print(t.value + "; ");
                t = t.next;

            }
            System.out.println("");
        }
    }

    void push(int val) {
        int nextCounter = stacks.size() - 1;
        stackNode<Integer> t = new stackNode<Integer>(val);

        if (currentStackCounter != 0) {
            t.next = stacks.get(nextCounter);
            stacks.remove(nextCounter);
        }

        stacks.add(t);
        currentStackCounter++;
        if (currentStackCounter == this.threshold) {
            currentStackCounter = 0;
        }

    }

    int pop() {
        if (stacks.size() == 0) {
            throw new EmptyStackException();
        }

        int lastCounter = stacks.size() - 1;
        stackNode<Integer> t = stacks.get(lastCounter);
        if (t.next == null) {
            stacks.remove(lastCounter);
        } else {
            stacks.set(lastCounter, stacks.get(lastCounter).next);
        }

        currentStackCounter--;
        return t.value;
    }

    stackNode<Integer> popBottom(int stackNum) {
        stackNode<Integer> t = stacks.get(stackNum);
        while (t.next != null) {
            t = t.next;
        }

        stackNode<Integer> x = stacks.get(stackNum);
        if (x.next != null) {
            while (x.next.next != null) {
                x = x.next;
            }
        }

        x.next = null;
        return t;
    }

    int popAt(int stackNum) {
        stackNode<Integer> t = stacks.get(stackNum);

        stacks.set(stackNum, stacks.get(stackNum).next);
        for (int i = stackNum + 1; i < stacks.size(); i++) {
            stackNode<Integer> btm = popBottom(i);
            btm.next = stacks.get(i - 1);
            stacks.set(i - 1, btm);
        }
        currentStackCounter--;

        if (currentStackCounter < 0) {
            currentStackCounter = threshold + currentStackCounter;
        }

        if (currentStackCounter == 0) {
            stacks.remove(stacks.size() - 1);
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
        stack.printStacks();

        System.out.println(stack.popAt(1));
        stack.printStacks();
        System.out.println(stack.currentStackCounter);

        System.out.println(stack.popAt(1));
        stack.printStacks();
        System.out.println(stack.currentStackCounter);

        // System.out.println(stack.pop());
        // System.out.println(stack.popAt(0));
    }

}

// push(){
// have a pointer to current non empty stack
// throw all stacks in collection of linked list
// if current pointer's stack is not full add it
// else create a new stack, add number to stack, add stack to linkedlist, change
// current pointer
// }
