public class Instructions {

    private static String instructions;

    public static String getInstructions(){
        instructions = "How to Play:\n" +
                "\n" +
                "Enter your name, then choose a number of tokens to bet.\n" +
                "\n" +
                "You'll then be dealt 5 random cards. \n" +
                "\n" +
                "If, for whatever reason, you don't like your cards, you can remove up to all 5 of them - once!\n" +
                "\n" +
                "You'll be dealt new cards equal to the number of cards you deleted.\n" +
                "\n" +
                "When shaping your hand, keep in mind the winning card combinations:\n" +
                "\n" +
                "Royal Flush (250x winnings): hand containing cards 10 through Ace, all of the same suit.\n" +
                "\nStraight Flush (50x winnings): hand containing 5 consecutively ranked cards, all of the same suit.\n" +
                "\nFour of a Kind (25x winnings): hand containing 4 cards of the same rank.\n" +
                "\nFull House (9x winnings): hand containing any 2 cards of the same rank, " +
                "and another 3 cards of the same rank.\n" +
                "\nFlush (6x winnings): hand containing 5 cards of the same suit.\n" +
                "\nStraight (4x winnings): hand containing 5 cards of consecutive rank.\n" +
                "\nThree of a Kind (4x winnings): hand containing 3 cards of the same value.\n" +
                "\nTwo Pairs (2x winnings): hand containing 2 pairs of 2 cards of the same rank.\n";
        return instructions;
    }

}