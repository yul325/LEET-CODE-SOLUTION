import java.util.*;
//
class Solution implements solutionInterface{
    public int longestArithSeqLength(int[] nums) {
        int result = 0;
        HashMap<String, Integer> dp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int diff = Math.abs(nums[j] - nums[i]);
                String left = i + "+" + diff;  //int[] left = {i, diff};
                String right = j + "+" + diff;//int[] right = {j, diff};
                if(dp.get(left) != null)
                    dp.put(right, dp.get(left) + 1);
                else 
                    dp.put(right, 2);
                result = Math.max(dp.get(right), result);
            }
        }
        return result;
    }
}