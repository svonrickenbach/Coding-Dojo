# # Question #1

x = [ [5,2,3], [10,8,9]]
students = [ 
    {'first_name': 'Michael', 'last_name': 'Jordan'},
    {'first_name': 'John', 'last_name': 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer': ['Messi', 'Ronaldo', 'Rooney']
}
z = [{'x': 10, 'y':20}]

# # 1.
x[1][0] = 15
print(x)

# # 2.
students[0]['last_name'] = 'Bryant'
print(students[0])

# # 3.
sports_directory['soccer'][0] = 'Andres'
print(sports_directory['soccer'])

# # 4. 
z[0]['y'] = 30 
print(z)

# Question #2 

students = [
        {'first_name':  'Michael', 'last_name' : 'Jordan'},
        {'first_name' : 'John', 'last_name' : 'Rosales'},
        {'first_name' : 'Mark', 'last_name' : 'Guillen'},
        {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]

def iterateDictionary(students):
    for i in students: 
        print(f"first_name -", i['first_name'] + ",", "last_name -", i['last_name'])
iterateDictionary(students)

# Question #3

students = [
        {'first_name':  'Michael', 'last_name' : 'Jordan'},
        {'first_name' : 'John', 'last_name' : 'Rosales'},
        {'first_name' : 'Mark', 'last_name' : 'Guillen'},
        {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]

def iterateDictionary2(key_name, list):
    for i in list:
        print(i[key_name])
iterateDictionary2("first_name", students)
iterateDictionary2("last_name", students)

# Question #4

dojo = {
    'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
    'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}

def printInfo(some_dict):
    for key in some_dict:
        print(len(some_dict[key]), key)
        for value in some_dict[key]:
            print(value)
printInfo(dojo)