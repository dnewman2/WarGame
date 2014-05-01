import java.util.Random;
import java.util.ArrayList;
public class Deck extends Pile
{
	/*
		Constructor creates a 52 card deck
	*/
	public Deck() //constructor creates a 52 card deck
	{
		for (int i = 1; i <= 13; i++) //for all of the ranks
		{
			for (int j = 1; j <= 4; j++) //create a suit for each rank
			{
				Card card = new Card(j,i); //Creates a card
				addCard(card); //adds the card to the deck
			}
		}
	}
	
	/*
		Shuffles the cards
	*/
	public void shuffle()
	{
		Random rand = new Random();
		ArrayList<Card> tempDeck = new ArrayList<Card>();
		
		while (getSize() > 0) //while there are still cards in the main deck
		{
			tempDeck.add(getCard(rand.nextInt(getSize()))); //remove a random card from the deck and add it to a temporary
																				 //array until the main deck is empty
		}
		while (tempDeck.size() > 0) //while there are still cards to be removed from the temporary deck
		{
			addCard(tempDeck.remove(0)); //remove the cards from the temporary deck and add them to main deck																			 
		}
	}
		
	/*
		returns the deck
		@return the deck
	*/
	public ArrayList<Card> getDeck() //returns the deck
	{
		return getPile();
	}
}