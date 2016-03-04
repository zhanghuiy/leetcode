// 可以用backtracking，但是会浪费时间
// 比如有某种方法，能在p[1]匹配到s[2]，p[2]匹配到s[5]但是发现后面不能成功
// 然后有另一种某种方法，能在p[1]匹配到s[3]，p[2]匹配到s[5]，后面已经验证过不能成功了，但是还是会再算一次。
// DP的话可以避免这个问题，并且可以只用一前一后两个hashMap来省内存。

// 这题有边界情况DP做不出来，用了一种比较tricky的办法:
// 需要假设如果前一个＊忽略m个的情况下，跑到后一个＊
// 那么如果前一个星号忽略m+n个成立的话，忽略m个也一定成立
// 换言之只要能到后一个星号，前一个星号就可以不用管。
// 因为前一个星号少忽略几个，那么后一个星号多忽略几个就能补上。
public class Solution {
    public boolean isMatch(String s, String p) {
        int saved_p = -1, saved_s = -1;
        int index_p = 0, index_s = 0;
        while(index_s < s.length()){
            if(index_p < p.length() && (p.charAt(index_p) == s.charAt(index_s) || p.charAt(index_p) == '?') ){
                index_s ++;
                index_p ++;
            }else if(index_p < p.length() && p.charAt(index_p) == '*'){
                saved_p = index_p;
                saved_s = index_s + 1;
                index_p ++;
            }else if(saved_p != -1){
                index_s = saved_s;
                index_p = saved_p;
            }else{
                return false;
            }
        }
        while(index_p < p.length()){
            if(p.charAt(index_p) != '*')return false;
            index_p ++;
        }
        return true;

    }
    public boolean isMatch_DP_time_exceeded(String s, String p) {
        //Dynamic Programming
        HashMap<Integer, Boolean> hm1 = new HashMap<>();
        HashMap<Integer, Boolean> hm2 = new HashMap<>();
        int pid = 0;
        for(pid = 0; pid< p.length(); pid++){
            hm1 = hm2;
            hm2 = new HashMap<>();
            if(pid == 0){
                hm1.put(-1, true);
            }
            int key_count = 0;
            Iterator keys = hm1.keySet().iterator();
            while(keys.hasNext()){
                key_count ++;
                int sid = (Integer)keys.next();
                if(sid < s.length()){
                    if(p.charAt(pid) == '*'){
                        for(int tmp = sid; tmp < s.length(); tmp++){
                            hm2.put(tmp, true);
                        }
                    }else if(p.charAt(pid) == '?'){
                        hm2.put(sid+1, true);
                    }else if(sid + 1 < s.length() && p.charAt(pid) == s.charAt(sid+1)){
                        hm2.put(sid+1, true);
                    }
                }
            }
            if(key_count == 0){
                return false;
            }
        }
        if(pid == p.length()){
            Iterator keys = hm2.keySet().iterator();
            while(keys.hasNext()){
                if((Integer)keys.next() == s.length()){
                    return true;
                }
            }
        }
        return false;
    }
}
