class Solution implements solutionInterface{
    public boolean buddyStrings(String s, String goal) {
        int sLength = s.length();
        int goalLength = goal.length();
        if(sLength != goalLength || sLength < 2)
            return false;
        

        int counter = 0;
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < sLength; i++){
            if(s.charAt(i) != goal.charAt(i)){
                if(counter == 0)
                    startIndex = i;
                else
                    endIndex = i;
                counter++;
            }
        }
        
        if(counter > 2)
            return false;
        else if(counter == 0){
            for(int i = 0; i < sLength; i++){
                for(int j = i + 1; j < sLength; j++){
                    if(s.charAt(i) == s.charAt(j))
                        return true;
                }
            }
            return false;
        }
        else if(counter == 2 && s.charAt(startIndex) == goal.charAt(endIndex) && s.charAt(endIndex) == goal.charAt(startIndex))
            return true;
        else 
            return false;
    }
}