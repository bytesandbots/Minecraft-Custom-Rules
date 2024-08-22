print("Hi there, welcome to Iliana's Cafe")
Drinks = ["Cold Water","Orange Juice","Soda","Lemonade","Pink Lemonade","Apple Juice"]
Breakfast_Menu = ["Eggs and Bacon","Breakfast Burrito","Pancakes","Croissant","Waffles","Hash browns","French Toast","Burgerito","Quesadilla"]
for i in Drinks:
    print(i)
for i in Breakfast_Menu:
    print(i)
cart = []

inp = input("Pick a drink: ")
if inp in Drinks:
    cart.append(inp)
else:
    print("Not in menu")
    
inp = input("Pick a meal: ")
if inp in Breakfast_Menu:
    cart.append(inp)
else:
    print("Not in menu")
#Tell the user thier order
#for loop each item in cart
#Print each item
print("Your order is: ")
for i in cart:
    print(i)