# Mastermind Game

## Objective of the Game:

Mastermind is a code-breaking game for two players. 
Your objective is to crack the random four color code that the AI generates in
as few turns as possible.

You will receive feedback based on your guesses in the form of "X" and "O". 

**X** means: You picked a correct color in the correct spot

**O** means: You picked a correct color but in the wrong spot

The colors you have to choose from are in the form of initials:

[r] - red
[b] - blue
[g] - green
[y] - yellow
[o] - orange
[p] - purple

## Sample Game Play

If the AI generates a random code of "rgby"

1. My first guess: bgyy
2. My feedback: "XOO"
3. My second guess: "bygr"
4. My feedback: "OOOO"
5. My third guess: "rbyg"
6. My feedback: "XOOO"
7. My fourth guess: "rybg"
8. My feedback: "XXOO"
9. My fifth guess: "rygb"
10. My feedback: "XOOO"
11. My sixth guess: "rgby"
12. My feedback: "XXXX"


##To Play This Game
1. clone the repo: `git clone https://github.com/meaganewaller/mastermind.git`

2. cd into the directory: `cd mastermind`

3. compile the java files: `javac src/com/mastermind/*.java`

4. cd to src directory: `cd src`

5. jar the files: `jar cfm ../PlayGame.jar ../manifest.txt
   com/mastermind/*.class`

6. cd to main directory: `cd ..`

7. play the game: `java -jar PlayGame.jar`



