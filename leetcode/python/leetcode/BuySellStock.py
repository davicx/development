def maxProfit(prices) -> int:
    max_profit = 0
    left = 0
    right = 1

    while right < len(prices):
        if prices[right] - prices[left]:
            profit = prices[right] - prices[left]
            max_profit = max(max_profit, profit)
        else:
            left = right
        right = right + 1

    return 1

prices = [7,1,5,3,6,4]
maxProfit(prices)
   

   
"""    
while buy_count < len(prices):
    while sell_count < len(prices):
        print(buy_count, " ", prices[buy_count], " ", prices[sell_count])
        buy_count += 1
        sell_count += 1


        if buy_count or sell_count > len(prices):
            break
"""