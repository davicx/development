#Swap Two Items
my_list = [1, 2, 3, 4, 5]

#move item to a temporary spot, move the other item into this spot. Then swap 
print(my_list)
temp = my_list[4]
my_list[4] = my_list[0]
my_list[0] = temp
print(my_list)

#OR
a, b = my_list.index(1), my_list.index(5)
#print(a)
#print(b)
my_list[b] = my_list[a]
my_list[a] = my_list[b]

#my_list[b], my_list[a] = my_list[a], my_list[b]

#print(my_list[0])
#print(my_list[4])


puppy, kitten = "dog", "cat"
print(puppy)
print(kitten)