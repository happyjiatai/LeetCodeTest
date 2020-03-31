package com.example.a6_min_stack;

import java.util.Stack;

public class MyClass {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

class MinStack {
    Stack<Integer> mStack;
    Stack<Integer> mStack2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        mStack = new Stack<Integer>();
        mStack2 = new Stack<Integer>();
    }

    public void push(int x) {
        mStack.push(x);
        if (mStack2.isEmpty() || mStack2.peek() >= x) {
            mStack2.push(x);
        }// else {
        //mStack2.push(mStack2.peek());
        //}
    }

    public void pop() {
        int i = mStack.pop();
        //mStack2.pop();
        if (i == mStack2.peek()) {
            mStack2.pop();
        }
    }

    public int top() {
        return mStack.peek();
    }

    public int getMin() {
        return mStack2.peek();
    }
}

class MinStack2 {
    Stack<Integer> mStack;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        mStack = new Stack<Integer>();
    }

    public void push(int x) {
        mStack.push(x);
    }

    public void pop() {
        mStack.pop();
    }

    public int top() {
        return mStack.peek();
    }

    public int getMin() {
        Stack<Integer> stack = new Stack<Integer>();
        int min = Integer.MAX_VALUE;
        while (!mStack.isEmpty()) {
            int i = mStack.pop();
            if (i < min) {
                min = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            mStack.push(stack.pop());
        }
        return min;
    }
}


class MinStack3 {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    public void push(int x) {
        //当前值更小
        if (x <= min) {
            //将之前的最小值保存
            stack.push(min);
            //更新最小值
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        //如果弹出的值是最小值，那么将下一个元素更新为最小值
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}


class MinStack4 {
    Node head;

    //每次加入的节点放到头部
    public void push(int x) {
        if (null == head) {
            head = new Node(x, x);
        } else {
            //当前值和之前头结点的最小值较小的做为当前的 min
            Node n = new Node(x, Math.min(x, head.min));
            n.next = head;
            head = n;
        }
    }

    public void pop() {
        if (head != null)
            head = head.next;
    }

    public int top() {
        if (head != null)
            return head.value;
        return -1;
    }

    public int getMin() {
        if (null != head) {
            return head.min;
        }
        return -1;
    }

    class Node {
        int value;
        int min;
        Node next;

        Node(int x, int min) {
            this.value = x;
            this.min = min;
            next = null;
        }
    }
}