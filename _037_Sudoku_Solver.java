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
    public class Board{
        char[][] board;
        public Board(char[][] b){
            board = new char[9][9];
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    board[i][j] = b[i][j];
                }
            }
        }
        public void modify(int position, char value){
            board[position/9][position%9] = value;
        }
        public char getChar(int position){
            return board[position/9][position%9];
        }
        public char[][] getChars(){
            return board;
        }
        public boolean valid(){
            return isValidSudoku(board);
        }
        public boolean finish(){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    if(board[i][j] == '.'){
                        return false;
                    }
                }
            }
            return true;
        }
    }
    public void solveSudoku(char[][] board) {
        Board root = new Board(board);
        Board result = solveSudoku_DFS(root, -1);
        if(result != null){
            char ret[][] = result.getChars();
            for(int i = 0; i < 9; i ++){
                for(int j = 0; j < 9; j++){
                    board[i][j] = ret[i][j];
                }
            }
        }

    }

    public Board solveSudoku_DFS(Board b, int prev_position){
        int position = -1;
        for(int i = 0; i < 81; i++){
            if(b.getChar(i) == '.'){
                position = i;
                break;
            }
        }
        if(position == -1){
            return null;
        }
        Board new_board = new Board(b.getChars());
        for(int i = 0; i < 9; i++){
            char c = '1';
            c = (char)((int)c + i);
            new_board.modify(position, c);
            if(new_board.valid()){
                if(new_board.finish()){
                    return new_board;
                }
                Board ret = solveSudoku_DFS(new_board, position);
                if(ret != null){
                    return ret;
                }
            }

        }
        return null;
    }
}
