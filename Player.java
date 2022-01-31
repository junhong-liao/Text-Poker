/* Junhong Liao
 * Player.java - Creates/manipulates the player's hand, creates/manipulates player's bankroll, and ranks cards.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Player {
	
	public ArrayList<Card> hand = new ArrayList <Card>();
	private String playerID;
	private int bankroll = 100; // all players start with 100 tokens. Gamble responsibly!
    private int bet;
    private Scanner s = new Scanner(System.in);
		
//	public Player(double bankroll){		
//	    this.bankroll = bankroll;
//	}
    
    public Player() {}
    
    public Player(String playerID){
    	this.playerID = playerID;
    }
    
    public String getID() {
    	return playerID;
    }
    
    public void clearHand() {
        hand.clear();
    }

	public void addCard(Card c){ //card must be passed in to be added: player.addCard(deck.deal());
	    hand.add(c);
	}
	
	public ArrayList<Card> getHand() {
		return this.hand;
	}

	public void removeCard(int index){
	    hand.remove(index);
    }
    
    public void sortHand(){
        Collections.sort(this.hand);
    }
		
    public boolean bets(int amt) { // could potentially put a try catch for every input that must be of a certain type.
        while(bankroll < amt || amt < 1) {
        	if(bankroll < amt) System.out.println("Insufficient funds. Current balance: "+bankroll);
        	if(amt < 1) System.out.println("Minimum bet size of 1.");
        	amt = s.nextInt();
        }
        
        bet = amt;
        bankroll -= amt;
        return true;

    }

    public void winnings(int multiplier){
        bankroll += (bet*multiplier);
    }
    public int getbankroll(){
        return bankroll;
    }
    public void printHand(){
        for(int i = 0; i < hand.size(); i++) {
            System.out.println(hand.get(i));
        }
    }
    
    // CARD RANKING METHODS: return booleans EXCEPT for fullhouse/four in a row checker
    
    public boolean rankHand() {
        
        boolean WL = false; // win / loss
        boolean iS = false; // is straight?
        boolean iF = false; // is flush?
        boolean s = true; // straight flag
        boolean f = true; // flush flag
        
            // is it a straight? if both are, we can check if it is also a royal flush

        
        for(int i = 0; i < this.hand.size()-1; i++) {
            if(this.hand.get(i).getRank() != (this.hand.get(i+1).getRank())-1) {
                s = false;
            }
        }
        
        if(this.hand.get(4).getRank() == 14) {
            if(this.hand.get(0).getRank() == 2 && this.hand.get(1).getRank() == 3 && this.hand.get(2).getRank() == 4 && this.hand.get(3).getRank() == 5) {
                s = true;
            }
        }
        
        for(int i = 0; i < this.hand.size()-1; i++) {
            if(this.hand.get(i).getSuit() != this.hand.get(i+1).getSuit()) {
                f = false;
            }
        }
            
            if (s && f) {
                iS = true;
                iF = true;
            } else if (f) {
                iF = true;
            } else if (s) {
                iS = true;
            }

            if(iS == true && iF == true && hand.get(0).getRank() == 9) { // straight and straight flushes, ace can be both 2 and 14
                
                WL = true;
                System.out.println("Royal Flush");
                bankroll += (bet*250); 
                return WL;
                
            } else if (iS == true && iF == true){
                
                WL = true;
                System.out.println("Straight Flush");
                bankroll += (bet*50);
                return WL;
            
            } else if (iS) {
                
                WL = true;
                System.out.println("Straight");
                bankroll += (bet*4);
                return WL;
                
            } else if(iF) {
                
                WL = true;
                System.out.println("Flush");
                bankroll += (bet*6);
                return WL;
            }
    
        return WL;
    }
    
    public boolean isCombo() {

        boolean WL = false;
        int count = 0;
        
        for(int i = 0; i < this.hand.size()-1; i++) {
            if(this.hand.get(i).getRank() == this.hand.get(i+1).getRank()) { // gets the match count for us
                count++;
            }
        }
            
        if(count == 0) {
            if(WL == false) {
                return WL; // logic here is that if none of the above is true with five unique cards, the player lost the hand.
            }
            
        } else if (count == 1) {

            WL = true;
            System.out.println("One Pair! +"+bet*1);
            bankroll += (bet*1);
            return WL;
            
        } else if (count == 2) { // hand with triples and a pair of doubles have the same amount of unique cards
           
            WL = true;
            
            boolean trip = false;
            boolean DD = false;
            
            for(int i = 0; i < this.hand.size()-2; i++) {
                if(this.hand.get(i).getRank() == this.hand.get(i+1).getRank() && 
                   this.hand.get(i+1).getRank() == this.hand.get(i+2).getRank()) {
                       trip = true;
                }
             }
            
            if(trip) {
                System.out.println("Three of a Kind! +"+bet*3);
                bankroll += (bet*3);
                return WL;
            } else {
                System.out.println("Two Pairs! +"+bet*2);
                bankroll += (bet*2);
                return WL;
            }
            
          } else if (count == 3) { // 2 can be EITHER full house OR a quadruple 
            
            WL = true;
            boolean isQuad = false;
            
            for(int i = 0; i < this.hand.size()-3; i++) {
                if(this.hand.get(i).getRank() == this.hand.get(i+1).getRank() && 
                   this.hand.get(i).getRank() == this.hand.get(i+2).getRank() &&
                   this.hand.get(i).getRank() == this.hand.get(i+3).getRank()) {
                    isQuad = true;
                }
            }
            if(isQuad == true) {
                System.out.println("Four of a Kind! +"+bet*25);
                this.bankroll += bet*25;
                return WL; 
            } else {
                System.out.println("Full House! +"+bet*6);
                this.bankroll += bet*6;
                return WL;
            }
          }
        return WL;
     }
}