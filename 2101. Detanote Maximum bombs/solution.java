import java.util.ArrayList;
import java.util.Stack;
import java.util.Iterator;

class Solution implements solutionInterface{
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        //adding directed edges on each node
        for(int sphere1 = 0; sphere1 < n; sphere1++){
            ArrayList<Integer> neighbor = new ArrayList<>();
            int x0 = bombs[sphere1][0];
            int y0 = bombs[sphere1][1];
            for(int sphere2 = 0; sphere2 < n; sphere2++){
                if(sphere1 == sphere2)
                    continue;
                else{
                    int x1 = bombs[sphere2][0];
                    int y1 = bombs[sphere2][1];
                    double distance = Math.sqrt( Math.pow((x1 - x0),2) + Math.pow((y1 - y0), 2));
                    if(distance <= bombs[sphere1][2])
                        neighbor.add(sphere2);
                }
            }
            adj.add(sphere1, neighbor);
        } 
        
        //dfs
        int maxDetonates = 0;
        for(int i = 0; i < n; i++){
            Stack<Integer> stack = new Stack<>();
            boolean[] marked = new boolean[n];
            marked[i] = true;
            int detonate = 1;
            stack.add(i);
            while(!stack.isEmpty()){
                int curIndex = stack.pop();
                Iterator<Integer> iterator = adj.get(curIndex).iterator();
                while(iterator.hasNext()){
                    int nextIndex = iterator.next();
                    if(marked[nextIndex] == false){
                        stack.add(nextIndex);
                        marked[nextIndex] = true;
                        detonate++;
                    }
                }
            }
            if(maxDetonates < detonate)
                maxDetonates = detonate;
        }
        return maxDetonates;
    }
}