class User:
    def __init__(self, first_name, last_name, email, age):
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.age = age
        self.is_rewards_member = False
        self.gold_card_points = 0 
    
    def display_info(self):
        print("--------------------")
        print(self.first_name)
        print(self.last_name)
        print(self.email)
        print(self.age)
        print(self.is_rewards_member)
        print(self.gold_card_points)
        print("--------------------")
        
    def enroll(self):
        if self.is_rewards_member == True: 
            print("User already a member.")
            return False
        else:
            self.is_rewards_member = True
            self.gold_card_points = 200    
        return self.gold_card_points, self.is_rewards_member
    
    def spend_points(self, amount):
        if self.gold_card_points >= amount:
            self.gold_card_points = self.gold_card_points - amount 
            return self.gold_card_points
        else: 
            print("Not Enough Points")
    
    def add_point(self, add):
        self.gold_card_points += add

sam_rickenbach = User("Sam", "Rickenbach", "samrickenbach@gmail.com", 28)
kara_cooper = User("Kara", "Cooper", "Cooper@gmail.com", 33)
sampson_middel = User("Sampson", "Middel", "Samoureye@gmail.com", 29)

sam_rickenbach.enroll()
# kara_cooper.enroll()
# sampson_middel.enroll()
# sam_rickenbach.spend_points(50)
# kara_cooper.spend_points(80)

sam_rickenbach.enroll()

sam_rickenbach.display_info().spend_points()
# kara_cooper.display_info()
# sampson_middel.spend_points(240)
# sampson_middel.display_info()

# sam_rickenbach.add_point(50)
# sam_rickenbach.enroll()

# sam_rickenbach.display_info()