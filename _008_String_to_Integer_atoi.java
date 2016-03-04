public class Solution {
    public int myAtoi(String str) {
        if(str.length() == 0){
            return 0;
        }

        int ret = 0;
        int index = 0;
        boolean negative = false;

        while(index < str.length() && str.charAt(index) == ' '){
            index++;
        }

        if(str.charAt(index) == '-' || str.charAt(index) == '+'){
            negative = str.charAt(index) == '-' ? true : false;
            index ++;
        }
        while(index < str.length() && str.charAt(index) == '0'){
            index++;
        }

        for(; index < str.length(); index++){
            if(str.charAt(index) - '0' < 0 || str.charAt(index) - '0' > 9){
                return ret;
            }


            if( (ret > 0) && (ret > Integer.MAX_VALUE / 10)){
                return Integer.MAX_VALUE;
            }
            if( (ret < 0) && (ret < Integer.MIN_VALUE / 10)){
                return Integer.MIN_VALUE;
            }
            ret *= 10;

            if( (ret > 0) && (Integer.MAX_VALUE - ret) < (str.charAt(index) - '0')){
                return Integer.MAX_VALUE;
            }
            if( (ret < 0) && (ret - Integer.MIN_VALUE) < (str.charAt(index) - '0')){
                return Integer.MIN_VALUE;
            }
            if(ret >= 0){
                ret += str.charAt(index) - '0';
            }else{
                ret -= str.charAt(index) - '0';
            }

            if(negative == true && str.charAt(index) != '0'){
                ret = -ret;
                negative = false;
            }
        }
        return ret;
    }
}
