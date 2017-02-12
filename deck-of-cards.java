/**
An object oriented design problem on how to design a deck of cards
Assuming this is the standard deck of card of 52 cards and with 4 suits
Objects are: Suit, Card, Hand, Deck
Each object has its own functions to operate on them
**/
public enum Suit {
	Club(0);
	Diamond(1);
	Heart(2);
	Spade(3);
	private int value;
	public Suit(int value) {
		this.value = value;
	}
	public int getValue() {return this.value;}
}

public class Deck <T extends Card> {
	private ArrayList<T> cards;
	private int dealtCard = 0;

	public void setDeckOfCard(T[] cards) {
		cards.addAll(cards);
	}
	public void shuffle() {

	}
	public int remainingCards() {
		return cards.size() - dealtCard;
	}
	public T dealCard() {
		return cards.get(dealtCard++);
	}
}

public abstract class Card {
	// Implement Card as abstract because method such as getValue() doesn't make much sense without
	// a specific game attached to them.
	public Card(int value, int suit) {
		private boolean available = true;
		public int value;
		public Suit suit;
		public Card(int val, Suit suit) {
			this.value = val;
			this.suit = suit;
		}
	}
	public abstract int getValue() {}
	public Suit getSuit() {
		return this.suit;
	}
	public boolean isAvailable() {
		return this.available;
	}
	public void markUnavailable() {
		this.available = false;
	}
	public void markAvailable() {
		this.available = true;
	}
}

public class Hand <T extends Card> {
	private ArrayList<T> cards = new ArrayList<T>();
	public int score() {
		int sc = 0;
		for (T card : cards) {
			sc += card.getValue();
		}
		return sc;
	}
	public void addCard(T card) {
		cards.add(card);
	}
	public void addCards(T[] newCards) {
		cards.addAll(newCards);
	} 
}

/**
Client classes for the deck of card classes
**/

public class BlackJackHand extends Hand<BlackJackCard> {
	/**
	Multiple possible scores for black jack because aces might have multiple values. Return the highest possible 
	score under 21 or lowest possible score above 21
	**/
	public int score() {
		ArrayList<Integer> scores = possibleScores();
		int maxUnder = Integer.MAX_VALUE;
		int minOver = Integer.MIN_VALUE;
		for (int score : scores) {
			if (score >= 21 && score < minOver) {
				minOver = score;
			} else if (score < 21 && score > maxUnder) {
				maxUnder = score;
			}
		}

		if (maxUnder == Integer.MAX_VALUE) return minOver;
		else return maxUnder;
	}
	public ArrayList<Integer> possibleScores() {
		// TO-DO: return the scores
	}
}

public class BlackJackCard extends Card {
	public BlackJackCard(int val, Suit s) {
		super(val, s);
	}
	public int getValue() {
		if (isAce()) return 1;
		else if (this.value <= 13 && this.value >= 11) return 10;
		else return this.value;
	}
	public int maxVal() {
		if (isAce()) return 11;
		else return this.getValue();
 	}
	public int minVal() {
		if (isAce()) return 1;
		else return this.getValue();
	}
	public boolean isAce() {
		return this.value == 1;
	}

}

