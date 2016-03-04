import java.util.Arrays;
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if ( total % 2 == 0){
            return ((double)findKth(nums1, nums2, total / 2) + (double)findKth(nums1, nums2, total / 2 + 1)) / 2.0;
        }else{
            return  (double)findKth(nums1, nums2, total / 2 + 1);
        }
    }
    int findKth(int[] a, int[] b, int k){
        if(k <= 1){
            if (a.length > 0 && b.length > 0){
                return a[0] < b[0] ? a[0] : b[0];
            }else{
                if(a.length > 0){
                    return a[0];
                }
                if(b.length > 0){
                    return b[0];
                }
                return -1;
            }
        }
        if(a.length == 0){
            return b[k-1];
        }
        if(b.length == 0){
            return a[k-1];
        }
        int aPtr = k/2-1 < a.length ? k/2-1 : a.length - 1;
        int bPtr = k/2-1 < b.length ? k/2-1 : b.length - 1;
        if(a[aPtr] > b[bPtr]){
            return findKth(a, bPtr < b.length - 1 ? Arrays.copyOfRange(b,bPtr+1, b.length) : new int[0], k-bPtr-1);
        }
        if(a[aPtr] < b[bPtr]){
            return findKth(aPtr < a.length - 1 ? Arrays.copyOfRange(a,aPtr+1, a.length) : new int[0], b, k-aPtr-1);
        }
        if(a[aPtr] == b[bPtr]){
            if(aPtr + bPtr + 2 < k){
                return findKth(aPtr < a.length - 1 ? Arrays.copyOfRange(a,aPtr+1, a.length) : new int[0], b, k-aPtr-1);
            }else{
                return a[aPtr];
            }
        }
        return -1;
    }
}
