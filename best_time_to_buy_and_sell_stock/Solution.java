package best_time_to_buy_and_sell_stock;

public class Solution {
    public int maxProfit(int[] prices) {

        int len = prices.length;
        if (len ==1) return 0;
        int prev_num = prices[1] - prices[0];
        int max = prev_num > 0 ? prev_num : 0 ;
        
        for ( int i = 2 ; i < len; i++){
            prev_num = ( prices[i] - prices[i-1] ) >
                           (prices[i] + prev_num - prices[i-1] ) ?
                           prices[i] - prices[i-1] :  
                           (prices[i] + prev_num - prices[i-1] );
            if (max < prev_num) max = prev_num;
        }
        return max;
    }
}
