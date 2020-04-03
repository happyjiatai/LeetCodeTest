package com.example.a9_next_greater_element_i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class MyClass {
    public static void main(String[] args) {
        int[] ints = {1, 5};
    }
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int result[] = new int[nums1.length];
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                hashMap.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            hashMap.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = hashMap.get(nums1[i]);
        }
        return result;
    }
}


class Solution3 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int result[] = new int[nums1.length];
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums2.length; i++) {
            hashMap.put(nums2[i], -1);
            for (int j = i + 1; j < nums2.length; j++) {
                if (nums2[j] > nums2[i]) {
                    hashMap.put(nums2[i], nums2[j]);
                    break;
                }
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = hashMap.get(nums1[i]);
        }
        return result;
    }
}


class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        int[] result = new int[nums1.length];
        for (int i : nums2) {
            stack1.push(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            boolean flag = false;
            int value = Integer.MIN_VALUE;
            while (!stack1.isEmpty()) {
                int j = stack1.pop();
                stack2.push(j);
                if (j == nums1[i]) {
                    break;
                } else if (j > nums1[i]) {
                    flag = true;
                    value = j;
                }
            }
            result[i] = flag ? value : -1;
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        return result;
    }
}
