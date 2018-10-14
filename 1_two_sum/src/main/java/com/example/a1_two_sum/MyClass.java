package com.example.a1_two_sum;


import java.util.HashMap;
import java.util.Map;

public class MyClass {
    public static void main(String args[]){
        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[]{12,32,54,1}, 55);
        if (null == result){
            System.out.println("null");
        }else{
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for(int i : result){
                stringBuilder.append(i);
                stringBuilder.append(",");
            }
            stringBuilder.deleteCharAt(4);
            stringBuilder.append("]");
            System.out.println(stringBuilder);
        }
        return;
    }
}

class Solution{
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(target == nums[i] + nums[j]){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
