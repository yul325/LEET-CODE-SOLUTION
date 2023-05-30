class Solution {
    public static void main(String args[]){
        int[] nums = {5, 6, 7 ,8 , 9};
        findKthPositive(nums, 9);
    }

    public static int findKthPositive(int[] arr, int k) {
        int result = 0;
        int numOfmissing = 0;
        int prev = 0;
        for(int i = 0; i < arr.length; i++){
            numOfmissing += arr[i] - prev - 1;
            if(numOfmissing < k){
                prev = arr[i];
                continue;
            }
            else{
                result = arr[i] - (numOfmissing - k) - 1;
                break;
            }
        }

        if(numOfmissing < k)
            result = arr[arr.length - 1] + (k - numOfmissing);
        
        return result;
    }
}