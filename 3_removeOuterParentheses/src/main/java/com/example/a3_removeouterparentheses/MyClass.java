package com.example.a3_removeouterparentheses;

import java.util.Stack;

public class MyClass {
    public static void main(String[] args) {
        System.out.println(getPrimitive("(()())(())"));
    }

    private static String getPrimitive(String s) {
        Stack stack = new Stack();
        StringBuilder stringBuilder = new StringBuilder();
        int indexOfPrimitive = 0;
        int length =  s.length();
        for (int i = 0; i < length; i++){
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
                if (stack.size() == 0) {
                    stringBuilder.append(s.substring(indexOfPrimitive + 1, i));
                    indexOfPrimitive = i+1;
                }
            }

        }
        return stringBuilder.toString();
    }

    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') --level;
            if (level >= 1) sb.append(c);
            if (c == '(') ++level;
        }
        return sb.toString();
    }
}
