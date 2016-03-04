public class Solution {
    public List<String> generateParenthesis(int n) {
        // backtracking, brute force, recursion
        return generateParenthesisDFS("", n * 2);
    }

    public List<String> generateParenthesisDFS(String str, int n){
        LinkedList<String> ret = new LinkedList<>();
        int count = 0;
        int open = 0;
        int close = 0;
        boolean valid = true;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                count++;
                open++;
            }else{
                close++;
                count--;
            }
            if(count < 0){
                valid = false;
            }
        }
        if(count != 0){
            valid = false;
        }

        if(n == 0){
            // check if str is valid;
            if(valid){
                ret.add(str);
            }
            return ret;
        }

        if(open > (n + str.length()) / 2){
            return new LinkedList<String>();
        }
        if(close > (n + str.length()) / 2){
            return new LinkedList<String>();
        }

        if(open < (n + str.length()) / 2){
            ret.addAll(generateParenthesisDFS(str+"(", n-1));
        }
        if(close < (n + str.length()) / 2){
            ret.addAll(generateParenthesisDFS(str+")", n-1));
        }
        return ret;
    }
}
