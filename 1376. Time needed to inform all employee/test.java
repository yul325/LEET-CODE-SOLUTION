public class test {
    public static void main(String args[]){
        solutionInterface solution = new Solution();
        //n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
        int n = 7;
        int headID = 6;
        int[] manager = {1,2,3,4,5,6,-1};
        int[] informTime = {0,6,5,4,3,2,1};
        int result = solution.numOfMinutes(n, headID, manager, informTime);
    }
}
