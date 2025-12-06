package ru.max.algos.dp.kormen.ch15;

import java.util.Arrays;

public class Solutions {

    public static int recursive(int[] p, int len) {
        if (len == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, p[i] + recursive(p, len - i - 1));
        }
        return max;
    }

    public static int usingMemoization(int[] p, int len) {
        int[] memo = new int[len];
        Arrays.fill(memo, -1);
        return recWithMemo(p, len, memo);
    }

    public static int recWithMemo(int[] p, int len, int[] memo) {
        if (len == 0) {
            return 0;
        }
        if (memo[len - 1] != -1) {
            return memo[len - 1];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, p[i] + recWithMemo(p, len - i - 1, memo));
        }
        memo[len - 1] = max;
        return max;
    }

    public static int usingTabulation(int[] p, int len) {
        if (len == 0)
            return 0;

        int[] dp = new int[len];
        dp[0] = p[0];

        for (int i = 0; i < len; i++) {
            dp[i] = -1;
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], p[j] + dp[i - j - 1]);
            }
        }
        return dp[len - 1];
    }
}
