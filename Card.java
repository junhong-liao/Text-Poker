/* Junhong Liao
 * Card.java - creates card object and grants the ability to access the card's suit and rank.
 */

// throw an exception.

public class Card implements Comparable<Card> {
	
	private int suit; // integers 1-4 represent the suit
	private int rank; // integers 2-14 represent the rank
	
	public Card(int s, int r){
        this.suit = s;
        this.rank = r;
	}
    
    public Card() {/*empty on purpose*/}
	
	public int compareTo(Card c) { // allows comparable interface.
        if(this.rank > c.rank) {
            return 1;
        } else if(this.rank == c.rank) {
            return 0;
        } else {
            return -1;
        }
	}
    
    public int getSuit(){
        return suit;
    }
    
    public int getRank(){
        return rank;
    }
	
//	public String toString(){
//        if(suit == 1) {
//            return "Suit: Clubs || Rank: "+rank;
//        } else if (suit == 2) {
//            return "Suit: Spades || Rank: "+rank;
//        } else if (suit == 3) {
//            return "Suit: Diamonds || Rank: "+rank;
//        } else if (suit == 4) {
//            return "Suit: Hearts || Rank: "+rank;
//        } else {
//            return "Error";
//        }   
//    }
}
