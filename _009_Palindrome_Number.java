public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int copy = x;
        int target = 0;
        while(copy > 0){
            target = target * 10 + (copy % 10);
            copy /= 10;
        }
        return x == target;
    }
}
