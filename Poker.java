/* Junhong Liao
 * Tests both versions of Game.java
 * 
 */

public class Poker{ //consider adding blackjack, or other modes of poker.*9+
    public static void main(String[] args) {
    	if (args.length<1){
             Game g = new Game();
             g.play();
         }
         else {
             Game g = new Game(args);
        }
    }

}

