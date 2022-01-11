package stackqueue;

import java.util.EmptyStackException;
import stackqueue.stack;

class _03_04_QueueViaStacks {
    private stack<Integer> oldStack;
    private stack<Integer> newStack;
    private int sizecounter;

    _03_04_QueueViaStacks() {
        oldStack = new stack<Integer>();
        newStack = new stack<Integer>();
        sizecounter = 0;
    }

    void enqueue(int val) {
        while (!oldStack.isEmpty()) {
            newStack.push(oldStack.pop());
        }
        oldStack.push(val);
        while (!newStack.isEmpty()) {
            oldStack.push(newStack.pop());
        }

        sizecounter++;
    }

    int size() {
        return sizecounter;
    }

    int peek() {
        if (oldStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return oldStack.peek();
    }

    int dequeue() {
        sizecounter--;
        return oldStack.pop();
    }

    public static void main(String[] args) {
        _03_04_QueueViaStacks s = new _03_04_QueueViaStacks();
        s.enqueue(1);
        s.enqueue(2);
        s.enqueue(3);
        System.out.println(s.size());
    }

}
