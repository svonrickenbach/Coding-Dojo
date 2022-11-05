class Pet: 
    def __init__(self, name, type, tricks):
        self.name = name 
        self.type = type
        self.tricks = tricks
        self.health = 10 
        self.energy = 10 
    
    def __repr__(self):
        return self.name

    def display_info(self):
        print("===============")
        print(self.name)
        print(self.type)
        print(self.tricks)
        print(self.health)
        print(self.energy)
        return self
    
    def sleep(self):
        print(f"Your pet {self.name} the {self.type} took a nap!")
        self.energy += 25
        return self
    
    def eat(self):
        print(f"Your pet {self.name} had a snack!")
        self.energy += 5
        self.health += 10
        return self

    def play(self):
        print(f"Your pet {self.name} had some playtime!")
        self.health += 5
        return self
    
    def noise(self):
        if self.type == "dog": 
            print("bark bark!")
        if self.type == "cat": 
            print("Purrrrrrr!")
        if self.type == "horse": 
            print("Nay!")
        if self.type == "parrot": 
            print("Poly wants a cracker!")
        return self

class Mammals(Pet):
    def __int__(self, name, type, tricks):
        super().__init__(self, name, type, tricks)

nala = Mammals("Nala", "dog", "zoomies")
# nala.display_info()

poly = Pet("Poly", "parrot", "talking")
