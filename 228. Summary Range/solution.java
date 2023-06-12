import java.util.ArrayList;
import java.util.List;

class Solution implements solutionInterface{
    //
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        StringBuilder string = new StringBuilder();
        int startNum = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                string.append("" + nums[0]);
                startNum = nums[0];
            }

            if( i != 0 && (nums[i] - nums[i-1]) != 1 ){
                if(startNum != nums[i - 1])
                    string.append("->" + nums[i-1]);
                result.add(string.toString());
                string = new StringBuilder();
                string.append("" + nums[i]);
                startNum = nums[i];
            }
            if( i == nums.length - 1){
                if(startNum != nums[i])
                    string.append("->" + nums[i]);
                result.add(string.toString());
            }
        }
        return result;
    }
}