public class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        int start = 0;
        int end = 0;
        for(int mid = 0; mid < s.length(); mid++){
            int left;
            int right;

            // cases like aba
            left = mid - 1;
            right = mid + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            left ++;
            right --;
            if(right - left > end - start){
                start = left;
                end = right;
            }
            // cases like abba
            left = mid;
            right = mid + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            left ++;
            right --;
            if(right - left > end - start){
                start = left;
                end = right;
            }
        }
        return s.substring(start, end + 1);
    }
}
