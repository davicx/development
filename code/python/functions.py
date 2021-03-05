def hello():
    print("hi!")

def hello_return():
    return "hi"

def greeting(greeting, name = 'you'):
    returnValue = greeting + " " + name
    return returnValue



#print(len(hello_return()))
#print(greeting('hello', 'david'))

#Args and Kwargs
def student(*args, **kwargs):
    print(args)
    print(kwargs)

#student("math", "art", name="david", age=24)

courses = ["math", "art"]
student_info = {'name': 'david', 'age': 24 }

def student_two(*args, **kwargs):
    print(args)
    print(kwargs)

student_two(*courses, **student_info)

#Fibonacci
def fib(n):     
    a = 0
    b = 1

    while a < n:
        print(a, end=' ')
        a, b = b, a+b
        print()
