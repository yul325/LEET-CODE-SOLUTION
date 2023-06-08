import java.util.Arrays;
class Solution implements solutionInterface{
    public String getSmallestString(int n, int k) {
        StringBuilder string = new StringBuilder();
        int[] result = new int[n];
        Arrays.fill(result, 1);
        k -= n;

        int index = n - 1;
        while(k != 0){
            int adder = 25;
            if(k <= 25){
                result[index] += k;
                k = 0;
            }
            else {
                result[index] += adder;
                k -= 25;
            }
            index--;
        }

        for(int i = 0; i < n; i++){
            char curChar = (char)(result[i] + 96);
            string.append(curChar);
        }
        return string.toString();
    }
}