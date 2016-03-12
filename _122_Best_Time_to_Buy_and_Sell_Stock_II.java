public class Solution {
    public int maxProfit(int[] prices) {
        Integer profit = 0;
        Integer buyAt = null;
        for(int i = 0; i < prices.length - 1; i++){
            if(buyAt != null && prices[i+1] < prices[i]){
                profit += prices[i] - buyAt;
                buyAt = null;
            }else if(buyAt == null && prices[i+1] > prices[i]){
                buyAt = prices[i];
            }
        }
        if(buyAt != null) profit += prices[prices.length-1] - buyAt;
        return profit;
    }
}
