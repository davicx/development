

def binary_search(array, target):
    left = 0
    right = len(array) - 1

    while (left <= right):
        mid = (right + left) // 2

        if array[mid] == target:
            return mid
        elif array[mid] < target:
            left = mid + 1
        else: 
            right = mid + 1

        return -1

arr = [1,2,3,4]
target = 2

answer = binary_search(arr, target)
print(answer)