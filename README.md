# Mine-Searching v1.1

## Overview

A classic Minesweeper game inspired by the Windows XP version that I developed in 2004 using the Swing framework.

## Requirements

Java Runtime Environment (JRE) 1.8

Note: The program is optimized for JRE 1.8 and may not run correctly on newer versions.

## The purpose of the game

The objective of the Minesweeper game is to locate all the mines hidden on the game board as quickly as possible without clicking on any of them. If you click on a square that contains a mine, you lose the game.

## Game rules

- You can open squares by clicking with the left mouse button. The first revealed square never contains a mine!
- The number displayed under the square indicates how many of the eight adjacent squares contain mines.
- You can mark the squares you believe contain mines by pressing the right mouse button. These marked squares will display a flag and are protected from being opened to avoid accidentally triggering the mines beneath them. You can remove the flag by pressing the right mouse button again.
- If a square reveals an empty space, it means that none of the neighboring squares contain mines. In this case, the surrounding area will automatically be cleared up to the squares marked with numbers.
- If a numbered square has exactly the same number of flags around it as the number it indicates, clicking on the numbered square will reveal all of its neighboring squares. Naturally, the squares marked with flags remain untouched. However, if any of the flags were placed incorrectly, an explosion is inevitable.
- Depending on the settings, you can also place question marks on squares when you're uncertain about their contents.
- The clock, located in the top-right corner of the game board, starts when you reveal the first square and counts up to a maximum of 999 seconds.
- The counter in the top-left corner shows how many mines are hidden in the minefield, and how many still need to be located. Each time you mark a square with a flag, the mine counter decreases by one. Removing a flag increases the counter by one. However, you cannot place more flags than the actual number of mines. If you attempt to do so, the program will display a warning message.
- The game ends successfully when all mines have been correctly marked.
- To start a new game, press the icon button located between the mine counter and the clock.

## Levels, Records

The game can be played on three predefined minefield sizes, which are as follows:

- Beginner level: 9 × 9 grid, 10 mines;
- Intermediate level: 16 × 16 grid, 40 mines;
- Expert level: 16 × 30 grid, 70 mines.

There is also the option to customize the minefield. The following limits are available for customization:

- Minefield height: 9–16 squares;
- Minefield width: 9–30 squares;
- Number of mines: 1 to 30% of the total number of squares.

Each predefined level stores the three best results, showing the name of the record holder, the achieved time, and the date the record was set. A dialog box prompts the player to enter their name if a new record is achieved. If the name field is left empty, the record will be saved as "Anonymous." The records can be viewed or cleared by opening the "Best Times" dialog box.

## Settings

The following settings, except for "Themes," can be adjusted before completing each game.

__Use of Question Marks:__

When enabled, you can place question marks on unexplored squares. Disabling this option will remove the ability to place question marks, and all existing question marks will be cleared.

__Clear Numbers:__

If this option is checked, unnecessary numbered squares will be removed. A numbered square becomes unnecessary when the number of surrounding squares matches the value indicated on the square, and all these squares are flagged. Enabling this setting will make it significantly easier to review the game board. When the option is turned off, all numbered squares will become visible again.

__Danger Indication:__

With this setting enabled, the background of any square will be colored if there are more flags placed around it than the square indicates. If you encounter such a situation, it may be wise to reconsider the possible locations of mines, as further clicks might lead to explosions. If you disable this setting, the background of each square will revert to its original color.

__Flag Flashing:__

After successful exploration, flags placed on squares can be made to flash.

__Themes:__

The game interface can be changed to three different "themes," each providing a different appearance. The available themes are:

- Windows
- Metal
- CDE/Motif

## Source code

The source code is currently under review and will be uploaded at a later time.

## Screenshots

<img src=docs/05.png alt="" width="400">
<br>
<img src=docs/02.png alt="" width="400">
<br>
<img src=docs/11.png alt="" width="400">
<br>
<img src=docs/13.png alt="" width="400">