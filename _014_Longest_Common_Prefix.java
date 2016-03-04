public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < strs[0].length(); i++){
            char currentChar = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(strs[j].length() <= i || strs[j].charAt(i) != currentChar){
                    return sb.toString();
                }
            }
            sb.append(currentChar);
        }

        return sb.toString();
    }
}
