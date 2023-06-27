import java.util.*;
class TheComparator implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        if(a[0] == b[0])
            return -1;
        return a[0] - b[0];
    }
}

class Solution implements solutionInterface{
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Set<int[]> visited = new HashSet<>();

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new TheComparator());

        //push the first element
        int[] start = {nums1[0] + nums2[0], 0, 0};
        queue.add(start);
        visited.add(new int[]{0,0});
        while(!queue.isEmpty() && (k-- != 0)){
            int[] curElement = queue.poll();
            int i = curElement[1];
            int j = curElement[2];
            
            if( (j+1 != n2) && !visited.contains(new int[]{i, j+1})){
                int sum = nums1[i] + nums2[j+1];
                queue.add(new int[]{sum, i, j+1});
                visited.add(new int[]{i , j+1});
            }
            if( (i+1 != n1) && !visited.contains(new int[]{i+1, j})){
                int sum = nums1[i+1] + nums2[j];
                queue.add(new int[]{sum, i+1, j});
                visited.add(new int[]{i+1, j});
            }
            List<Integer> ans = new ArrayList<>();
            ans.add(nums1[i]);
            ans.add(nums2[j]);
            result.add(ans);
        }
        return result;
    }
}