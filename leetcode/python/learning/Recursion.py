
def sayHi(x: int):
    print("Current Value ", x)    

    if x == 0: 
        print("done")
    else:
        sayHi( x-1)

#sayHi(2)


def loopOverString(s):
    for char in s:
        print(char)

#loopOverString("Hiya")

# A generator function 
def simpleGeneratorFun(): 
    yield x

# x is a generator object 
x = simpleGeneratorFun() 
  
# Iterating over the generator object using next 
#print(x.__next__())  

string_name = "Enumerate"
  
# Iterate over the string 
for i, v in enumerate(string_name): 
    print(i, " ", v) 