public class Solution {
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> res = new ArrayList<>();
        if(n == 0) return res;
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int row_index, List<List<String>> res){
        if(row_index == board.length){
            res.add(board_to_list(board));
            return;
        }
        for(int col = 0; col < board.length; col++){
            board[row_index][col] = 'Q';
            if(validate(board, row_index, col)){
                dfs(board, row_index+1, res);
            }
            board[row_index][col] = '.';
        }
    }

    // place queens top-down
    private boolean validate(char[][] board, int x, int y){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 'Q'){
                    if(j == y || x-i == y-j || x-i == j-y) return false;
                }
            }
        }
        return true;
    }

    private List<String> board_to_list(char[][] board){
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            list.add(new String(board[i]));
        }
        return list;
    }
}
