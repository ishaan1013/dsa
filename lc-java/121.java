class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length == 1) {
      return 0;
    }

    int buy = 0;
    int sell = 1;
    int maxSell = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[buy] < prices[sell]) {
        if (prices[sell] - prices[buy] > maxSell) {
          maxSell = prices[sell] - prices[buy];
        }
      } else {
        buy = sell;
      }
      sell++;
    }

    return maxSell;
  }
}