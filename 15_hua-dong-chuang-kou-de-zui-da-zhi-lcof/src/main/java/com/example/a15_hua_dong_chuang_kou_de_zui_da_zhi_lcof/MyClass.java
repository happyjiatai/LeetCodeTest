package com.example.a15_hua_dong_chuang_kou_de_zui_da_zhi_lcof;

import java.util.Arrays;
import java.util.Stack;

public class MyClass {
    public static void main(String[] args) {
//        int[] nums = new int[]{};
//        int k = 3;
//        int[] maxs = new Solution().maxSlidingWindow(nums, k);
//        for(int i : maxs) {
//            System.out.println("---" + i);
//        }
    }

//    static class Solution {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums.length == 0){
                return new int[]{};
            }
            int[] maxs = new int[nums.length - k + 1];
            MyQueue myQueue = new MyQueue();
            for (int i = 0; i + k <= nums.length; i++) {
                if (i == 0) {
                    for (int j = 0; j < k; j++) {
                        myQueue.push(nums[j]);
                    }
                } else {
                    myQueue.pop();
                    myQueue.push(nums[i + k - 1]);
                }
                maxs[i] = myQueue.getMax();
            }
            return maxs;
        }


        class MyQueue {
            MaxStack popStack = new MaxStack();
            MaxStack pushStack = new MaxStack();

            /**
             * Initialize your data structure here.
             */
            public MyQueue() {

            }

            /**
             * Push element x to the back of queue.
             */
            public void push(int x) {
                pushStack.push(x);
            }

            /**
             * Removes the element from in front of queue and returns that element.
             */
            public int pop() {
                transtion();
                return popStack.pop();
            }

            private void transtion() {
                if (popStack.isEmpty()) {
                    while (!pushStack.isEmpty()) {
                        popStack.push(pushStack.pop());
                    }
                }
            }

            /**
             * Get the front element.
             */
            public int peek() {
                transtion();
                return popStack.peek();
            }

            /**
             * Returns whether the queue is empty.
             */
            public boolean empty() {
                return popStack.isEmpty() && pushStack.isEmpty();
            }

            public int getMax() {
                if (popStack.isEmpty()) {
                    return pushStack.getMax();
                } else if (pushStack.isEmpty()) {
                    return popStack.getMax();
                } else {
                    return popStack.getMax() > pushStack.getMax() ? popStack.getMax() : pushStack.getMax();
                }
            }
        }

        class MaxStack {
            Stack<Integer> stack = new Stack();
            Stack<Integer> maxStack = new Stack();

            /**
             * initialize your data structure here.
             */
            public MaxStack() {

            }

            public void push(int x) {
                stack.push(x);
                if (maxStack.isEmpty()) {
                    maxStack.push(x);
                } else if (x >= maxStack.peek()) {
                    maxStack.push(x);
                }
            }

            public int pop() {
                if (!stack.isEmpty()) {
                    int x = stack.pop();
                    if (x == maxStack.peek()) {
                        maxStack.pop();
                    }
                    return x;
                }
                throw new RuntimeException("pop for none");
            }

            public int peek() {
                return stack.peek();
            }

            public int getMax() {
                return maxStack.peek();
            }

            public boolean isEmpty() {
                return stack.isEmpty();
            }
        }
    }

}
