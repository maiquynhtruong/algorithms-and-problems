//http://ideone.com/FOxQZ3
//https://leetcode.com/articles/coin-change/#approach-3-dynamic-programming-bottom-up-accepted
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int nCoin = 1;
		int coins[] = new int[]{1};
		int amount = 2;
		System.out.println(coinChange(coins, amount));
	}

    public static int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) dp[i] = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++)
            if (coins[i] <= amount) dp[coins[i]] = 1;
        Arrays.sort(coins);
        for (int s = 0; s <= amount; s++)
            for (int j = 0; j < coins.length; j++)
                if (coins[j] <= s) 
                    dp[s] = Math.min(dp[s], 1 + dp[s-coins[j]]);
        // System.out.println(dp[amount]);
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
