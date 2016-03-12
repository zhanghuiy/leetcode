public class Solution {
    // a much better version, from back to front
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;
        while(p1>=0 && p2>=0){
            if(nums1[p1] > nums2[p2]) nums1[p--] = nums1[p1--];
            else nums1[p--] = nums2[p2--];
        }
        while(p2 >= 0){
            nums1[p--] = nums2[p2--];
        }
    }
    public void merge_version_1(int[] nums1, int m, int[] nums2, int n) {
        // move elements in nums1 backward
        for(int i = m - 1; i >= 0; i--){
            nums1[i+n] = nums1[i];
        }
        int index = 0;
        int pNums1 = n;
        int pNums2 = 0;
        while(pNums1 < n + m || pNums2 < n){
            if(pNums1 < n + m && pNums2 < n){
                if(nums1[pNums1] < nums2[pNums2]){
                    nums1[index++] = nums1[pNums1++];
                }else{
                    nums1[index++] = nums2[pNums2++];
                }
            }else{
                if(pNums1 == n + m){
                    nums1[index++] = nums2[pNums2++];
                }else{
                    nums1[index++] = nums1[pNums1++];
                }
            }
        }
    }
}
