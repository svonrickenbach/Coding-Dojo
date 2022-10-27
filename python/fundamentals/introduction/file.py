num1 = 42 #variable declatration, number, integer 
num2 = 2.3 # variable declaration, number, float
boolean = True #boolean 
string = 'Hello World' #variable declaration, string initialize
pizza_toppings = ['Pepperoni', 'Sausage', 'Jalepenos', 'Cheese', 'Olives'] #composite, initialize list
person = {'name': 'John', 'location': 'Salt Lake', 'age': 37, 'is_balding': False} #composite, initialize dictionary 
fruit = ('blueberry', 'strawberry', 'banana') #composite, initialize tuples
print(type(fruit)) #log statement, type check on a tuples
print(pizza_toppings[1]) #log statement, access value, list 
pizza_toppings.append('Mushrooms') #log statement, add value, list 
print(person['name']) #log statement, access value, dictionary 
person['name'] = 'George' #change value, dictionary
person['eye_color'] = 'blue' #add value, dictionary
print(fruit[2]) #log statement, access value, tuples

if num1 > 45:               #conditional, if, number
    print("It's greater")   #log statement, string
else:                       #conditional, else
    print("It's lower")     #log statement, string

if len(string) < 5:            #conditional, if, function, number
    print("It's a short word!") #log statement, string
elif len(string) > 15:          #conditional, else if, function, number
    print("It's a long word!")  #log statement, string
else:                           #conditional, else
    print("Just right!")        #log statement, string 

for x in range(5):      #for loop, variable declartion, argument, start
    print(x)            #log statement, stop, parameter
for x in range(2,5):    #for loop, variable declaration, argument, start
    print(x)            #log statement, stop, parameter
for x in range(2,10,3): #for loop, variable declaration, arugment, start 
    print(x)            #log statement, stop, parameter 
x = 0                   #variable declaration, number 
while(x < 5):           #while loop, variable declaration, number, start
    print(x)            #log statement, parameter 
    x += 1              #increment

pizza_toppings.pop()    #delete value, list
pizza_toppings.pop(1)   #access value, delete value, list 

print(person)           #log statement, access value, dictonary 
person.pop('eye_color') #function, delete value, dictionary
print(person)           #log statement, dictionary

for topping in pizza_toppings:      #for loop
    if topping == 'Pepperoni':      #conditional, string
        continue                    #continue
    print('After 1st if statement') #log statement, string
    if topping == 'Olives':         #conditional, string 
        break                       #break

def print_hello_ten_times():    #function 
    for num in range(10):       #argument
        print('Hello')          #log statement 

print_hello_ten_times()         #return 

def print_hello_x_times(x):     #function 
    for num in range(x):        #variable declaration 
        print('Hello')          #log statement, string

print_hello_x_times(4)

def print_hello_x_or_ten_times(x = 10):     #function 
    for num in range(x):                    #variable declaration 
        print('Hello')                      #function, string

print_hello_x_or_ten_times()            #function, return
print_hello_x_or_ten_times(4)           #function, return


"""
Bonus section
"""

# print(num3)                       """#NameError: name <variable name> is not defined
# num3 = 72                         """
# fruit[0] = 'cranberry'            #TypeError: 'tuple' object does not support item assignment
# print(person['favorite_team'])    #KeyError: 'favorite_team'
# print(pizza_toppings[7])          #IndexError: list index out of range
#   print(boolean)                  #IndentationError: unexpected indent
# fruit.append('raspberry')         #AttributeError: 'tuple' object has no attribute 'append'
# fruit.pop(1)                      #AttributeError: 'tuple' object has no attribute 'pop'