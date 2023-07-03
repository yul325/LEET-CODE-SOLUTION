import java.util.LinkedList;

class Solution implements solutionInterface {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        //build up the matrix list
        @SuppressWarnings("unchecked") LinkedList<double[]>[] adj = new LinkedList[n]; 
        for(int i = 0; i < edges.length; i++){
            if(adj[edges[i][0]] == null)
                adj[edges[i][0]] = new LinkedList<double[]>();
            adj[edges[i][0]].add(new double[]{edges[i][1], succProb[i]});

            if(adj[edges[i][1]] == null)
                adj[edges[i][1]] = new LinkedList<double[]>();
            adj[edges[i][1]].add(new double[]{edges[i][0], succProb[i]});
        }

        double[] probTo = dijkstras(start, adj, n);
        return probTo[end];
    }

    private double[] dijkstras(int start, LinkedList<double[]>[] adj, int n){
        boolean[] visited = new boolean[n];
        double[] probTo = new double[n];
        int[] parent = new int[n];

        //start
        visited[start] = true;
        probTo[start] = 1;
        int nVisited = 1;

        int cur = start;
        while(nVisited < n){
            if(adj[cur] == null)
                break;

            for(double[] neighbor : adj[cur]){
                int neighborIndex = (int)neighbor[0];
                double probSum = probTo[cur] * neighbor[1];
                if(probTo[neighborIndex] < probSum){
                    probTo[neighborIndex] = probSum;
                    parent[neighborIndex] = cur;
                }
            }

            double maxProb = 0;
            cur = -1;
            for(int i = 0; i < n; i++){
                if(visited[i] == true)
                    continue;
                if(probTo[i] > maxProb){
                    cur = i;
                    maxProb = probTo[i];
                }
            }

            if(cur >= 0){
                visited[cur] = true;
                nVisited++;
            }
            else 
                break;
        }
        return probTo;
    }
}