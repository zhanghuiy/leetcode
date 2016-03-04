public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            boolean found = true;
            int j = 0;
            while(found && j < needle.length()){
                if(needle.charAt(j) != haystack.charAt(i+j)){
                    found = false;
                }
                j++;
            }
            if(found){
                return i;
            }
        }
        System.out.println("out");
        return -1;
    }
}
