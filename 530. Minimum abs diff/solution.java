import java.util.LinkedList;
import java.util.Queue;

class Solution{
    public static void main(String args[]){
        TreeNode root = new TreeNode(236, new TreeNode(104,null , new TreeNode(227)), new TreeNode(701, null, new TreeNode(911)));
        int a = getMinimumDifference(root);
    }//

    public static int getMinimumDifference(TreeNode root) {
        int min = 2147483647;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.remove();
            min = solve(cur.val, cur, min);

            if(cur.left != null)
                queue.add(cur.left);
            if(cur.right != null)
                queue.add(cur.right);
        }
        return min;
    }

    public static int solve(int rootVal, TreeNode cur, int min){
        if(cur.left != null){
            if( Math.abs(rootVal - cur.left.val) < min)
                min = Math.abs(rootVal - cur.left.val);
            min = solve(rootVal, cur.left, min);
        }

        if(cur.right != null){
            if( Math.abs(rootVal - cur.right.val) < min)
                min = Math.abs(rootVal - cur.right.val);
            min = solve(rootVal, cur.right, min);
        }
        return min;
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
