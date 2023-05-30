class Solution {
    public static void main(String args[]){
        int[][] grid = { {1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1} };
        int[] result = findBall(grid);
        int a = 0;
    }

    public static int[] findBall(int[][] grid) {
        int numOfBalls = grid[0].length;
        int[] balls = new int[numOfBalls];

        //initialize starting col for each ball
        for(int i = 0; i < balls.length; i++)
            balls[i] = i;
        
        for(int row = 0; row < grid.length; row++){
            int[] validCol = new int[numOfBalls];
            //compute which col proceed and which col stop
            // if validCol == 1 means it is a stop
            for(int col = 0; col < grid[0].length; col++){
                int curCell = grid[row][col];
                if( col != (grid[0].length -1) && curCell == 1 && grid[row][col + 1] == 1 )
                    validCol[col] = 1;
                else if( col != 0 && curCell == -1 && grid[row][col - 1] == -1)
                    validCol[col] = -1;
            }

            for(int curBall = 0; curBall < numOfBalls; curBall++){
                if(balls[curBall] == -1)
                    continue;
                else if(validCol[balls[curBall]] == 0)
                    balls[curBall] = -1;
                else
                    balls[curBall] += validCol[balls[curBall]];
            }
        }
        return balls;
    }
}