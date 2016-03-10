public class Solution {
    public int longestValidParentheses(String s) {
        char[] S = s.toCharArray();
        int[] V = new int[S.length];
        int open = 0;
        int max = 0;
        for (int i=0; i<S.length; i++) {
            if (S[i] == '(') open++;
            if (S[i] == ')' && open > 0) {
                V[i] = 2 + V[i-1] + (i-2-V[i-1] > 0 ? V[i-2-V[i-1]] : 0);
                open--;
            }
            if (V[i] > max) max = V[i];
        }
        return max;
    }
    public int longestValidParentheses_nn(String s) {
        if(s == null || s.length() <= 1) return 0;
        int longest = 0;
        int[] score1 = new int[s.length()];
        int[] score2 = new int[s.length()];
        int[] scoreTmp;
        char[] str = s.toCharArray();
        score1[0] = str[0] == '(' ? 1 : -1;
        for(int end = 1; end<str.length; end++){
            for(int start = 0; start <= end; start++){
                if(start != end){
                    score2[start] = score1[start] < 0 ? score1[start] : score1[start] + (str[end] == '(' ? 1 : -1);
                }else{
                    score2[start] = str[end]=='('?1:-1;
                }
                if(score2[start] == 0 && end-start+1>longest){
                    longest = end-start+1;
                }
            }
            scoreTmp = score1;
            score1 = score2;
            score2 = scoreTmp;
        }
        return longest;
    }
}
