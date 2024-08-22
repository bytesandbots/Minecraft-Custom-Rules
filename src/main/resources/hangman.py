import random

words = []
word = random.choice(words)
guessed_word = ["_"] * len(word) 
attempts = 6

while attempts > 0 and "_" in guessed_word:
    print(" ".join(guessed_word))
    guess = input("Guess a letter: ").lower()

    if guess in word:
        for i, letter in enumerate(word):
            if letter == guess:
                guessed_word[i] = guess