import java.util.LinkedList;
import java.util.Queue;
public class Solution {
    public String countAndSay(int n) {
        if(n == 0){
            return "";
        }

        String string = "1";
        while(n != 1){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < string.length(); i++){
                char c = string.charAt(i);
                int count = 1;
                while(i+1 < string.length() && string.charAt(i+1) == c){
                    i++;
                    count++;
                }
                sb.append(count);
                sb.append(c);
            }
            string = sb.toString();
            n--;
        }
        return string;
    }

}
