import java.util.*;
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr, 0, arr.length);
        int constant = 0;
        for(int i = 0; i < arr.length - 1; i++){
            if(i == 0)
                constant = arr[1] - arr[0];
            else if( (arr[i + 1] - arr[i]) != constant)
                return false;                
        }
        return true;
    }
}