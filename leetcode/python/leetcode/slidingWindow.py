leftWindow = 0
rightWindow = 2
window = ["a", "b", "c", "d"]

while rightWindow < len(window):
    print(window[leftWindow], " ", window[rightWindow])
    if window[leftWindow] == "a":
        leftWindow += 1

    leftWindow +=1
    rightWindow +=1

    if leftWindow > len(window):
        break



"""
while right < len(prices):
    if prices[right] - prices[left]:
        profit = prices[right] - prices[left]
        max_profit = max(max_profit, profit)
    else:
        left = right
    right = right + 1
"""