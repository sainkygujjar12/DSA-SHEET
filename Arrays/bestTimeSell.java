package Arrays;

public class bestTimeSell {
    
    public int maxProfit(int[] prices) {
        int profit=0;
        int max=0;
        int buy=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>buy){
                profit=prices[i]-buy;
                max=Math.max(profit,max);
            }else{
                buy=prices[i];
            }
        }
        return max;
    }

}
