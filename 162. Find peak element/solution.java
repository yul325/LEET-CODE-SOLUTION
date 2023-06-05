class Solution implements solutionInterface {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int middle = (n-1) / 2;
        if(n != 2)
            return solve(nums, middle, 0, n-1);
        else{
            if(nums[0] > nums[1])
                return 0;
            else
                return 1;
        }
    }

    public int solve(int[] nums, int index, int start, int end){
        int curNum = nums[index];

        if(index == 0 || index == nums.length - 1)
            return index;

        if(nums[index - 1] < curNum && nums[index + 1] < curNum)
            return index;
        else if(nums[index - 1] > curNum){
            //move left
            int nextIndex = (start + index) / 2;
            return solve(nums, nextIndex, start, index);

        }
        else if(nums[index + 1] > curNum){
            //move right
            int nextIndex = (end + index + 1) / 2;
            return solve(nums, nextIndex, index, end);
        }
        return -1;
    }
}