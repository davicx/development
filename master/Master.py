from collections import Counter
from collections import defaultdict

#Basic Data Structures
mylist = ["apple", "banana", "cherry"]
mylist.sort()

mytuple = ("apple", "banana", "cherry") #Can't Change
myset = {"apple", "banana", "cherry"}

myDict = {
    "key": "value",
    "model": "Mustang",
    "year": 1964
}

#Dictionary
print(myDict["key"])
myDict["year"] = 2018
myDict.update({"year": 2020})
print(myDict["year"])
myDict.pop("model")

#print keys
for key in myDict:
    print(key)

#print values
for value in myDict:
    print(myDict[value])

allUsers = {
  "child1" : {
    "name" : "Emil",
    "year" : 2004
  },
  "child2" : {
    "name" : "Tobias",
    "year" : 2007
  }
}

#Count Words
words = ['hi', 'hello', 'this', 'is', 'hi', 'hello']
words_counter = defaultdict(int)

for word in words:
    words_counter[word] +=1

for item in words_counter:
    print(words_counter[item], " ", item)
  
#Class
class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

p1 = Person("John", 36)

print(p1.name)
print(p1.age)

