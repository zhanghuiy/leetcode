import java.util.Stack;
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ')' || c == ']' || c == '}'){
                if(st.isEmpty()){
                    return false;
                }
                Character charInSt = st.pop();
                if(!((charInSt == '[' && c == ']') || (charInSt == '{' && c == '}') || (charInSt == '(' && c == ')'))){
                    return false;
                }
            }
            if(c == '(' || c == '[' || c == '{'){
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}
