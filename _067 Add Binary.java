public class Solution {
    public String addBinary(String a, String b) {
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        char[] res = new char[Math.max(arrayA.length, arrayB.length)+1];
        res[0] = '0';
        int carry = 0;
        for(int i = 1; arrayA.length-i >= 0 || arrayB.length-i >= 0; i++){
            int digit = 0;
            if(arrayA.length-i >= 0){
                digit += arrayA[arrayA.length-i] - '0';
            }
            if(arrayB.length-i >= 0){
                digit += arrayB[arrayB.length-i] - '0';
            }
            digit += carry;
            carry = digit / 2;
            digit = digit % 2;
            res[res.length-i] = (char)(digit + '0');
        }
        if(carry == 1){
            res[0] = '1';
        }
        return res[0] == '0' ? new String(Arrays.copyOfRange(res, 1, res.length)): new String(res);
    }
}
