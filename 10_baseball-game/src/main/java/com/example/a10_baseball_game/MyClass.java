package com.example.a10_baseball_game;

import java.util.Stack;

public class MyClass {

}

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        for (String s : ops) {
            if (s.equals("C")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (s.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (s.equals("+")) {
                if (stack.isEmpty()) {
                    break;
                }
                int score = stack.pop();
                if (stack.isEmpty()) {
                    stack.push(score);
                    stack.push(score);
                }
                int score_pre = stack.peek();
                stack.push(score);
                stack.push(score + score_pre);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        return sum;
    }
}