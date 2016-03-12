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
     public List<TreeNode> generateTrees(int n) {
         if(n == 0){
             return new ArrayList<TreeNode>();
         }
         return generateTreesFromRange(1,n);
     }

     private List<TreeNode> generateTreesFromRange(int from, int to){
         // [from, to]
         List<TreeNode> res = new LinkedList<>();
         if(from > to){
             res.add(null);
         }
         for(int rootVal = from; rootVal <= to; rootVal++){
             List<TreeNode> leftList = generateTreesFromRange(from, rootVal-1);
             List<TreeNode> rightList = generateTreesFromRange(rootVal+1, to);
             for(TreeNode left : leftList){
                for(TreeNode right: rightList){
                    TreeNode root = new TreeNode(rootVal);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
             }
         }
         return res;
     }
 }
// public class Solution {
//     public List<TreeNode> generateTrees(int n) {
//         if(n == 0) return new ArrayList<TreeNode>();
//         else return genTreeList(1,n);
//     }

//     private List<TreeNode> genTreeList (int start, int end) {
//         List<TreeNode> list = new ArrayList<TreeNode>();
//         if (start > end) {
//             list.add(null);
//         }
//         for(int idx = start; idx <= end; idx++) {
//             List<TreeNode> leftList = genTreeList(start, idx - 1);
//             List<TreeNode> rightList = genTreeList(idx + 1, end);
//             for (TreeNode left : leftList) {
//                 for(TreeNode right: rightList) {
//                     TreeNode root = new TreeNode(idx);
//                     root.left = left;
//                     root.right = right;
//                     list.add(root);
//                 }
//             }
//         }
//         return list;
//     }
// }
