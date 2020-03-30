package com.example.a5_yong_liang_ge_zhan_shi_xian_dui_lie;

import java.util.Stack;

public class MyClass {
    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(5);
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
    }
}

class CQueue {
    Stack<Integer> aStack;
    Stack<Integer> bStack;
    public CQueue() {
        aStack = new Stack();
        bStack = new Stack();
    }

    public void appendTail(int value) {
        while (!aStack.isEmpty()) {
            bStack.push(aStack.pop());
        }
        aStack.push(value);
        while (!bStack.isEmpty()) {
            aStack.push(bStack.pop());
        }
    }

    public int deleteHead() {
        if (!aStack.isEmpty()) {
            return aStack.pop();
        }
        return -1;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

class CQueue2 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue2() {
        this.stack1 = new Stack();
        this.stack2 = new Stack();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {

        if(stack2.size()<=0){
            if(stack1.size()<=0) return -1;
            for(int i = stack1.size();i>0;i--){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}