package src;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        Integer[] dp = new Integer[amount+10];
        Arrays.fill(dp, 987654321);

        dp[0] = 0;
        int cnt = coins.length;
        for(int i = 0; i <= amount; i++) {
            for(int j = 0; j<cnt; j++) {
                if (i < coins[j]) continue;
                if (dp[i] > dp[i - coins[j]] + 1) {
                    dp[i] = (dp[i - coins[j]] + 1);
                }
            }
        }
        if(dp[amount] < 987654321) {
            return dp[amount];
        }
        return -1;
    }
}
