public class test {
    public static void main(String args[]){
        TreeNode root = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5))));
        solutionInterface solution = new Solution();
        int a = solution.minDepth(root);
    }
}
