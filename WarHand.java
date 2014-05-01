import java.util.ArrayList;
public class WarHand extends Pile //this class creates a hand for a player engaged in a game of war
{
	private static Deck deck = new Deck(); //for holding a deck of cards - VARIABLE IS STATIC SO THAT WHEN SECOND HAND IS CREATED, IT CAN'T HAVE SAME CARDS AS THE FIRST HAND	
	
	/*
		Creates a warHand
	*/							
	public WarHand() //creates one war hand from half of a deck
	{		
		deck.shuffle();
		
		for (int i = 0; i < 26; i++)
		{
			addCard(deck.getCard(0)); //removes the first card from the deck and adds it to the hand
		}
	}
	
	/*
		Deck returns the remainder of the deck
		@return the deck
	*/
	public Deck getDeck()
	{
		return deck;
	}	
}