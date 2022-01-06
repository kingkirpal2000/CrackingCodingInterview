package stackqueue;

/**
 * Describe how you could use a single array to implement three stacks
 */
class _03_01_ThreeInOne {
    int bound1, bound2, bound3;
    int current1, current2, current3;
    int[] s;

    _03_01_ThreeInOne(int initSize) {

        s = new int[initSize * 3];

        bound1 = initSize * 1;
        bound2 = initSize * 2;
        bound3 = initSize * 3;

        current1 = bound1 - 1;
        current2 = bound2 - 1;
        current3 = bound3 - 1;
    }

    void push(int stackNum, int val) {

        if (stackNum == 0) {
            if (current1 < 0) {
                throw new Error();
            }
            s[current1] = val;
            current1 = current1 - 1;

        } else if (stackNum == 1) {
            if (current2 < bound1) {
                throw new Error();
            }
            s[current2] = val;
            current2 = current2 - 1;
        } else if (stackNum == 2) {
            if (current3 < bound2) {
                throw new Error();
            }
            s[current3] = val;
            current3 = current3 - 1;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    int pop(int stackNum) {

        if (stackNum == 0) {
            int resultNum = 0;
            if (current1 + 1 < bound1) {
                current1 = current1 + 1;
                resultNum = s[current1];
                s[current1] = 0;
                return resultNum;
            } else {
                throw new Error("Tried to pop empty stack...");
            }
        } else if (stackNum == 1) {
            int resultNum = 0;
            if (current2 + 1 < bound2) {
                current2 = current2 + 1;
                resultNum = s[current2];
                s[current2] = 0;
                return resultNum;
            } else {
                throw new Error("Tried to pop empty stack...");
            }
        } else if (stackNum == 2) {
            int resultNum = 0;
            if (current3 + 1 < bound3) {
                current3 = current3 + 1;
                resultNum = s[current3];
                s[current3] = 0;
                return resultNum;
            } else {
                throw new Error("Tried to pop empty stack...");
            }
        } else {
            throw new UnsupportedOperationException();

        }

    }

    void printStack() {
        System.out.print("Stack = [ ");

        for (int i = 0; i < bound3; i++) {
            System.out.print(s[i] + ", ");

        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        _03_01_ThreeInOne obj = new _03_01_ThreeInOne(2);
        obj.push(0, 4);
        obj.push(0, 88);
        obj.push(1, 91);
        obj.push(1, 69);
        obj.push(2, 55);
        obj.push(2, 420);
        obj.pop(0);
        obj.pop(0);
        obj.pop(1);
        obj.pop(1);
        obj.pop(2);
        obj.pop(2);
        obj.printStack();
        System.out.println(obj.bound1);
    }
}
