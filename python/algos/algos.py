#1
def push_front(input, num):
    pass 

push_front([1,2,3,4,5], 8)


 # Min to Front
def min_to_front(input):
    print(input)
    min = input[0]
    min_idx = 0
    for i in range(len(input)-1):
        if input[i] < min:
            min = input[i]
            min_idx = i
    for i in range(min_idx, 0, -1):
        input[i] = input[i-1]
        # print(input)
    input[0] = min
    return input

print(min_to_front([2,-7]))