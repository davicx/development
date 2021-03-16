#Strings
message = 'Hi'
message_two =  """
    hello,
    everyone
"""

#Length
message_length = len(message)
print(message_length)

#Access Index
print(message[0])

#Useful
message.find('value')
message = message.replace('original', 'new') #Returns a new string with the values in place need new variable 
new_message = message.replace('original', 'new') 

#Concate
greeting = 'hi'
name = 'david'

#Formatting
my_message = '{}, {}. hiya!'.format(greeting, name)
print(my_message)

better_message = f'{ greeting.upper() }, { name }. hiya!'
print(better_message)

#See All
#print(dir(name)) #pass variable and show all its attributes and methods
#print(help(str)) #see more info
print(help(str.lower))