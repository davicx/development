def reverseList(list_to_reverse, start, end):
    while start < end:
        list_to_reverse[start],list_to_reverse[end] = list_to_reverse[end], list_to_reverse[start]
        start += 1
        end -= 1
 
# Driver function to test above function
list_to_reverse = [1, 2, 3, 4, 5, 6]
print(list_to_reverse)
reverseList(list_to_reverse, 0, 5)
print("Reversed list is")
print(list_to_reverse)