def main():
    x = 121
    x_string = str(x)
    #isPalindrome(x)
    reverseNumber(x)


def reverseNumber(x: int) -> int:
    if x < 0:
        number_is_positive = False
        x = x * -1
    else: 
        number_is_positive = True


    print(x % 10)
    print(x // 10)
    print()
    print(x % 100)
    print(x // 10)
    print()
    print(x % 1000)
    print(x // 10)
    print()
    print(x % 10000)
    print(x // 10)

    
    return x















def isPalindrome(x: int) -> bool:
    if x < 0:
        number_is_positive = False
        x = x * -1
    else: 
        number_is_positive = True

    print(x % 10)
    


    return True







def isPalindromeString(x: int) -> bool:

    if x < 0:
        number_is_positive = False
        x = x * -1
    else: 
        number_is_positive = True
    
    x_string = str(x)
    
    if x_string == x_string[::-1]:
        print("It is!!")
    else:
        print("nope")
        
    print(number_is_positive)
    print(x)

    return True



if __name__ == "__main__":
    main()

