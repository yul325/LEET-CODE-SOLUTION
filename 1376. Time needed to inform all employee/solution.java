import java.util.*;
class Solution implements solutionInterface{
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //store all info in to Hashmap
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            int parent = manager[i];
            if(hashMap.get(parent) == null){
                ArrayList<Integer> child = new ArrayList<>();
                hashMap.put(parent, child);
            }
            hashMap.get(parent).add(i);
        }
        
        
        Stack<Integer> stack = new Stack<>();
        stack.push(headID);
        int[] totalInformTime = new int[n];
        totalInformTime[headID] = informTime[headID];
        while(!stack.isEmpty()){
            int curIndex = stack.pop();
            int time = totalInformTime[curIndex];
            /* 
            for(int i = 0; i < n; i++){
                if(manager[i] == curIndex){
                    stack.push(i);
                    totalInformTime[i] = time + informTime[i];
                }
            }
            */
            if(hashMap.get(curIndex) != null){
                for(Integer child : hashMap.get(curIndex)){
                    stack.push(child);
                    totalInformTime[child] = time + informTime[child];
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            if(totalInformTime[i] > max)
                max = totalInformTime[i];
        }
        return max;
    }
}