import csv

with open('sample_data.csv') as file:
    userReader = csv.reader(file)

    all_users = []
    unique_users_set = set()
    
    #Loop through the whole plans.csv file and create an object that represents each plan
    for user in userReader:
        unique_users_set.add(user[0])
        current_user = {
            "user_a": user[0] ,
            "user_b":user[1],
            "affinity_score": user[2]
            }
        all_users.append(current_user)

    current_user = all_users[0].get("user_a")
 
    for user in all_users:
        if (current_user == user.get("user_a")):
            print("if")
            print(user)

        else:
            print("else")
            print(user)
            current_user = user.get("user_a")


#current_user_score_array = []

    
    


    #unique_users_set.add(user["user_a"])
    #If it is the same user add to the list

"""    
thisdict =	{
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
x = thisdict["model"]
print(x)

    if (1 == 1):
        print("if")
    else:
        print("else")
"""
#print(user["user_a"])         