package org.example.dsa;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
    int max = 0;
    int sum = 0;
    Set<Integer> unique = new HashSet<>();
    public void trimSum( int i, int[] nums){
        for(int j : nums){
            if(j != i){
                sum -= j;
                unique.remove(j);
            } else {
                break;
            }
        }
    }
    public int maximumUniqueSubarray(int[] nums) {


        for(int i : nums){
            if(!unique.contains(i)){
                unique.add(i);
                sum += i;
            } else {
                max = Math.max(max, sum);
                trimSum(i, nums);
            }

        }
        max = Math.max(max, sum);

        return max;
    }

    public static void main(String[] args) {
        MaximumErasureValue value = new MaximumErasureValue();
        System.out.println(value.maximumUniqueSubarray(new int[]{187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434}));
    }
}

