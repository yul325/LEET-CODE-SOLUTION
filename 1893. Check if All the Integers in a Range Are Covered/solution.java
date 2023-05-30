class Solution {
    public static void main(String args[]){
        int[][] range = {{37, 49}, {5, 17}, {8, 32}};
        System.out.println(isCovered(range, 29, 49));
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        int maxEnd = ranges[0][1];
        int leastStart = ranges[0][0];

        for(int i = 1; i < ranges.length; i++){
            if( ranges[i][0] < leastStart )
                leastStart = ranges[i][0];
            if(ranges[i][1] > maxEnd)
                maxEnd = ranges[i][1];
        }

        if(left >= leastStart && right <= maxEnd)
            return true;
        else 
            return false;
    }
}