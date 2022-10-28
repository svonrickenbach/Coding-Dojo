for i in range(0, 151):
    print(i)

# x = 0 
# while x <= 150: 
#     print(x)
#     x += 1

for i in range(5, 1001, 5):
        print(i)

# x=5 
# while x <= 1000:
#     print(x)
#     x += 5

for i in range(1, 101):
    if i % 10 == 0:
        print("Coding Dojo")
    elif i % 5 == 0: 
        print("Coding")
    else: print(i)

# x = 1 
# while x <= 100: 
#     if x % 10 == 0: 
#         print("Coding Dojo")
#     elif x % 5 == 0:
#         print("Coding")
#     else: print(x)
#     x +=1 

x=0
for i in range(1, 500001):
    if i % 2 != 0:
        # print(i) 
        x = x + i 
print(x)

for i in range(2018, 0, -4):
    print(i)

# x = 2022
# while x >= 4: 
#     x = x - 4
#     print(x)


mult = 5
lowNum = 1
highNum = 20 
for i in range(lowNum, highNum + 1):
    if i % mult == 0:
        print(i)