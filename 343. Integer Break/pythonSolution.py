class Solution(object):
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 3:
            return n - 1
        dp = [0, 1, 2, 3]
        for i in range(4, n):
            max = 0
            for j in range(2, i):
                res = j * dp[i - j]
                if res > max:
                    max = res
            dp.append[max]
        return dp[n]
                
