import java.util.*;
class Solution implements solutionInterface{
    public int singleNumber(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        Arrays.sort(nums);
        int count = 1;
        int pre = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(i == nums.length - 1)
                return nums[i];
            else if(pre == nums[i])
                count++;
            else if(count == 1)
                return nums[i - 1];
            else 
                count = 1;
            pre = nums[i];
        }
        return -1;
    }
}