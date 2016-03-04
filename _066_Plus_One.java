public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0){
            return new int[0];
        }
        int[] res = new int[digits.length+1];
        res[res.length-1] = digits[digits.length-1] + 1;
        int carry = res[res.length-1] / 10;
        res[res.length-1] = res[res.length-1] % 10;
        for(int i = digits.length-2; i >= 0; i--){
            res[i+1] = digits[i] + carry;
            carry = res[i+1] / 10;
            if(carry > 0){
                res[i+1] = res[i] % 10;
            }
        }
        if(carry >= 1){
            res[0] = 1;
        }else{
            res = Arrays.copyOfRange(res, 1, res.length);
        }
        return res;

    }
}
