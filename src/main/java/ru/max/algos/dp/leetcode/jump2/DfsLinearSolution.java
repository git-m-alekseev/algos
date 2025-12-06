package ru.max.algos.dp.leetcode.jump2;

public class DfsLinearSolution implements Solution {

    @Override
    public int minJumps(int[] nums) {
        int curEnd = 0;
        int farthest = 0;
        int jumps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (curEnd == i) {
                jumps++;
                curEnd = farthest;
            }
        }

        return jumps;
    }
}
