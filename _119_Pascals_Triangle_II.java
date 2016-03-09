public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        if(rowIndex >= 0) list1.add(1);
        for(int row = 1; row <= rowIndex; row++){
            if(list1.isEmpty()){
                for(int idx = 0; idx <= row; idx++){
                    int ele = 0;
                    if(idx - 1 >= 0) ele += list2.get(idx-1);
                    if(idx <= row - 1) ele += list2.get(idx);
                    list1.add(ele);
                }
                list2.clear();
            }else{
                for(int idx = 0; idx <= row; idx++){
                    int ele = 0;
                    if(idx - 1 >= 0) ele += list1.get(idx-1);
                    if(idx <= row - 1) ele += list1.get(idx);
                    list2.add(ele);
                }
                list1.clear();
            }
        }
        return list1.isEmpty() ? list2 : list1;
    }
}
