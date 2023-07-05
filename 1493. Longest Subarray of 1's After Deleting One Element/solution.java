class Solution {
    public int longestSubarray(int[] nums) {
        int result = 0;
        int preCounts = 0;
        int counts = 0;
        boolean zeroflag = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1)
                counts++;
            else if(nums[i] == 0){
                if(preCounts + counts > result)
                    result = preCounts + counts;
                preCounts = counts;
                counts = 0;
                zeroflag = true;
            }
            
            if(i == nums.length && (preCounts + counts > result))
                result = preCounts + counts;

        }
        
        if(zeroflag == false)
            return nums.length - 1;
        else 
            return result;
    }
}