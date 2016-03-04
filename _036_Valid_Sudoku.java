public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] count1 = new int[9];
        int[] count2 = new int[9];
        int[] count3 = new int[9];

        for(int i = 0; i < 9; i++){
            for(int t = 0; t < 9; t++){
                count1[t] = 0;
                count2[t] = 0;
                count3[t] = 0;
            }
            int base_row = (i/3)*3;
            int base_col = (i%3)*3;
            for(int j = 0; j < 9; j++){
                if('1' <= board[i][j] &&  board[i][j] <= '9'){
                    count1[(int)(board[i][j] - '1')] += 1;
                    if(count1[(int)(board[i][j] - '1')] > 1){
                        return false;
                    }
                }

                if('1' <= board[j][i] &&  board[j][i] <= '9'){
                    count2[(int)(board[j][i] - '1')] += 1;
                    if(count2[(int)(board[j][i] - '1')] > 1){
                        return false;
                    }
                }

                int row = base_row + j/3;
                int col = base_col + j%3;
                if('1' <= board[row][col] &&  board[row][col] <= '9'){
                    count3[(int)(board[row][col] - '1')] += 1;
                    if(count3[(int)(board[row][col] - '1')] > 1){
                        return false;
                    }
                }


            }
        }


        return true;
    }
}
