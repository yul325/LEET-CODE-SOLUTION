public class test {
    public static void main(String args[]){
        solutionInterface solution = new Solution();
        int n = 500;
        int[][] edges = {{193,229},{133,212},{224,465}};
        double[] succProb = {0.91,0.78,0.64};
        int start = 4;
        int end = 364;

        double a = solution.maxProbability(n, edges, succProb, start, end);
    }
}
