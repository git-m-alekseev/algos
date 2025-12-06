package ru.max.algos.dp.leetcode.jump2;

public class DpSolution implements Solution {

    @Override
    public int minJumps(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        int pk = 0;
        int Inf = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Inf;
            for (int j = 0; j < i; j++) {
                pk = nums[j] >= (i - j) ? 1 + dp[j] : Inf;
                dp[i] = Math.min(dp[i], pk);
            }
        }
        return dp[nums.length - 1];
    }
}
