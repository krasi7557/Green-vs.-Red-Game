# Green-vs.-Red-Game
Task for MentorMate DevCamp
This is a console game
We are given size for a 2D grid and coordinates for a target cell. 

Our mission is to check how many times through the generations, the cell becomes Green including Generation Zero.

"1" states for Green cell and "0" states for Red cell.

Rules of the game:

One cell can has up to 8 neighbours.

If a Green cell has 2, 3 or 6 green neighbours(including corners and sides) it REMAINS green.

If a Red cell has 3 or 6 green neighbours(including corners and sides) it CHANGES to green.

We have 3 lines input, respectively:

Size of the grid: columns(width) and rows(height), separated by ", "

Depending on the size of the grid, there are N lines of Strings required to input.

Last input presents the coordinates for our target cell(column, row), and number of generations to be made. This input is separated by ", "

Example for input:

1st:

4, 4

1001

1111

0100

1010

2, 2, 15

At last, we print the N times when our target cell became green.
