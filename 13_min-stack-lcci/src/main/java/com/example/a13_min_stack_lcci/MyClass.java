package com.example.a13_min_stack_lcci;

import java.util.Stack;

public class MyClass {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(4);
        obj.push(3);
        obj.push(5);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println("out is " + param_3 + "   " + param_4);
    }
}

class MinStack {
    Stack<Integer> stack = new Stack();
    Stack<Integer> minStack = new Stack();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else if (x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            if (x == minStack.peek()) {
                minStack.pop();
            }
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
