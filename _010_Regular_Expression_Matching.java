public class Solution {
    public boolean isMatch(String s, String p) {

        // ==== backtracking ====

        if(s.length() == 0 && p.length() == 0){
            return true;
        }

        if(p.length() == 2 && p.charAt(1) == '*'){
            if( isMatch(s, "") ) return true;
        }
        if(p.length() >= 3 && p.charAt(1) == '*'){
            if( isMatch(s, p.substring(2, p.length()) ) ) return true;
        }

        if(p.length() >= 1 && s.length() >= 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') ){
            String s_sub;
            String p_sub;
            if( p.length() >= 2 && p.charAt(1) == '*'){
                s_sub = s.length() >= 2 ? s.substring(1,s.length()) : "";
                p_sub = p;
                if(isMatch(s_sub, p_sub)) return true;
            }
            s_sub = s.length() >= 2 ? s.substring(1,s.length()) : "";
            p_sub = p.length() >= 2 ? p.substring(1,p.length()) : "";
            if(isMatch(s_sub, p_sub)) return true;
        }


        return false;

        // ==== backtracking ====
        // ==== dynamic programming ====

        // ==== dynamic programming ====
    }

}
