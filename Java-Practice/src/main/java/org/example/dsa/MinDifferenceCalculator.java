package org.example.dsa;

import java.util.*;

public class MinDifferenceCalculator {



    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;


        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Long> leftSums = new ArrayList<>();
        long leftSum = 0;

        for (int i = 0; i < len; i++) {
            maxHeap.offer(nums[i]);
            leftSum += nums[i];

            if (maxHeap.size() > n) {
                leftSum -= maxHeap.poll();
            }

            if (i >= n - 1) {
                leftSums.add(leftSum);
            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        List<Long> rightSums = new LinkedList<>();
        long rightSum = 0;

        for (int i = len - 1; i >= 0; i--) {
            minHeap.offer(nums[i]);
            rightSum += nums[i];

            if (minHeap.size() > n) {
                rightSum -= minHeap.poll();
            }

            if (i <= len - n) {
                rightSums.add(0, rightSum);
            }
        }

        long minDiff = Long.MAX_VALUE;

        Collections.reverse(rightSums);

        for (int i = 0; i < leftSums.size()/2; i++) {
            long diff = leftSums.get(i) - rightSums.get(i);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        MinDifferenceCalculator calc = new MinDifferenceCalculator();
        int[] nums = {3, 1, 2}; // example with n = 3
        long result = calc.minimumDifference(nums);
        System.out.println("Minimum Difference: " + result); // should be -17 for this input
    }
}
