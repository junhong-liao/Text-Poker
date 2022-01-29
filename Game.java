/* Junhong Liao
 * Game.java - plays the game
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.StringBuilder;

public class Game {
	
	public Game(String[] testHand){
        
        Player p = new Player();
        String sub;
        
        for(int i = 0; i < testHand.length; i++) { // clubs spades diamonds hearts
        	if(testHand[i].length() == 3) {
			    sub = testHand[i].substring(1,3);
			    p.addCard(new Card(1, Integer.valueOf(sub)));
			} else if(testHand[i].length() == 2) {
			    sub = testHand[i].substring(1,2);
			    if(testHand[i].charAt(0) == 'c') p.addCard(new Card(1,Integer.valueOf(sub)));
			    else if(testHand[i].charAt(0) == 's') p.addCard(new Card(2,Integer.valueOf(sub)));
			    else if(testHand[i].charAt(0) == 'd') p.addCard(new Card(3,Integer.valueOf(sub)));
			    else if(testHand[i].charAt(0) == 'h') p.addCard(new Card(2,Integer.valueOf(sub)));
			} 
        }
                	
        p.sortHand();
        
        if(p.rankHand() == false && p.isCombo() == false) {
            StringBuilder strbdr = new StringBuilder();
            for(String str: testHand) strbdr.append(str+" ");
            System.out.println(strbdr.toString()+"is not a winning hand");
        }
	}
	
	public Game(){/*empty on purpose*/}
	
	public void play(){
        
		ArrayList <String> WLratio = new ArrayList<>();
		Graphics graphicsCard = new Graphics();
		Scanner scan = new Scanner(System.in);
        int remove;
        
        System.out.println("Welcome to Jun's Video Poker Project!");

        System.out.println("Would you like to view the instructions for how to play Video Poker? " +
                "(Enter 'Y' for Yes, or anything else for No): ");
        if(scan.next().equals("Y") || scan.next().equals("y")) {
            System.out.println("\n\n\n*****\n");
            System.out.println(Instructions.getInstructions());
            System.out.println("*****\n\n\n");
        }

        System.out.println("To start, enter your username");
        String IDcheck = scan.next();
        
        Player p = new Player(IDcheck);
        Deck d = new Deck();
                
        d.shuffle();
        
        while(p.getbankroll() >= 1) {
            
            System.out.println("Place your bet! (Remaining tokens: "+p.getbankroll()+")");
            
            p.bets(scan.nextInt());
        
            for(int i = 0; i < 5; i++) p.addCard(d.deal());
            
            p.sortHand();
            System.out.println("Your hand:");
            graphicsCard.displayHandHorizontal(p.getHand());
            
            System.out.println("\nDiscard cards?\n");
        
            for(int i = 0; i < 5; i++){
            System.out.println("Remove card #"+(i+1)+"? (enter 1 for yes, enter anything else for no)");
            remove = scan.nextInt();
                if(remove == 1) {
                    p.hand.set(i, d.deal());
                }
            }
            
            p.sortHand();
            graphicsCard.displayHandHorizontal(p.getHand());
            
            System.out.println();
            if(p.rankHand() == false && p.isCombo() == false) {
            	System.out.println("You lost your wager. Better luck next time!\n");
            	WLratio.add("L");
            } else {
            	WLratio.add("W");
            }
            
            d.shuffle();
            p.clearHand();
            
            System.out.println("Play again? Enter 'Y' for yes, or press anything else to stop playing.");
            if(scan.next().equals("Y")) {
            	continue;
            } break; 
        }
        System.out.println("Game over, "+p.getID()+"! Your ending token balance is "+p.getbankroll());
        double ratio = 100*(double)Collections.frequency(WLratio,"W") / ((double)Collections.frequency(WLratio,"W") + (double)Collections.frequency(WLratio,"L")); 
        
        System.out.print("You won "+ratio+"% of the bets you made. ");
        
        if(ratio < 50) {
        	System.out.print("*Cough* Novice *Cough*");
        } else if (ratio >= 50 && ratio < 60) {
        	System.out.print("Not bad.");
        } else if (ratio >= 60 && ratio < 70) {
        	System.out.print("Great job!");
        } else if (ratio >= 70 && ratio < 100) {
        	System.out.print("You're a High Roller!");
        } else if(ratio == 100 && Collections.frequency(WLratio,"W") > 3) {
        	System.out.print("Well, what're you waiting for? Go buy a lottery ticket with all that luck!");
        } else {
        	System.out.print("Hmph. Beginners luck.");
        }
	}
}

