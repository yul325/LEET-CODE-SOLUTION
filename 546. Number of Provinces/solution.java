import java.util.ArrayList;
import java.util.Stack;

class Solution implements solutionInterface{
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> connected = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ArrayList<Integer> adj = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1 && (j != i) )
                    adj.add(j);
            }
            connected.add(i, adj);
        }
        //dfs 
        boolean[] marked = new boolean[n];
        int cluster = 0;
        for(int i = 0; i < n; i++){
            if(marked[i] == true)
                continue;
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            marked[i] = true;
            while(!stack.isEmpty()){
                int curIndex = stack.pop();
                for(Integer neighbor : connected.get(curIndex)){
                    if(marked[neighbor] == false){
                        marked[neighbor] = true;
                        stack.push(neighbor);
                    }
                }
            }
            cluster++;
        }
        return cluster;
    }
}