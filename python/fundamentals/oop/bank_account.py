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
        print(f"Interest Rate: {self.int_rate}")
        print(f"Account Balance: {self.balance}")
        print("=================")
        return self

    def interest_rate(self):
        if self.balance > 0: 
            self.balance *= 1 + self.int_rate
        return self
    
    # @classmethod
    # def all_info(cls):
    #     for accounts in cls.all_accounts:
    #         accounts.display()


account1 = BankAccount(0.01, 500)
account2 = BankAccount(0.02, 1000)

account1.deposit(100).deposit(200).deposit(150).withdraw(200).interest_rate().display()
account2.deposit(100).deposit(135).withdraw(500).withdraw(50).withdraw(130).withdraw(45).interest_rate().display()

# BankAccount.all_info()

# Question:
# How would I see what is stored in all_accounts[]?