#       range(n,n1)
store = ["Water","Food","Apples","Milk","Pineaple","Orange Juice","Cookies","Cereal","Eggs","Strawberries",]

option = ["1.) Remove", "2.) Add"]

print("Welcome to Iliana's Groecery Store")

while True:
    for i in range(0,10):
        print(store[i])
    print("What would you like to do:")

    for i in option:
        print[i]
    inp = input()
    if inp == "1":
        print("What would you like to remove")