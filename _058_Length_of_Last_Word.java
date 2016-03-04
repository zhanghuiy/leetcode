public class Solution {
    public int lengthOfLastWord(String s) {
        // calling s.charAt() consumes more time than geting element of an array by index
        char[] sArray = s.toCharArray();

        boolean enter = false;
        int length = 0;
        for(int i = 0; i < sArray.length; i++){
            if(enter == false){
                if(sArray[i] != ' '){
                    enter = true;
                    length = 1;
                }
            }else{ // enter == true
                if(sArray[i] == ' '){
                    enter = false;
                }else{
                    length ++;
                }
            }
        }
        return length;

    }
}
