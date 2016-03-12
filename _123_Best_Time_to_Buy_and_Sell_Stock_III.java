public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int min = prices[0];
        left[0] = 0;
        right[prices.length-1] = 0;
        for(int i = 1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            left[i] = Math.max(prices[i]-min,left[i-1]);
        }
        int max = prices[prices.length-1];
        for(int i = prices.length-2; i >= 0; i--){
            max = Math.max(max, prices[i]);
            right[i] = Math.max(max-prices[i],right[i+1]);
        }
        int profit = 0;
        for(int i = -1; i < prices.length; i++){
            profit = Math.max(profit, left[i<0?0:i]+right[i+1==prices.length?prices.length-1:i+1]);
        }
        return profit;
    }
}


// O(n*n) TLE
// public class Solution {
//     public int maxProfit(int[] prices) {
//         if(prices.length <= 1) return 0;
//         int profit = 0;
//         for(int mid = 1; mid < prices.length; mid++){
//             profit = Math.max(maxProfitInRange(prices,0,mid)+maxProfitInRange(prices,mid+1,prices.length-1), profit);
//         }
//         return profit;
//     }
//     private int maxProfitInRange(int[] prices, int start, int end){
//         if(end <= start) return 0;
//         int min = prices[start];
//         int profit = 0;
//         for(int i = start + 1; i <= end; i++){
//             min = Math.min(prices[i], min);
//             profit = Math.max(prices[i] - min, profit);
//         }
//         return profit;
//     }
// }
