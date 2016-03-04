public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 0 || n == 0){
            return 0;
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if( i == 0 && j == 0){

                }else if( i > 0 && j == 0){
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                }else if( i == 0 && j > 0){
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                }else{
                    grid[i][j] = Math.min(grid[i][j-1], grid[i-1][j]) + grid[i][j];
                }

            }
        }
        return grid[m-1][n-1];
    }
}
