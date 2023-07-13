import java.util.LinkedList;
import java.util.List;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        LinkedList<Integer>[] adj = new LinkedList[numCourses];
        for(int i = 0; i < n; i++){
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];
            if(adj[src] == null){
                adj[src] = new LinkedList<>();
                adj[src].add(dest);
            }
            else
                adj[src].add(dest);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!visited[i] && dfs(i, adj, visited, inStack))
                return false;
        }
        return true;
    }

    boolean dfs(int vertex, List<Integer>[] adj, boolean[] visited, boolean[] inStack){
        visited[vertex] = true;
        inStack[vertex] = true;

        if(adj[vertex] != null){
            for(Integer neighbor: adj[vertex]){
                if(visited[neighbor] == false && dfs(neighbor, adj, visited, inStack))
                    return true;
                else if(inStack[neighbor] == true)
                    return true;
            }
        }

        inStack[vertex] = false;
        return false;
    }
}