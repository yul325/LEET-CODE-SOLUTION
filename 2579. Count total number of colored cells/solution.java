class Solution {
    //123
    public static void main(String args[]){
        coloredCells(2);
    }
    public static long coloredCells(int n) {
        long result = 0;
        for(int i = 1; i <= n; i++){
            if(i == 1) {
                result = 1;
                continue;
            }
            else 
                result += 4 * (i-1);
        }
        return result;
    }
}