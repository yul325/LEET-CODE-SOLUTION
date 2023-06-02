public class test {
    public static void main(String args[]){
        solutionInterface solution = new Solution();
        //int[][] bombs = {{2,1,3},{6,1,4}};
        int[][] bombs = {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};
        int a = solution.maximumDetonation(bombs);
    }
}
