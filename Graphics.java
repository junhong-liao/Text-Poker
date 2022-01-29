/* Junhong Liao
 * Graphics.java - dynamic graphics for the cards.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Graphics {
	
	private HashMap<Integer, String>suitSelector = new HashMap<>(), rankSelector = new HashMap<>();
	private int currSuit;
	private int currRank;
	
	public Graphics() {
		
		suitSelector.put(1, "C");
		suitSelector.put(2, "S");
		suitSelector.put(3, "D");
		suitSelector.put(4, "H");
		
		rankSelector.put(11, "J");
		rankSelector.put(12, "Q");
		rankSelector.put(13, "K");
		rankSelector.put(14, "A");
	}

	public void displayHandHorizontal(ArrayList<Card> hand) {

		for(int i = 0; i < hand.size(); i++) System.out.print(" _________  ");
		
		System.out.println();
		for(int i = 0; i < hand.size(); i++) {
			this.currRank = hand.get(i).getRank();
			if(currRank == 10) System.out.print("|"+currRank+"       | ");
			else if(currRank > 10) System.out.print("|"+rankSelector.get(currRank)+"        | ");
			else System.out.print("|"+currRank+"        | ");
		}
		
		System.out.println();
		for(int i = 0; i < hand.size(); i++) System.out.print("|         | ");
	
		System.out.println();
		for(int i = 0; i < hand.size(); i++) System.out.print("|         | ");
		
		System.out.println();
		for(int i = 0; i < hand.size(); i++) { 
			this.currSuit = hand.get(i).getSuit();
			System.out.print("|    "+suitSelector.get(currSuit)+"    | ");
		}
		
		System.out.println();
		for(int i = 0; i < hand.size(); i++) System.out.print("|         | ");
		
		System.out.println();
		for(int i = 0; i < hand.size(); i++) System.out.print("|         | ");
		
		System.out.println();
		for(int i = 0; i < hand.size(); i++) {
			this.currRank = hand.get(i).getRank();
			
			if(currRank == 10) System.out.print("|_______"+currRank+"| ");
			else if(currRank > 10) System.out.print("|________"+rankSelector.get(currRank)+"| ");
			else System.out.print("|________"+currRank+"| ");
		}
		
		System.out.println();
	}
}
