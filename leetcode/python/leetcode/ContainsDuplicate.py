
def containsDuplicate(nums) -> bool:
    nums_set = set()
    contains_duplicate = False

    for num in nums:
        if num in nums_set:
            contains_duplicate = True
            return  contains_duplicate
        else:
           nums_set.add(num)

    return contains_duplicate    
        


nums = [1,2,3,4]
print(containsDuplicate(nums))

