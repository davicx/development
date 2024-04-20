#PART 2: File Paths for each user
currentUser = UserClass(current_user, user_id)

class UserClass:
    def __init__(self, current_user, user_id):
        self.current_user = current_user
        self.user_id = user_id

    def getName(self):
        print(self.current_user)
        print(self.user_id)    
