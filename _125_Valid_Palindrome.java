public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        if(s.length() == 0) return true;
        char[] str = s.toCharArray();
        int left = 0, right = str.length-1;
        while(left <= right){
            char lChar = str[left];
            if(!((lChar >= 'a' && lChar <= 'z') || (lChar >= 'A' && lChar <= 'Z') || (lChar >= '0' && lChar <= '9'))){
                left++;
                continue;
            }
            char rChar = str[right];
            if(!((rChar >= 'a' && rChar <= 'z') || (rChar >= 'A' && rChar <= 'Z') || (rChar >= '0' && rChar <= '9'))){
                right--;
                continue;
            }
            lChar = Character.toLowerCase(lChar);
            rChar = Character.toLowerCase(rChar);

            if(lChar != rChar) return false;
            left++;
            right--;
        }
        return true;
    }
}
