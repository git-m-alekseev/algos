package ru.max.algos.dp.leetcode.jump2;

public class GreedySolution implements Solution {

    @Override
    public int minJumps(int[] nums) {
        int cur = nums.length - 1;
        int max = -1;
        int jumps = 0;
        while (cur > 0) {
            for (int i = cur - 1; i >= 0; i--) {
                if (nums[i] >= (cur - i)) {
                    max = i;
                }
            }
            cur = max;
            jumps++;
        }
        return jumps;
    }
}
