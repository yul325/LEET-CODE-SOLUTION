from typing import List

class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        dp = [0] * n
        
        dp[0] = cost[0]
        dp[1] = cost[1]

        for i in range(2, n):
            curCost = cost[i]
            dp[i] = min(dp[i - 1] + curCost, dp[i - 2] + curCost)

        return min(dp[n - 1], dp[n - 2])