package DynamicPrograming;

public class BuyStock {

    public static int maxProfits(int[] prices){
        int buy=Integer.MAX_VALUE,sale=-1,maxprofit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<buy){
                buy = prices[i];
                sale = -1;
            }
            else if((prices[i]-buy)>maxprofit){
                sale = prices[i];
                maxprofit = sale - buy;
            }
        }
        return maxprofit;
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4,0,4};
        System.out.print(maxProfits(prices));
    }
}
