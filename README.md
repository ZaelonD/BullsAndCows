# As part of this project, the game "Bulls and Cows" was developed
  __Rules of the game.__
  1. The program thinks of a string of four different numbers.
  Example: 0123
  2. A person tries to guess this number by entering a string of four digits into the console.
  Example: 3521
  3. The program produces the following result. If the digit is in the guessed line and is in its place,
  then this is a “bull”, if the number is in the guessed line, but not in its place, then this is a “cow”.
  Sample output of the program: 2 cows 1 bull.
  (The endings of words must be correct, that is, there should not be 1 bull 2 cow)
  4. The result of the game must be written to a file in the following format:
  ```
     Game №1 08.05.2021 6:46 Hidden line 0123
       Request: 3521 Answer: 2 cows 1 bull
       Request: 0134 Answer: 1 cow 2 bulls
       ...
       The string was guessed in 5 attempts.
     Game №2 05.08.2021 7:52 Hidden line 0452
       ...
```
  6. When you start the program again. You need to read the number of the last game from the file
  and continue numbering while recording.
