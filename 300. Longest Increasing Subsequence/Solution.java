import java.util.Arrays;
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxCount = 0;
        for(int i = 0; i < n; i++){
            for(int j = i-1; j >= 0; j--){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxCount = Math.max(dp[i], maxCount);
        }
        return maxCount;
    }
}