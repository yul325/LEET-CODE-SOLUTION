class Solution implements solutionInterface {
    //gggg
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int left = Integer.MAX_VALUE;
        int right = 0;
        for(int element: nums){
            if(element < left)
                left = element;
            if(element > right)
                right = element;
        }
        if(left == right) return 0;
        int mid = (left + right + 1) / 2;

        long result = Long.MAX_VALUE;
        long midResult = 0;
        long midPlusOne = 0;
        while(left < right){
            midPlusOne = 0;
            midResult = 0;
            for(int i = 0; i < n; i++){
                midResult +=  (long)Math.abs(mid - nums[i]) * cost[i];
                midPlusOne +=  (long)Math.abs(mid + 1 - nums[i]) * cost[i];
            }

            if(midResult < midPlusOne){
                right = mid;
                mid = (left + right) / 2;
            }
            else {
                left = mid + 1;
                mid = (left + right) / 2;
            }

            if(midResult < result)
                result = midResult;
            if(midPlusOne < result)
                result = midPlusOne;
        }
        return result;
    }
}