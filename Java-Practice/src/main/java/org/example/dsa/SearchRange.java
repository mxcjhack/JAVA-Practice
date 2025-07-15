package org.example.dsa;

import java.util.Arrays;
import java.util.List;

public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1};
        }
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .toList();

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){

            } else if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[] {-1, -1};

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
