import random
tries = 3
score = 3

while tries > 0:
    num1 = random.randint(0,10)
    num2 = random.randint(0,10)
    opNum = random.randint(1,3)
    if opNum == 1:
      print(f"{num1} + {num2} = ")
      equa = num1 + num2 
      inp = int(input())
      if inp == equa:
        score = score + 1
      else:
        tries = tries + 1

    if opNum == 3:
      print(f"{num1} * {num2} = ")
      equa = num1 * num2 
      inp = int(input())
      if inp == equa:
        score = score + 1
        
      else:
        tries = tries + 1