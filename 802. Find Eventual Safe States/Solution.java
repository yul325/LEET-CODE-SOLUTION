import java.util.*;
public class Solution {
    boolean[] visited;
    boolean[] inStack;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            visited = new boolean[graph.length];
            inStack = new boolean[graph.length];
            if(isCycle(i, graph) == false)
                result.add(i);
        }
        
        return result;
    }

    boolean isCycle(int vertex, int[][] graph){
        if(inStack[vertex])
            return true;
        
        if(visited[vertex])
            return false;

        visited[vertex] = true;
        inStack[vertex] = true;
        for(Integer i: graph[vertex]){
            if(isCycle(i, graph))
                return true;
        }

        inStack[vertex] = false;
        return false;
    }
}