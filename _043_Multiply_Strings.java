// 两种办法：
// 1. 既可以从答案的位置一个一个算，答案的倒数第2位＝第2位＊第0位＋第1位＊第1位＋第0位＊第2位
// 2. 也可以遍历参数，比如num1［i］＊num2［j］需要叠加在答案的i＋j位置上，然后在i＋j＋1的位置上叠加进位，
// 然后i+j+1如果还有进位还要继续加，一直加到不再进位为止。
// 上面加进位的地方还可以最后一次直接搞定，需要用int数组保存答案，int数组里面的每个数字都可以大于9，
// 所以可以保存超过了进位的数字，最后在一趟对大于9的所有做一趟处理，可以省时间。

public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.charAt(0) == '0' || num2.charAt(0) == '0'){
            return "0";
        }
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        int[] nums3 = new int[nums1.length+nums2.length];//长度不会超过两个长度相加
        for(int i = 0; i < nums3.length; i++){
            nums3[i] = 0;
        }
        for(int i = nums1.length-1; i >= 0; i--){
            for(int j = nums2.length-1; j >= 0; j--){
                int digit = (nums1[i] - '0') * (nums2[j] - '0');
                int position = i + j + 1;
                nums3[position] += digit;
            }
        }
        int carry = 0;
        for(int i = nums3.length-1; i >= 0; i--){
            nums3[i] += carry;
            carry = nums3[i] / 10;
            nums3[i] = nums3[i] % 10 + '0';
        }
        int start = nums3[0]=='0'?1:0;
        return new String(nums3, start, nums3.length-start);

    }

    public String multiply_other_version(String num1, String num2) {
        if(num1.charAt(0) == '0' || num2.charAt(0) == '0'){
            return "0";
        }
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        char[] num3 = new char[nums1.length+nums2.length];//长度不会超过两个长度相加
        for(int i = 0; i < num3.length; i++){
            num3[i] = '0';
        }
        for(int i = nums1.length-1; i >= 0; i--){
            for(int j = nums2.length-1; j >= 0; j--){
                int digit = (nums1[i] - '0') * (nums2[j] - '0');
                int position = 1 + i + j;
                if(num3[position] + digit <= '9'){
                    num3[position] = (char)(num3[position] + digit);
                }else{
                    int carry = 0;
                    do{
                        carry = ((num3[position] - '0') + digit) / 10;
                        num3[position] = (char)((((num3[position] - '0') + digit) % 10) + '0');
                        digit = carry;
                        position--;
                    }while(carry > 0);
                }
            }
        }
        int start = num3[0]=='0'?1:0;
        return new String(num3, start, num3.length-start);

    }
}
