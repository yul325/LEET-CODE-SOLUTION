class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        //init
        if(n <= 3)
            return n - 1;
        
        dp[0] = 0; dp[1] = 1; dp[2] = 2; dp[3] = 3;

        for(int i = 4; i <= n; i++){
            int max = 0;
            for(int j = 2; j < i; j++){
                int res = j * dp[i - j];
                if(res > max)
                    max = res;
            }
            dp[i] = max;
        }

        return dp[n];
    }
}