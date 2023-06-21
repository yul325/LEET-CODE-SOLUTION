public class test{
    public static void main(String args[]){
        int[] nums = {1,2,3,4,5,15};
        int[] cost = {2,2,2,3,4,1000};
        solutionInterface solution = new Solution();
        long a = solution.minCost(nums, cost);
    }
}