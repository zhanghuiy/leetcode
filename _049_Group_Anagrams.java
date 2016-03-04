public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<List<String>>();
        }
        Arrays.sort(strs);
        Map<String, List<String>>map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String str_sorted = new String(chars);
            if(!map.containsKey(str_sorted)){
                map.put(str_sorted, new ArrayList<String>());
            }
            map.get(str_sorted).add(str);
        }
        ArrayList<List<String>> ret = new ArrayList<List<String>>();
        for(List<String> list : map.values()){
            ret.add(list);
        }
        return ret;
    }
}
