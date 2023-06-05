public class test {
    public static void main(String args[]){
        int[][] isConnected = {{1,1,0},{1,1,0}, {0,0,1}};
        solutionInterface solution = new Solution();
        int a = solution.findCircleNum(isConnected);
    }
}
