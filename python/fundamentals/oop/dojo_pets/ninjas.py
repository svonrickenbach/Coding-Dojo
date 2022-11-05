import pets

class Ninja(): 
    
    def __init__(self, first_name, last_name, pet, treats, pet_food):
        self.first_name = first_name
        self.last_name = last_name
        self.pet = pet
        self.treats = treats
        self.pet_food = pet_food

    def __repr__(self):
        return f"Hi my name is {self.first_name}, {self.last_name} and this is my pet {self.pet}. {self.pet} enjoys {self.treats} as a snack and eats {self.pet_food}."

    def walk(self):
        print(f"Your pet {self.pet} is being walked!")
        self.pet.play()
        return self


    def feed(self):
        print(f"Your pet {self.pet} ate!")
        self.pet.eat()
        return self

    def bathe(self):
        print(f"Your pet {self.pet} is clean!")
        self.pet.noise()
        return self


ninja1 = Ninja("Sam", "Rickenbach", pets.nala, "Cheese", "Call of the wild")
print(ninja1)
ninja1.walk().feed().bathe()
pets.nala.display_info()

ninja2 = Ninja("Kara", "Coops", pets.poly, "Crackers", "More Crackers")
print(ninja2)
ninja2.walk().feed().bathe()
pets.poly.display_info()