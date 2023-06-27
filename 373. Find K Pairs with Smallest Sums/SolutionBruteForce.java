import java.util.*;

class The_Comparator implements Comparator<List<Integer>>{
    public int compare(List<Integer> l1, List<Integer> l2){
        int sum1 = 0;
        int sum2 = 0;
        for(int i: l1) sum1 += i;
        for(int i: l2) sum2 += i;
        
        if(sum1 == sum2) return -1;
        else return sum1 - sum2;
    }
}

class SolutionBruteForce implements solutionInterface{
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new The_Comparator());
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                List<Integer> curCombo = new ArrayList<Integer>();
                curCombo.add(nums1[i]);
                curCombo.add(nums2[j]);
                queue.add(curCombo);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < k; i++){
            if(queue.peek() != null)
                result.add(queue.poll());
        }
        return result;
    }
}
