class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] hold = new int[n];
        int[] free = new int[n];

        for(int i = 0; i < n; i++){
            if(i == 0){
                hold[0] = -prices[0];
                free[0] = 0;
                continue;
            }
            hold[i] = Math.max(hold[i-1], free[i-1] - prices[i]);
            free[i] = Math.max(free[i-1], hold[i-1] - fee + prices[i]);
        }
        return Math.max(hold[n-1], free[n-1]);
    }
}