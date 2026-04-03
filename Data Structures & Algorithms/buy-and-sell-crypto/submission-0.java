class Solution {
    public int maxProfit(int[] prices) {
        int windowStart = 0;
        
        int profit = 0;
        int maxProfit = 0;

        for(int windowEnd = 0;windowEnd < prices.length;windowEnd++){
            while(prices[windowEnd] < prices[windowStart]){
                windowStart++;
            }
            if(prices[windowEnd]> prices[windowStart]){
                profit = prices[windowEnd] - prices[windowStart];
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}
