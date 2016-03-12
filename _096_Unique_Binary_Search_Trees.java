public class Solution {

    public int numTrees(int n) {
        // return numTreesRecursiveVersion(n);
        return numTreesDPVersion(n);
    }

    private int numTreesDPVersion(int n) {
        if(n <= 0) return 0;
        int[] res = new int[n+1];
        res[0] = 1;
        for(int total = 1; total <= n; total ++){
            for(int left = 0; left <= total-1; left++){
                int right = total - left - 1;
                res[total] += res[left] * res[right];
            }
        }
        return res[n];
    }

    private int numTreesRecursiveVersion(int n) {
        if(n == 0)return 1;
        int res = 0;
        for(int left = 0; left <= n - 1; left++){
            res += numTrees(left) * numTrees(n - left - 1);
        }
        return res;
    }
}
