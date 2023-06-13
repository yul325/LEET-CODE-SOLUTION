import java.sql.RowId;
import java.util.HashMap;

class Solution implements solutionInterface {
    public int equalPairs(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        int result = 0;

        HashMap<Integer, String> hashRow = new HashMap<>();
        HashMap<Integer, String> hashCol = new HashMap<>();
        int key_tracker = 0;
        for(int row = 0; row < maxRow; row++){
            StringBuilder curString = new StringBuilder();
            for(int col = 0; col < maxCol; col++){
                curString.append(grid[row][col] + "-");
            }
            hashRow.put(row, curString.toString());
            key_tracker++;
        }

        for(int col = 0; col < maxCol; col++){
            StringBuilder curString = new StringBuilder();
            for(int row = 0; row < maxRow; row++){
                curString.append(grid[row][col] + "-");
            }
            hashCol.put(col, curString.toString());
            key_tracker++;
        }

        for(int row = 0; row < maxRow; row++){
            String rowString = hashRow.get(row);
            for(int col = 0; col < maxCol; col++){
                String colString = hashCol.get(col);
                if(rowString.equals(colString))
                    result++;
            }
        }
        return result;
    }
}