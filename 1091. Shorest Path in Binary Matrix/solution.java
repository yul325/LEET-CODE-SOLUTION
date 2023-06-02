import java.util.LinkedList;
import java.util.Queue;
class Solution implements solutionInterface{
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length][grid[0].length] == 1) return -1;
        
        int R = grid.length;
        int C = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        //vector direction
        int[] dR = {-1, -1, -1, 0, 0, +1, +1, +1};
        int[] dC = {-1, 0, +1, -1, +1, -1, 0, +1};
         
        int[] start = {0, 0};
        queue.add(start);
        grid[0][0] = 1;
        while(!queue.isEmpty()){
            int[] pop = queue.remove();
            for(int i = 0; i < 8; i++){
                int rr = dR[i] + pop[0];
                int cc = dC[i] + pop[1];
                if(rr < 0 || cc < 0) continue;
                if(rr >= R || cc >= C) continue;
                if(grid[rr][cc] != 0) continue;
                
                int val = grid[pop[0]][pop[1]];
                grid[rr][cc] = val + 1;
                int[] adj = {rr, cc};
                queue.add(adj);
            }
        }
        if(grid[R-1][C-1] == 0) return -1;
        return grid[R-1][C-1];
    }
}