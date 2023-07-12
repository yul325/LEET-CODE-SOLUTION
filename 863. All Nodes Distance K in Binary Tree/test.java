import java.util.List;
public class test {
    public static void main(String args[]){
        TreeNode target = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        TreeNode root = new TreeNode(3, 
            target,
            new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        solutionInterface solution = new Solution();
        List<Integer> a = solution.distanceK(root, target, 2);
    }
}
