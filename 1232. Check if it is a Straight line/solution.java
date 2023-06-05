class Solution {

    public static void main(String args[]){
        int[][] coordinates = {{1,2},{2,3},{3,5},{4,5},{5,6},{6,7}};
        boolean a = checkStraightLine(coordinates);
    }
    public static boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        int y2 = coordinates[n-1][1];
        int x2 = coordinates[n-1][0];
        double slope = (double)(y2 - coordinates[0][1])/ (double)(x2 - coordinates[0][0]);
        for(int i = 1; i < n-1; i++){
            int x1 = coordinates[i][0];
            int y1 = coordinates[i][1];
            double newSlope = (double)(y2 - y1) / (double)(x2 - x1);
            if(newSlope == slope)
                continue;
            else 
                return false;
        }
        return true;
    }
}