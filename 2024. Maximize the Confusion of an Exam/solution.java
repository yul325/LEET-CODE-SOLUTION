class Solution implements solutionInterface{
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int numberOfT = 0, numberOfF = 0, left =0, result = 0;
        for(int right = 0; right < answerKey.length(); right++){
            char curChar = answerKey.charAt(right);
            if(curChar == 'T')
                numberOfT++;
            else if(curChar == 'F')
                numberOfF++;
            
            while(Math.min(numberOfT, numberOfF) > k){
                char leftChar = answerKey.charAt(left);
                if(leftChar == 'T')
                    numberOfT--;
                else if(leftChar == 'F')
                    numberOfF--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}