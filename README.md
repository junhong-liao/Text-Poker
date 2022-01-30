# Welcome to project: Space Poker!

**Project Description:**
***
Space Poker is my attempt to recreate video poker in Java with a user interface.
Space Poker is abstracted into several .java files:

**1. Card.java**: Contains the code for creating the `Card` object with a suit of Heart, Diamond, Spade, or Clubs, and a rank between 2 (2) to 14 (Ace). Card.java also implements the Comparable interface, which allows cards to be compared to each other, and thus sorted.

**2. Deck.java**: Contains the code to construct a Deck object, which constructs an ArrayList of 52 Card objects that represent a standard deck of playing cards. The Deck object can be shuffled, printed, and can deal cards.

**3. Player.java**: Contains the code to construct a `Player` (that's you!). Every `Player` object has a hand (5 cards TBD), a `playerID` chosen by the player, and an initial token balance of 100. This class and its methods are primarily focused on the player's `hand`, which can be removed from, added to, and sorted. `Players` are also able to place their bets, and their final hands are scored using logic from this class.

**4. Graphics.java**: Contains the code to dynamically display playing cards by passing information from an ArrayList of cards and using HashMaps to determine what `suit` and `rank` will be shown.

**5. Poker.java**: Poker.java is simply the class that contains the main method. From this method, you are also able to run an alternate version of the Video Poker program by passing in manually typed cards into the `args` string (e.g. `java Poker s1 s2 s3 s4 s5`).

**6. Game.java**: The game class simply organizes the files to create the Video Poker program. It also gives you some statistics on your gameplay after the game concludes!

**7. Instructions.java**: A simple class that holds a String (Instructions to the game) as its only instance variable, and has a constructor that populates said String. It has one method that returns this String.


## A few additional features I'm considering adding:
***
1. Leaderboards (Bet Winrate / Games Played / Ending Balance)
2. Blackjack
3. Pao De Kuai / Dou Dizhu (Chinese Card Game, w/ up to 3 players)



## How to Install and Run the Project:
***
1. Download the files directly from this repository.
2. Run and compile the programs from terminal, or an IDE of your preference.
3. Enjoy Video Poker!


## How the Use the Project:
***                                                                   
Instructions: How to Play (Regular):

Enter your name, then choose a number of tokens to bet.

You'll then be dealt 5 random cards. 

If, for whatever reason, you don't like your cards, you can remove up to all five of them - once!

You'll be dealt new cards equal to the number of cards you deleted.

When shaping your hand, keep in mind the winning card combinations:

*Royal Flush (win 250x your bet): hand containing cards 10 through Ace, all of the same suit.
Straight Flush (win 50x your bet): hand containing five consecutively ranked cards, all of the same suit.
Four of a Kind (win 25x your bet): hand containing four cards of the same rank.
Full House (win 9x your bet): hand containing any two cards of the same rank, and three different cards of the same rank.
Flush (win 6x your bet): hand containing five cards of the same suit.
Straight (win 4x your bet): hand containing five cards of consecutive rank.
Three of a Kind (win 4x your bet): hand containing three cards of the same value.
Two Pairs (win 2x your bet): hand containing two pairs of two cards of the same rank.*

## Instructions (alt.): How to Test the Program (Debugging):
***

Initially, this feature was added for debugging purposes, but you can use it to test out a hand, or my overall program! Here's how it works:

Hearts, Diamonds, Clubs, and Spades can be represented with the letters 'h', 'd', 'c', and 's'

`Cards` numbered 2 through Ace can be represented with the numbers 2 - 14.

Note that the Ace card can be used as a '1' or a '14': for example: s14 c2 d3 h4 s5 is a 'Straight,' but c10 d11 h12 s13 s14 can also be a 'Straight.'

To test a potential hand, simply run the program in command line: java Poker [hand], where [hand] is a placeholder for any five cards of any suit/rank of your choosing.

