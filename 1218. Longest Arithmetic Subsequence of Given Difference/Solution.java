import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;

        int[] dp = new int[n];
        HashMap<Integer, Integer> dpMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(i == 0){
                dp[0] = 1;
                dpMap.put(arr[0], 1);
                continue;
            }

            if(dpMap.get(arr[i] - difference) == null){
                dpMap.put(arr[i], 1);
                dp[i] = dp[i - 1];
            }
            else{
                int cur = dpMap.get(arr[i] - difference) + 1;
                dp[i] = Math.max(dp[i-1], cur);
                dpMap.put(arr[i], cur);
            }
        }

        return dp[n-1];
    }
}