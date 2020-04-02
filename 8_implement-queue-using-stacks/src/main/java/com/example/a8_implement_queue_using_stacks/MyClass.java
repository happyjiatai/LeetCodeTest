package com.example.a8_implement_queue_using_stacks;

import java.util.Stack;

public class MyClass {
    public static void main(String[] args) {

    }
}


class MyQueue {
    Stack<Integer> stack = new Stack();
    Stack<Integer> stack2 = new Stack();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        stack.push(x);
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

class MyQueue2 {
    Stack<Integer> stack = new Stack();
    Stack<Integer> stack2 = new Stack();

    /** Initialize your data structure here. */
    public MyQueue2() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        shift();
        return stack2.pop();
    }

    private void shift(){
        if(stack2.isEmpty()){
            while (!stack.isEmpty()){
                stack2.push(stack.pop());
            }
        }
    }

    /** Get the front element. */
    public int peek() {
        shift();
        return stack2.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && stack2.isEmpty();
    }
}