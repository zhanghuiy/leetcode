public class Solution {
    public int reverse(int x) {
        if(x < 0 && x + Integer.MAX_VALUE < 0){
            return 0;
        }
        boolean negative = false;
        if(x < 0){
            negative = true;
            x = - x;
        }
        int ret = x % 10;
        x = x / 10;
        while(x > 0){
            if(ret > (Integer.MAX_VALUE)/ 10){
                return 0;
            }
            ret *= 10;
            if(Integer.MAX_VALUE - ret < x % 10){
                return 0;
            }
            ret += (x % 10);
            x = x / 10;
        }
        if(negative){
            ret = - ret;
        }
        return ret;
    }
}
