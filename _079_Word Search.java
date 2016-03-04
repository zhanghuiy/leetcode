public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        for(int x = 0; x < board.length; x ++){
            for(int y = 0; y < board[x].length; y++){
                if(existHelper(board, wordArray, x, y, 0)) return true;
            }
        }
        return false;
    }
    private boolean existHelper(char[][] board, char[] word, int x, int y, int target){
        if(target == word.length) return true;
        if( x < 0 || y < 0 || x >= board.length || y >= board[x].length || board[x][y] != word[target]) return false;
        board[x][y] ^= 256; // assume given chars in word range from 0 - 255, the MAX_VALUE of char is 65535
        boolean res = existHelper(board, word, x + 1, y, target + 1)
        || existHelper(board, word, x - 1, y, target + 1)
        || existHelper(board, word, x, y + 1, target + 1)
        || existHelper(board, word, x, y - 1, target + 1);
        board[x][y] ^= 256;
        return res;
    }
}
