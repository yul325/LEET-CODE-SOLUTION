import java.util.Arrays;

class Solution implements solutionInterface {
    int count = 0;
    int[][] dp;
    //StringBuilder path = new StringBuilder();
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        //path.append(start);
        dp = new int[locations.length][fuel+1];
        for(int[] index: dp) 
            Arrays.fill(index, -1);
        return solve(locations, start, finish, fuel);
    }

    public int solve(int[] locations, int start, int finish, int fuel){  
        int numberOfRoutes = 0;
        
        if(fuel < 0)
            return 0;

        if(dp[start][fuel] != -1)
            return dp[start][fuel];
        else if(start == finish)
            numberOfRoutes++;

        //StringBuilder pre = new StringBuilder(path);
        for(int i = 0; i < locations.length; i++){
            if(i == start) continue;

            if(i == 3 && fuel == 5){
                int a = 0;
            }
            int fuelUsage = Math.abs(locations[start] - locations[i]);
            int fuelLeft = fuel - fuelUsage;

            //path.append("->" + i);
            numberOfRoutes += solve(locations, i, finish, fuelLeft) ;
            //path = new StringBuilder(pre);  
        }
        dp[start][fuel] = numberOfRoutes;
        return numberOfRoutes;
    }
}