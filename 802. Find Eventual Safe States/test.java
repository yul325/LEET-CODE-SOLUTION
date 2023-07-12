import java.util.List;

public class test {
    public static void main(String args[]){
        Solution solution = new Solution();
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> a = solution.eventualSafeNodes(graph);
    }
}
