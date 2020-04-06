package com.example.a12_remove_all_adjacent_duplicates_in_string;

import java.util.Stack;

public class MyClass {
    public static void main(String[] args) {
        System.out.println("111" + new Solution().removeDuplicates("abbaca"));
    }
}


class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
}
