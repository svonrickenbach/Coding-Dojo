class BankAccount: 
    
    all_accounts = []

    def __init__(self, int_rate, balance):
        self.int_rate = int_rate
        self.balance = balance 
        BankAccount.all_accounts.append(self)

    def deposit(self, amount):
        self.balance = self.balance + amount
        return self

    def withdraw(self, amount):
        if self.balance >= amount:
            self.balance = self.balance - amount
        else: 
            print("Insufficient funds: Charging a $5 fee")
            self.balance -= 5
        return self
    
    def display(self):
        print("=================")
        print("Account 1:")
        print(f"Interest Rate: {self.int_rate}")
        print(f"Balance: {self.balance}")
        print("=================")
        return self

    def interest_rate(self):
        if self.balance > 0: 
            self.balance *= 1 + self.int_rate
        return self
    
    @classmethod
    def all_info(cls):
        for accounts in cls.all_accounts:
            accounts.display()

class BankAccount2: 
    
    all_accounts = []

    def __init__(self, int_rate, balance):
        self.int_rate = int_rate
        self.balance = balance 
        BankAccount.all_accounts.append(self)

    def deposit(self, amount):
        self.balance = self.balance + amount
        return self

    def withdraw(self, amount):
        if self.balance >= amount:
            self.balance = self.balance - amount
        else: 
            print("Insufficient funds: Charging a $5 fee")
            self.balance -= 5
        return self
    
    def display(self):
        print("=================")
        print("Account 2:")
        print(f"Interest Rate: {self.int_rate}")
        print(f"Balance: {self.balance}")
        print("=================")
        return self

    def interest_rate(self):
        if self.balance > 0: 
            self.balance *= 1 + self.int_rate
        return self
    
    @classmethod
    def all_info(cls):
        for accounts in cls.all_accounts:
            accounts.display()

class User:
    def __init__(self, first_name, last_name, email, age):
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.age = age
        self.is_rewards_member = False
        self.gold_card_points = 0 
        self.account = BankAccount (int_rate=0.2, balance=0)
        self.account2 = BankAccount2 (int_rate=0.5, balance=0)
    
    def display_info(self):
        print("--------------------")
        print(self.first_name)
        print(self.last_name)
        print(self.email)
        print(self.age)
        print(self.is_rewards_member)
        print(self.gold_card_points)
        print("--------------------")
        return self

    def enroll(self):
        if self.is_rewards_member == True: 
            print("User already a member.")
            return False
        else:
            self.is_rewards_member = True
            self.gold_card_points = 200    
        return self
    
    def spend_points(self, amount):
        if self.gold_card_points >= amount:
            self.gold_card_points = self.gold_card_points - amount 
        else: 
            print("Not Enough Points")
        return self 

    def add_point(self, add):
        self.gold_card_points += add
        return self

    def make_deposit(self, amount1=0, amount2=0):
        self.account.deposit(amount1)
        self.account2.deposit(amount2)
        return self
    
    def make_withdrawl(self, amount=0, amount2=0):
        self.account.withdraw(amount)
        self.account2.withdraw(amount2)
        return self
    
    def display_user_balance(self):
        print(self.first_name, self.last_name)
        self.account.display()
        self.account2.display()
        return self

    def transfer_money(self, amount, other_user):
        self.account.balance = self.account.balance + amount
        self = other_user
        self.account.balance = self.account.balance - amount
        return self


kara_cooper = User("Kara", "Cooper", "Cooper@gmail.com", 33)
sam_rickenbach = User("Sam", "Rickenbach", "samrickenbach@gmail.com", 28)

sam_rickenbach.make_deposit(300, 500).make_withdrawl(100).transfer_money(50, kara_cooper)
kara_cooper.make_deposit(600).make_withdrawl(100).display_user_balance()
sam_rickenbach.display_user_balance()


