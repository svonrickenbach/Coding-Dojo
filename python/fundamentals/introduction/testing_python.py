# import random

# print('Welcome to Python!')

# print('This is a loop printing 5 times')
# for x in range(1, 6):
#     print(f'x is: {x}')

# weekdays = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday']
# day = random.choice(weekdays)

# print(f'Today is: {day}')

# if day == 'Monday':
#     print('It will be a long week!')
# elif(day == 'Friday'):
#     print('Woohoo, time for the weekend!')
# else:
#     print('Not quite there yet.')


# x = 10 
# if x > 50: 
#     print("bigger than 50")
# else: 
#     print("smaller than 50")

# class EmptyClass: 
#     pass

# import random
# rand_num = (random.randint(2,5))
# print(rand_num)

# int_to_float = float(35)
# float_to_int =  int(44.2)
# int_to_complex = complex(35)
# print(int_to_float)
# print(float_to_int)
# print(int_to_complex)
# print(type(int_to_float))
# print(type(float_to_int))
# print(type(int_to_complex))

# name = "zen"
# print("my name is "  +  name)

# print ("hello " + str(42))

# total = 35 
# user_val = "26"
# # total = total + user_val
# total = total + int(user_val)
# print(total)

# Practice Challenge: Correct the errors!
# first_name = "Alana"
# last_name = "Da Silva"
# age = 36
# profession = "Software Developer"
# years_experience = 5

# greeting = f"Hello my name is {first_name} {last_name}."

# print(greeting) 
# # Desired output: Hello my name is Alana Da Silva

# print(f"I am {age} years old") 
# # Desired output: I am 36 years old

# print("I work as a {}.".format(profession))
# # Desired output: I work as a Software Developer.

# exp_string = "I have worked in the field for {} years."
# print(exp_string.format(years_experience))
# # Desired output: I have worked in the field for 5 years.

# print(f"I started in the field when I was {age - years_experience} years old.")
# # Desired output: I started in the field when I was 31 years old.

# string.upper("hello world")


# words = ["start","going","till","the","end"]
# # Sub-ranges (portions) of the list
# print(words[1:]) # prints ['going', 'till', 'the', 'end']
# print(words[:4]) # prints ['start', 'going', 'till', 'the']
# print(words[2:4]) # prints ['till', 'the']
    
# # Making a copy of a list
# copy_of_words = words[:]
# copy_of_words.append("dojo") # only appends to the copy
# print(copy_of_words) # prints ['start', 'going', 'till', 'the', 'end', 'dojo']
# print(words) # prints ['start', 'going', 'till', 'the', 'end']

# x = 10 
# while (x != 0):
#     print(x)
#     x -= 1

# my_list = ["abc", 123, "xyz"]
# for i in range (0, len(my_list)):
#     print(i, my_list[i])

# for v in my_list:
#     print(v, my_list[v])

# for val in "string":
#     if val == "i":
#         break
#     print(val)

# val = "string"
# for i in range(0, 3):
#     print(val[i])

# def full_name(first, last):
#     return first + " " + last

# name1 = full_name("Eddie", "Aikau")
# print(name1) # should print Eddie Aikau

# def full_name(first, last):
#     return first, last

# name1 = full_name("Eddie", "Aikau")
# print(name1) # should print Eddie Aikau

# set defaults when declaring the parameters
# def be_cheerful(name='', repeat=2):
# 	print(f"good morning {name}\n" * repeat)
# be_cheerful()
# be_cheerful("tim")
# be_cheerful(name="john")
# be_cheerful(repeat=6)
# be_cheerful("michael", 5)
# be_cheerful(repeat=3, name="kb")

def multiply(num_list, num):
    for x in range(len(num_list)): 
        num_list[x] *= num 
    return num_list
a = [2, 4, 10, 16]
b = multiply(a, 5)
print(b)
