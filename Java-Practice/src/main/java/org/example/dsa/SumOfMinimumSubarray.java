package org.example.dsa;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SumOfMinimumSubarray {
    public static int recursion(PriorityQueue<Integer> list, int[] arr, int i){
        if(i < arr.length){
            int j = list.peek();
            list.add(arr[i]);
            return j + recursion(list, arr, i + 1);
        } else {
            return list.peek();
        }

    }
    public static int sumSubarrayMins(int[] arr) {
        int sum = 0;

        for(int i = 0 ; i < arr.length ; i++){
            sum = sum + recursion(new PriorityQueue<>(List.of(arr[i])), arr, i + 1);
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }
}
