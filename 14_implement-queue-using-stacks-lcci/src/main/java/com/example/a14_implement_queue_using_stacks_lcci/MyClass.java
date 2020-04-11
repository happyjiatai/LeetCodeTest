package com.example.a14_implement_queue_using_stacks_lcci;

import java.util.Stack;

public class MyClass {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(5);
        obj.push(4);
        obj.push(3);
        obj.push(2);
        obj.push(1);

        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println("result is " + param_2 + "--" + param_3 + "--" + param_4);
    }


}

class MyQueue {
    Stack<Integer> popStack = new Stack();
    Stack<Integer> pushStack = new Stack();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pushStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        transtion();
        return popStack.pop();
    }

    private void transtion() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        transtion();
        return popStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }
}
