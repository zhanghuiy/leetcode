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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        pathSumDFS(root, sum, res, new LinkedList<Integer>());
        return res;
    }

    private void pathSumDFS(TreeNode root, int sum, List<List<Integer>> res, LinkedList<Integer> prevNums){
        if(root == null) return;
        prevNums.addLast(root.val);
        if(root.left == null && root.right == null && root.val - sum == 0){
            res.add(new ArrayList(prevNums));
        }
        if(root.left != null){
            pathSumDFS(root.left, sum-root.val, res, prevNums);
        }
        if(root.right != null){
            pathSumDFS(root.right, sum-root.val, res, prevNums);
        }
        prevNums.removeLast();
    }
}
