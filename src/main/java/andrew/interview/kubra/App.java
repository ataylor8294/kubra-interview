package andrew.interview.kubra;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        CardDeck deck = new CardDeck(false);
        CardDeck pinoche = new CardDeck(true);
        Random randomizer = new Random();
        System.out.println(deck.search("Acehearts"));
        System.out.println(deck.search("1spades"));
        System.out.println(deck.search("2spades"));
        deck.neworder();
        int count =1000;
        deck.neworder();
        while(count>1000) {
	        deck.shuffle();
	        System.out.println(deck.turnover());
	        deck.cut(10);
	        count--;
        }
        
    }
}
