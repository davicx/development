def maxSubArray(nums):
    for element in nums:
        print(element)

    """
    max_sum = 0
    array_length = len(nums)
    left_pointer = 0
    
    while left_pointer < len(nums):
        current_list = [nums[left_pointer]]
        right_pointer = left_pointer + 1

        while right_pointer < array_length:
            current_list.append(nums[right_pointer])
            #print("Left: ", nums[left_pointer], " Right: ", nums[right_pointer])
            right_pointer += 1
        left_pointer += 1
        print(current_list)
    """

#nums = [-2,1,-3,4,-1,2,1,-5,4]
nums = [1,2,3,4]
maxSubArray(nums)


        