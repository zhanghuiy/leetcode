public class Solution {
    public List<String> restoreIpAddresses(String s) {
        // check validity
        List<String> res = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                return res;
            }
        }

        // find three places and put a dot into each place
        // assume that 0.0.0.0 is a valid address
        for(int i = 1; i <= 3 && i <= s.length()-3; i++ )
        for(int j = i + 1; j <= i + 3 && j <= s.length()-2; j++ )
        for(int k = j + 1; k <= j + 3 && k <= s.length()-1; k++ ){
            String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,s.length());
            if(isValidIpPart(s1) && isValidIpPart(s2) && isValidIpPart(s3) && isValidIpPart(s4)){
                res.add(s1+"."+s2+"."+s3+"."+s4);
            }
        }
        return res;
    }
    private boolean isValidIpPart(String s){
        if(
            s == null ||
            s.length() == 0 ||
            s.length() > 3 ||
            (s.charAt(0) == '0' && s.length() > 1) ||
            Integer.parseInt(s)>255
        ){
            return false;
        }
        return true;

    }
}
