class Solution {
    public static void main(String args[]){
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] > max)
                max = nums[i];
        }
        int[] range = new int[max + 1];
        for(int i = 0; i < nums.length; i++){
            if(range[nums[i]] == 1)
                return nums[i];
            else 
                range[nums[i]]++;
        }
        return 0;
    }
}