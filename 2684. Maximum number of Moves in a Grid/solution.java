class Solution {
    static int maxStep = 0;
    static int curStep = 0;
    public static void main(String args[]){
        int[][] grid = {{1000000,92910,1021,1022,1023,1024,1025,1026,1027,1028,1029,1030,1031,1032,1033,1034,1035,1036,1037,1038,1039,1040,1041,1042,1043,1044,1045,1046,1047,1048,1049,1050,1051,1052,1053,1054,1055,1056,1057,1058,1059,1060,1061,1062,1063,1064,1065,1066,1067,1068},{1069,1070,1071,1072,1073,1074,1075,1076,1077,1078,1079,1080,1081,1082,1083,1084,1085,1086,1087,1088,1089,1090,1091,1092,1093,1094,1095,1096,1097,1098,1099,1100,1101,1102,1103,1104,1105,1106,1107,1108,1109,1110,1111,1112,1113,1114,1115,1116,1117,1118}};
        //int[][] grid = {{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}};
        int a = maxMoves(grid);
    }

    public static int maxMoves(int[][] grid) {
        int result = 0;
        for(int row = 0; row < grid.length; row++){
            int curNum = grid[row][0];
            int col = 0;
            int curRowMoves = solveCurMoves(grid, row, col, curNum);
            if(result < curRowMoves)
                result = curRowMoves;
            curStep = 0;
        }
        return result - 1;
    }

    public static int solveCurMoves(int[][] grid, int row, int col, int curNum){
        curStep++;
        if(curStep > maxStep)
            maxStep = curStep;

        if(col == grid[0].length - 1)
            return 1;
        
        if( (row != 0) && grid[row - 1][col + 1] > curNum){
            int nextNum = grid[row - 1][ col + 1];
            solveCurMoves(grid, row - 1, col + 1, nextNum);
            curStep--;
        }
        if( grid[row][col+1] > curNum){
            int nextNum = grid[row][ col + 1];
            solveCurMoves(grid, row, col + 1, nextNum);
            curStep--;
        }
        if( (row != grid.length - 1) && grid[row + 1][ col + 1] > curNum){
            int nextNum = grid[row + 1][col + 1];
            solveCurMoves(grid, row + 1, col + 1, nextNum);
            curStep--;
        }
        return maxStep;
    }
}