package com.example.a17_last_stone_weight;

import java.util.Arrays;

public class MyClass {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println("Solution is " + new Solution().lastStoneWeight(stones));
    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        //初始化最大堆
        initMaxHeap(stones);
        System.out.println("Solution" + Arrays.toString(stones));
        int size = stones.length;
        while (size > 1) {
            //移除并记录第二大的元素，将最后一个数值与第二大数组进行交换,第二大位置进行下沉操作
            int second = (size > 2) ? ((stones[1] > stones[2]) ? 1 : 2) : 1;
            int secondValue = stones[second];
            swap(second, size - 1, stones);
            size--;
            sink(second, stones, size);
            System.out.println("Solution" + Arrays.toString(stones));
            //第一大元素减去第二大元素，若为0，则和最后一个元素作交换，对位置0进行下沉操作
            stones[0] = stones[0] - secondValue;
            if (stones[0] == 0) {
                swap(0, size - 1, stones);
                size--;
            }
            sink(0, stones, size);
            System.out.println("Solution" + Arrays.toString(stones));
        }


        return size == 0 ? 0 : stones[0];
    }

    void initMaxHeap(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            rise(i, arr);
        }
    }

    void rise(int index, int[] arr) {
        int i = index;
        int parent = (i - 1) / 2;
        while (i != 0 && arr[parent] < arr[i]) {
            swap(parent, i, arr);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    void sink(int index, int[] arr, int size) {
        while (true) {
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index + 2;
            if (leftIndex > size - 1) {
                //没有左孩子
                return;
            }
            if (rightIndex > size - 1) {
                //没有右孩子
                if (arr[index] < arr[leftIndex]) {
                    swap(index, leftIndex, arr);
                }
                return;
            }
            int swapIndex = arr[leftIndex] > arr[rightIndex] ? leftIndex : rightIndex;
            if (arr[swapIndex] > arr[index]) {
                swap(swapIndex, index, arr);
                index = swapIndex;
            } else {
                return;
            }
        }
    }

    void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}