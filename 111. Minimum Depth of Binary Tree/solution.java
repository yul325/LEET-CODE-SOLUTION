class Solution implements solutionInterface{
    int result = Integer.MAX_VALUE;
    int numsOfNodes = 0;
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        solve(root);
        return result;
    }

    public void solve(TreeNode root){
        numsOfNodes++;
        if(root.left == null && root.right == null)
            result = Math.min(result, numsOfNodes);
        else{
            if(root.left != null){
                solve(root.left);
                numsOfNodes--;
            }

            if(root.right != null){
                solve(root.right);
                numsOfNodes--;
            }
        }

        return;
    }
}
