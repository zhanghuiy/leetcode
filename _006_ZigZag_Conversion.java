public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuilder[] sbArray = new StringBuilder[numRows];
        for(int i = 0; i < sbArray.length; i++){
            sbArray[i] = new StringBuilder();
        }
        for(int i = 0; i < s.length(); i++){
            int pos = i % (numRows + numRows - 2);
            if (pos < numRows){
                sbArray[pos].append(s.charAt(i));
            }else{
                sbArray[numRows - 2 - (pos % numRows)].append(s.charAt(i));
            }
        }
        for(int i = 1; i < sbArray.length; i++){
            sbArray[0].append(sbArray[i]);
        }
        return sbArray[0].toString();
    }
}
