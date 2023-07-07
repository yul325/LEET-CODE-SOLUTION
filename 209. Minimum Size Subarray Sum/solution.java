class Solution implements solutionInterface{
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        //loop from max size to 1
        for(int right = 0; right < n; right++){
            sum += nums[right];

            while(sum >= target){
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        if(result == Integer.MAX_VALUE)
            return 0;
        return result;
    }
}