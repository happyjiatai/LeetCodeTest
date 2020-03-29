package com.example.a4_valid_parentheses;

import java.util.Stack;

public class MyClass {
    public static void main(String[] args) {
        System.out.println("isValid : " + isValid("([)]"));
    }

    public static boolean isValid(String s) {
        int length = s.length();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < length; i++) {
            switch (s.charAt(i)) {
                case '{':
                case '[':
                case '(':
                    stack.push(s.charAt(i));
                    break;
                case '}':
                    if (stack.isEmpty() || '{' != stack.pop()) {
                        return false;
                    }
                    break;

                case ']':
                    if (stack.isEmpty() || '[' != stack.pop()) {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || '(' != stack.pop()) {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

}
