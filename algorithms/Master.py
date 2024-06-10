from collections import Counter
from collections import defaultdict
from collections import OrderedDict
from operator import getitem

#Basic Data Structures
mylist = ["apple", "banana", "cherry"]
mytuple = ("apple", "banana", "cherry") #Can't Change
myset = {"apple", "banana", "cherry"}

myDict = {
    "key": "value",
    "model": "Mustang",
    "year": 1964
}

#Dictionary
#print(myDict["key"])
myDict["year"] = 2018
myDict.update({"year": 2020})
#print(myDict["year"])
myDict.pop("model")

#print keys
for key in myDict:
    #print(key)
    pass

#print values
for value in myDict:
    #print(myDict[value])
    pass

#Class
class User:
    def __init__(self, name, age):
        self.name = name
        self.age = age

merry = User("merry", 22)
#print(merry.name)

#Sort Nested Items

users = []

frodo = {
  "name": "frodo",
  "age": 22,
  "location": "shire"
}

sam = {
  "name": "sam",
  "age": 21,
  "location": "shire"
}

david = {
  "name": "david",
  "age": 20,
  "location": "corvallis"
}

everyone = {
  "sam": sam,
  "david": david,
  "frodo": frodo
}

#Print Single Item
#print(everyone["sam"])

#Print Everything 
for person in everyone:
  print(everyone[person])

#Sort by Age 
everyoneSorted = OrderedDict(sorted(everyone.items(),
  key = lambda x: getitem(x[1], 'age')))

print("_______________")
for person in everyoneSorted:
  print(everyoneSorted[person])

