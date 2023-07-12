import java.util.*;

class Solution implements solutionInterface{
    HashMap<TreeNode,TreeNode> parent = new HashMap<>();
    List<Integer> result = new ArrayList<Integer>();
    HashMap<TreeNode, Integer> distance = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParents(root);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        distance.put(target, 0);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.remove();
            int dist = distance.get(curNode);

            if(dist == k){
                result.add(curNode.val);
                continue;
            }

            //parent
            if(curNode != root){
                TreeNode parentNode = parent.get(curNode);
                if(distance.get(parentNode) == null){
                    distance.put(parentNode, dist + 1);
                    queue.add(parentNode);
                }
            }
            
            //left
            if(curNode.left != null && distance.get(curNode.left) == null){
                distance.put(curNode.left, dist + 1);
                queue.add(curNode.left);
            }

            //right
            if(curNode.right != null && distance.get(curNode.right) == null){
                distance.put(curNode.right, dist + 1);
                queue.add(curNode.right);
            }
        }
        return result;
    }

    public void findParents(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.remove();

            if(curNode.left != null) {
                queue.add(curNode.left);
                parent.put(curNode.left, curNode);
            }

            if(curNode.right != null) {
                queue.add(curNode.right);
                parent.put(curNode.right, curNode);
            }
        }
    }
}
