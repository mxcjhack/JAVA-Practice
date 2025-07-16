package org.example.dsa;

import java.util.ArrayList;
import java.util.List;

public class FindTheMaximumLengthOfValidSubsequenceI {



    public static void main(String[] args) {
        System.out.println(maximumLength(new int[]{2,13,26,70,76}));
    }

    private static int maximumLength(int[] nums) {
        int[] count = new int[2];
        int[] end = new int[2];

        for (int num : nums) {
            int parity = num % 2;
            count[parity]++;
            end[parity] = end[1 - parity] + 1;
        }

        return Math.max(
                Math.max(count[0], count[1]),
                Math.max(end[0], end[1])
        );
    }
}
