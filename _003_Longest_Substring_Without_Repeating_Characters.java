import java.util.*;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // ==== hash table, brute force ====
        if (s == null || s.length() == 0){
            return 0;
        }
        int max = 1;
        for(int index = 0; index < s.length() - max; index++){
            Hashtable<Character, Integer> chars = new Hashtable();
            int next = index;
            while(next < s.length() && (!chars.containsKey(s.charAt(next))) ){
                chars.put(s.charAt(next), 1);
                next ++;
            }
            if(max < ((next - index)) ){
                max = ((next - index));
            }
        }
        return max;
        // ==== hash table, brute force ====
        // ==== hash table, store start and end index ====

        // ==== hash table, store start and end index ====
    }
}
