public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int[] ways = new int[chars.length];
        ways[0] = chars[0] == '0' ? 0 : 1;
        for(int i = 1; i < chars.length; i++){
            if(i - 1 >= 0 && ((chars[i-1] == '2' && chars[i] >= '0' && chars[i] <= '6') || (chars[i-1] == '1')) ){
                ways[i] += i - 2 >= 0 ? ways[i-2] : 1;
            }
            if(chars[i] != '0'){
                ways[i] += ways[i-1];
            }
        }
        return ways[ways.length-1];
    }
}
