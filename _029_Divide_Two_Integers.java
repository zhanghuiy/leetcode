public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        long dd = (long)dividend;
        long ds = (long)divisor;
        if(dd < 0){
            sign = -sign;
            dd = -dd;
        }
        if(ds < 0){
            sign = -sign;
            ds = -ds;
        }
        if(ds > dd){
            return 0;
        }else if(ds == dd){
            return sign == -1 ? -1:1;
        }else{
            int count = 0;
            while(dd >= ds){
                long tmpDs = ds;
                long tmpCount = 1;
                boolean inc = false;
                while(tmpDs < dd){
                    inc = true;
                    tmpDs <<= 1;
                    tmpCount <<= 1;
                }
                if(inc){
                    tmpDs >>= 1;
                    tmpCount >>= 1;
                }
                if(Integer.MAX_VALUE - count < tmpCount){
                    if(sign == -1){
                        return Integer.MIN_VALUE;
                    } else{
                        return Integer.MAX_VALUE;
                    }
                }
                count += tmpCount;
                dd = dd - tmpDs;
            }
            return sign == -1 ? -count:count;
        }
    }
}
