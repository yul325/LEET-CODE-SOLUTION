import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String args[]){
        TreeNode root = new TreeNode(1, new TreeNode(7, new TreeNode(7), new TreeNode(-8)), new TreeNode(0));
        int a = maxLevelSum(root);
    }
    //
    public static int maxLevelSum(TreeNode root) {
        if(root == null)
            return -1;
        else{
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int curLevelSum = 0;
            int max = Integer.MIN_VALUE;
            int res = 0;
            int level = 0;
            while(!queue.isEmpty()){
                level++;
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    TreeNode curNode = queue.remove();
                    curLevelSum += curNode.val;
                    
                    if(curNode.left != null) queue.add(curNode.left);
                    if(curNode.right != null) queue.add(curNode.right);
                }
                
                if(curLevelSum > max){
                    max = curLevelSum;
                    res = level;
                }
                curLevelSum = 0;
            }
            return res;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}