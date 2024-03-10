number = 5


def subtract_number(number):
    print(number)
    if(number > 0):
        new_number = number - 1
        subtract_number(new_number)
    else:
        print("number is", number)
        print("your done!")

subtract_number(number)
       