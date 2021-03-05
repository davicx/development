import module
import my_module as mod

exampleservices = {'OnlineTesting': 'Programming', 'ProgrammingLanguages': 'Python'}
'Services: {OnlineTesting}, {ProgrammingLanguages}'.format(**exampleservices)
print(exampleservices)

#'Services: Programming, Python'

"""


 

 
exampleservices = {'OnlineTesting': 'Programming'}, 'ProgrammingLanguages': 'Python'}
exampleservices(format["OnlineTesting","ProgrammingLanguage"]
 
exampleservices = ['OnlineTesting: Programming', 'ProgrammingLanguages: Python']
exampleservices.format['Services: {OnlineTesting}, {ProgrammingLanguages}']
 
exampleservices = ('OnlineTesting': 'Programming', 'ProgrammingLanguages': 'Python')
format(exampleservices('Services: {OnlineTesting}, {ProgrammingLanguages}'))


exampleservices = ['OnlineTesting':'Programming', 'ProgrammingLanguages': 'Python']
exampleservices.format()




 



#PART 1: Variables
number = 5
string = "david"

#PART 2: Data 
#List
python_list = ["apple", "banana", "cherry"]
print(python_list)

#Array 
python_array = ["Ford", "Volvo", "BMW"]

#Tuple (A tuple is a collection which is ordered and unchangeable)
python_tuple = ("apple", "banana", "cherry")
print(python_tuple)

#Set (A set is a collection which is unordered and unindexed and no duplicates)
python_set = {"apple", "banana", "cherry"}
print(python_set)

#Dictionary
user_dictionary = {
  "user_id": 1,
  "user_name": "vasquezd",
  "user_imate": "david.jpg"
}

print(user_dictionary)


#PART 2: Control Structures
#For Loop
fruits = ["apple", "banana", "cherry"]
for item in fruits:
   print(item)

#If Statement 
x = 1
if x < 0:
    print('x is negative')
elif x == 1:
   print('Single')
else:
   print('More')

#Iterator 
mytuple = ("apple", "banana", "cherry")
myit = iter(mytuple)

print(next(myit))
print(next(myit))
print(next(myit))   

#PART 3: Functions
#Standard 
def my_function():
  print("Hello from a function")

my_function()

#Lambda
x = lambda a : a + 10
print(x(5))

#PART 4: Python Classes and Objects
class Person:
  def __init__(self, name, age):
    self.name = name
    self.age = age

p1 = Person("David", 26)

print(p1.name)
print(p1.age)

#PART 3: Import Module
courses = ['History','Math','Physics']
#print(module.fib(1000))

"""


"""

 


f = open("file.txt", "r")

print(f.read())

text = f.readline()
while text := f.readline(text()):
    print()

 
while text:
    text := f.readline()
    print(text.readline())
 

 
while text:
    print(text := f())
 
while text := f.readline():
    print(text)



while text := f.readline():
    print(text.readline())

while text:
    print(text)
    text = f.readline()
"""