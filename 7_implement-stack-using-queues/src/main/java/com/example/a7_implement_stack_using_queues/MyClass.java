package com.example.a7_implement_stack_using_queues;

import org.w3c.dom.Node;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MyClass {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);
        queue.add(0);


        queue.poll();
        System.out.println("queue : " + queue);
        System.out.println("queue : " + queue.isEmpty());
        System.out.println("queue : " + queue.peek());

    }
}


class MyStack {
    Queue<Integer> queue = new LinkedList();
    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size =  queue.size();
        for (int i = 0; i < size-1; i++){
            queue.add(queue.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

class MyStack3 {
    Queue<Integer> queue = new LinkedList();
    Queue<Integer> queue2 = new LinkedList();
    /** Initialize your data structure here. */
    public MyStack3() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (!queue2.isEmpty()){
            queue2.add(x);
        } else {
            queue.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (queue.isEmpty() && queue2.isEmpty()) {
            return Integer.MIN_VALUE;
        } else if (queue2.isEmpty()){
            while(queue.size() != 1){
                queue2.add(queue.poll());
            }
            return queue.poll();
        } else {
            while(queue2.size() != 1){
                queue.add(queue2.poll());
            }
            return queue2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        int value = pop();
        if (value != Integer.MIN_VALUE){
            if (!queue.isEmpty()){
                queue.add(value);
            } else {
                queue2.add(value);
            }
        }
        return value;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty() && queue2.isEmpty();
    }
}

class MyStack3_1 {
    Queue<Integer> queue = new LinkedList();
    Queue<Integer> queue2 = new LinkedList();
    /** Initialize your data structure here. */
    public MyStack3_1() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (!queue2.isEmpty()){
            queue.add(x);
            while(!queue2.isEmpty()){
                queue.add(queue2.poll());
            }
        } else {
            queue2.add(x);
            while(!queue.isEmpty()){
                queue2.add(queue.poll());
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (queue.isEmpty() && queue2.isEmpty()) {
            return Integer.MIN_VALUE;
        } else if (queue2.isEmpty()){
            return queue.poll();
        } else {
            return queue2.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if (queue.isEmpty() && queue2.isEmpty()) {
            return Integer.MIN_VALUE;
        } else if (queue2.isEmpty()){
            return queue.peek();
        } else {
            return queue2.peek();
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty() && queue2.isEmpty();
    }
}

class MyStack2 {
    class Node{
        int i;
        Node next;
        Node(int i, Node next){
            this.i = i;
            this.next = next;
        }
    }
    Node head;
    /** Initialize your data structure here. */
    public MyStack2() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (head == null){
            head = new Node(x, null);
        } else {
            Node node = new Node(x, head);
            head = node;
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (head != null) {
            int value = head.i;
            head = head.next;
            return value;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    /** Get the top element. */
    public int top() {
        if (head != null) {
            return head.i;
        } else {
            return Integer.MIN_VALUE;
        }

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return head == null;
    }
}