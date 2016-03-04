public class Solution {
    public boolean isNumber(String s) {
        s=s.trim();
        boolean seenDot = false;
        boolean seenE = false;
        boolean seenNum = false;
        boolean numAfterE = false;
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++){
            if(str[i] == '.'){
                if(seenDot || seenE){
                    return false;
                }else{
                    seenDot = true;
                }
            }else if(str[i] == 'e' || str[i] == 'E'){
                if( !seenNum || seenE){
                    return false;
                }else{
                    seenE = true;
                }
            }else if(str[i] >= '0' && str[i] <= '9'){
                seenNum = true;
                if(seenE){
                    numAfterE = true;
                }
            }else if(str[i] == '-' || str[i] == '+'){
                if(i != 0 && str[i-1] != 'e'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return seenNum && (!seenE || numAfterE);
    }
}
