package com.example.demo.data.structure;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] sums = {1,3,5,7,9};
        int[] index = twoSum(sums, 8);
        for (int i = 0; i < index.length; i++) {
            System.out.println(index[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(target - nums[i])) {
                return new int[]{i,result.get(target - nums[i])};
            }
            result.put(nums[i],i);
        }
        return new int[]{};
    }
}
