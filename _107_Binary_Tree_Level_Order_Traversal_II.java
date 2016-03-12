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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }else{
            LinkedList<TreeNode> level = new LinkedList<>();
            level.add(root);
            levelOrderBottomHelper(level, res);
            return res;
        }
    }

    private void levelOrderBottomHelper(LinkedList<TreeNode> level, LinkedList<List<Integer>> res){
        while(!level.isEmpty()){
            int size = level.size();
            List<Integer> levelInts = new ArrayList<>();
            while(size != 0){
                TreeNode node = level.removeFirst();
                if(node.left != null) level.addLast(node.left);
                if(node.right != null) level.addLast(node.right);
                levelInts.add(node.val);
                size--;
            }
            res.addFirst(levelInts);
        }
    }
}
