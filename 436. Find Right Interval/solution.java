class Solution implements solutionInterface {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int min = 2147483646;
            int index = -1;
            for(int j = 0; j < n; j++){
                if(i == j)
                    continue;
                else if(intervals[j][0] >= end){
                    int distance = intervals[j][0] - end;
                    if(distance < min){
                        min = distance;
                        index = j;
                    }
                }           
            }
            result[i] = index;
        }
        return result;
    }
}