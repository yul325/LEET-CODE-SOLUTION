class Solution implements solutionInterface{
    public int[] findPeakGrid(int[][] mat) {
        int n = mat[0].length;
        int row = mat.length;
        int middle = (n - 1)/2;

        if(n != 2){
            return solve(mat, middle, 0, n-1);
        }
        else{
            int max = 0;
            int resultRow = 0;
            for(int i = 0; i < row; i++){
                if(max < mat[i][0]){
                    max = mat[i][0];
                    resultRow = i;
                }
            }
            
            if(max > mat[resultRow][1])
                return new int[] {resultRow, 0};
            else{
                for(int i = 0; i < row; i++){
                    if(max < mat[i][1]){
                        max = mat[i][1];
                        resultRow = i;
                    }
                }
                return new int[] {resultRow, 1};
            }
        }
    }

    public int[] solve(int[][] mat, int col, int start, int end){
        //finding max in a col
        int max = 0;
        int row = 0;
        for(int i = 0; i < mat.length; i++){
            if(mat[i][col] > max){
                max = mat[i][col];
                row = i;
            }
        }

        if(col == 0 || col == mat[0].length - 1)
            return new int[]{row, col};

        if(max > mat[row][col - 1] && max > mat[row][col + 1])
            return new int[]{row, col};
        else if(mat[row][col - 1] > max){
            int nextCol = (start + col) / 2;
            return solve(mat, nextCol, start, col);
        }
        else if(mat[row][col + 1] > max){
            int nextCol = (col + end + 1) / 2;
            return solve(mat, nextCol, col, end);
        }
        return null;
        
    }
}