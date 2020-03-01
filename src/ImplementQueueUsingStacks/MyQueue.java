package ImplementQueueUsingStacks;

import java.util.Stack;

class MyQueue {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        preparePush();
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        preparePop();
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        preparePop();
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void preparePush() {
        while (!outStack.isEmpty()) {
            inStack.push(outStack.pop());
        }
    }

    private void preparePop() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
