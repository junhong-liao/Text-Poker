/* Junhong Liao
 * Deck.java - Creates deck object and grants the ability to deal cards, shuffle the deck, print the deck, and access the top variable.
 */

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private ArrayList <Card> cards = new ArrayList <Card>();
	private int top = 0; // the index of the top of the deck
	
	public Deck(){  
        for(int i = 1; i <= 4; i++) {
            for(int j = 2; j <= 14; j++) {
                Card c = new Card(i,j);
                cards.add(c);
            }
        }
	}
	
	public void shuffle(){ // should be called every time the deal loop is called
        
        this.top = 0; // sets the deck pointer back to the top.
        
        int random;
        Card temp = new Card();
        Random rand = new Random();
        
        for(int a = 0; a < 5; a++) { //performs the shuffle 5 times
            
            for(int i = 0; i < cards.size(); i++){
                random = rand.nextInt(52);
                temp = cards.get(i);
                cards.set(i, cards.get(random));
                cards.set(random, temp);
            }
        }
        // Collections.shuffle(this.cards); // this works, but i wanted to try making my own shuffle program
	}
	
	public Card deal(){ // CHANGE: while hand size is less than 5, deal.
        return cards.get(top++);
	}
    
    public void printDeck(){
        for(int i = 0; i < cards.size(); i++) {
            System.out.println(cards.get(i));
        }
    }
}
