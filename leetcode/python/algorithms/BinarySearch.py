
def binary_search_works(sequence, item):
    begin_index = 0
    end_index = len(sequence) - 1

    while begin_index <= end_index:
        midpoint = begin_index + (end_index - begin_index) // 2
        midpoint_value = sequence[midpoint]
        if midpoint_value == item:
            return midpoint

        elif item < midpoint_value:
            end_index = midpoint - 1

        else:
            begin_index = midpoint + 1

    return None


def binary_search(nums, element):
    begin_index = 0
    end_index = len(nums) - 1

    while begin_index <= end_index:        
        midpoint = begin_index + (end_index - begin_index) // 2
        midpoint_value = nums[midpoint]
        if midpoint_value == element:
            return midpoint

        elif element < midpoint_value:
            end_index = midpoint - 1
            print("Less then: New Midpoint ", end_index)
        else:
            begin_index = midpoint + 1
            print("Greater then: New Midpoint ", begin_index)

    return "none"

nums = [1,2,3,4,5,6,7,8,9,10]
element = 9

print(binary_search(nums, element))


"""
    while begin_index #less​ than= end_index:
        midpoint = begin_index + (end_index - begin_index) // 2
        midpoint_value = sequence[midpoint]
        if midpoint_value == item:
            return midpoint

        elif item #less​ than midpoint_value:
            end_index = midpoint - 1

        else:
            begin_index = midpoint + 1

    return None
"""