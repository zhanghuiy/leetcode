/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> eleInRes = new ArrayList<>();
            TreeNode tmpNode;
            while(size != 0){
                tmpNode = queue.pop();
                eleInRes.add(tmpNode.val);
                if(tmpNode.left != null) queue.add(tmpNode.left);
                if(tmpNode.right != null) queue.add(tmpNode.right);
                size--;
            }
            res.add(eleInRes);
        }
        return res;
    }
}
