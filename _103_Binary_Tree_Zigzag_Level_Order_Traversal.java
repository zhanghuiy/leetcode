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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean l2r = true;
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> ele = new ArrayList<>();
            TreeNode tmpNode;
            while(size != 0){
                if(l2r){
                    tmpNode = queue.removeFirst();
                    ele.add(tmpNode.val);
                    if(tmpNode.left != null) queue.addLast(tmpNode.left);
                    if(tmpNode.right != null) queue.addLast(tmpNode.right);
                }else{
                    tmpNode = queue.removeLast();
                    ele.add(tmpNode.val);
                    if(tmpNode.right != null) queue.addFirst(tmpNode.right);
                    if(tmpNode.left != null) queue.addFirst(tmpNode.left);
                }
                size--;
            }
            l2r = !l2r;
            res.add(ele);
        }
        return res;
    }
}
