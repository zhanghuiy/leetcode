public class Solution {
    public int minDistance(String word1, String word2) {
        int word1Len = word1.length();
        int word2Len = word2.length();
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        int[][] cost = new int[word2Len+1][word1Len+1];
        for(int i = 0; i <= word1Len; i++){
            cost[0][i] = i;
        }
        for(int i = 0; i <= word2Len; i++){
            cost[i][0] = i;
        }
        for(int row = 1; row <= word2Len; row++){
            for(int col = 1; col <= word1Len; col++){
                if(word1Array[col-1] == word2Array[row-1]){
                    cost[row][col] = cost[row-1][col-1];
                }else{
                    cost[row][col] = Math.min(cost[row-1][col-1], Math.min(cost[row-1][col],cost[row][col-1])) + 1;
                }
            }
        }
        return cost[word2Len][word1Len];
    }
}
