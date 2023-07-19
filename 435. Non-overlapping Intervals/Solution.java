import java.util.Arrays;
import java.util.Comparator;
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int preEnd = Integer.MIN_VALUE;
        //greedy algorithm
        for(int i = 0; i < n; i++){
            if(preEnd <= intervals[i][0]){
                preEnd = intervals[i][1];
                count++;
            }
            else
                continue;
        }
        return n - count;
    }
}