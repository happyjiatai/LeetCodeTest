package com.example.a11_backspace_string_compare;

import java.util.Stack;

public class MyClass {
    public static void main(String[] args) {
        String S = "nzp#o#g";
        String T = "b#nzp#o#g";
        System.out.println("the result is " + new Solution2().backspaceCompare(S, T));
    }
}

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack stack1 = getStack(S);
        Stack stack2 = getStack(T);
        if (!(stack1.size() == stack2.size())) {
            return false;
        } else {
            //return getStringFromStack(stack1).equals(getStringFromStack(stack2));
            return String.valueOf(stack1).equals(String.valueOf(stack2));
        }
    }

    private Stack getStack(String s) {
        Stack stack = new Stack();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '#':
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(c);
            }
        }
        return stack;
    }

    private String getStringFromStack(Stack s){
        StringBuilder stringBuilder = new StringBuilder();
        while(!s.isEmpty()){
            stringBuilder.append(s.pop());
        }
        return stringBuilder.toString();
    }
}

class Solution2 {
    public boolean backspaceCompare(String S, String T) {
        int indexS = S.length() -1;
        int indexT = T.length() -1;
        while(indexS >= 0 || indexT >= 0){
            indexS = getRealIndex(indexS, S);
            indexT = getRealIndex(indexT, T);
            if (indexS != -1 && indexT != -1
                    && S.charAt(indexS) != T.charAt(indexT)){
                return false;
            } else if ((indexS == -1) != (indexT == -1)){
                return false;
            }
            indexS --;
            indexT --;
        }
        return true;
    }

    private int getRealIndex(int index, String s){
        int skip = 0;
        for(int i = index; i >= 0; i--) {
            if(s.charAt(i) == '#'){
                skip++;
            } else if (skip > 0){
                skip --;
            } else {
                return i;
            }
        }
        return -1;
    }
}