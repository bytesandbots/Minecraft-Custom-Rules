import random
RN = random.randint(1,45)
tries = 10
while tries > 0:
    inp = input()
    if inp == RN:
        print("You Win!")
        break
    if inp < RN:
        print("Smaller")
    if inp > RN:
        print("Bigger")
        tries = tries - 1
