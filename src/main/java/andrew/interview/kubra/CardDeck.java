package andrew.interview.kubra;

import java.util.LinkedList;
import java.util.Random;

public class CardDeck {
	private LinkedList<String> deck = new LinkedList<String>();
	private String cards="Ace,2,3,4,5,6,7,8,9,10,Jack,Queen,King";
	private String backwards="King,Queen,Jack,10,9,8,7,6,5,4,3,2,Ace";
	private String pinoche="9,Jack,Queen,King,10,Ace";
	private String suits="spades,diamonds,clubs,hearts";
	private LinkedList<String> freshDeck= new LinkedList<String>();
	private LinkedList<String> freshPinoche = new LinkedList<String>();
	private boolean pinocheMode=false;
	public CardDeck(boolean pinocheMode) {
		this.pinocheMode=pinocheMode;
		if (pinocheMode==false) {
			for (String card: cards.split(",")) {
				for (String suit: suits.split(",")) {
					deck.add(card+suit);
					freshDeck.add(card+suit);
					System.out.println(card+suit);
				}
			}
		}
		else {
			for (String card: pinoche.split(",")) {
				for (String suit: suits.split(",")) {
					deck.add(card+suit);
					freshPinoche.add(card+suit);
				}
			}
		}
	}
	
	
	public void shuffle() {
		Random randomizer = new Random();
		System.out.println(deck.size());
		deck.addAll(newDeck());
		int count;
		if (pinocheMode==false) {
			count = 51;
		}
		else {
			count=23;
		}
		LinkedList<String> shuffleddeck= newDeck();
		while (count>0) {
			
			int random = randomizer.nextInt(count);
			shuffleddeck.add(deck.get(random));
			deck.remove(random);
			count--;
		}
		System.out.println(shuffleddeck.size());
		deck = shuffleddeck;
	}
	public void cut(int point) {
		if(point>51 || point<0) {
			System.out.println("invalid point to cut at");
			return;
		}
		LinkedList<String> cutDeck = new LinkedList<String>();
		while (point<deck.size()) {
			cutDeck.add(deck.get(point));
			deck.remove(point);
		}
		cutDeck.addAll(deck);
		deck = cutDeck;
	}
	public String deal() {
		if (deck.size()>1){
			String dealtcard=deck.get(deck.size()-1);
			deck.remove(deck.size()-1);
			return dealtcard;
		}
		else {
			System.out.println("deck is empty");
			return null;
		}
		
	}
	public String turnover() {
		if (deck.size()>1) {
		return deck.get(deck.size()-1);
		}
		else {
			System.out.println("deck is empty");
			return null;
		}
		
	}
	public int search(String card) {
		if (deck.contains(card)) {
			return (deck.size()-1)-deck.indexOf(card);
		}
		else {
			System.out.println("the deck does not contain this card");
			return -1;
		}
	}
	public void neworder() {
		LinkedList<String> orderedDeck = new LinkedList<String>();
		for (String suit: suits.split(",")) {
			if (suit.equals("spades")) {
				for (String card : cards.split(",")) {
					orderedDeck.add(card+suit);
				}
			}
			else if (suit.equals("diamonds")){
				for (String card : cards.split(",")) {
					orderedDeck.add(card+suit);
				}
			}
			else if (suit.equals("clubs")) {
				for (String card : backwards.split(",")) {
					orderedDeck.add(card+suit);
				}
			}
			else {
				for (String card : backwards.split(",")) {
					orderedDeck.add(card+suit);
				}
				
			}
		}
		deck = orderedDeck;
	}
	private LinkedList<String> newDeck(){
		if (pinocheMode==false)
			return freshDeck;
		else {
			return freshPinoche;
		}
	}
	
}
