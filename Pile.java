import java.util.ArrayList;
public class Pile //this class represents any collection of cards
{
	ArrayList<Card> cardPile;
	
	public Pile()
	{	
		cardPile = new ArrayList<Card>();
	}
	
	public void addCard(Card c) //adds a card to the END of the pile
	{
		cardPile.add(c);
	}
	
	public Card getCard(int position) //removes a card from the pile and returns it
	{
		return cardPile.remove(position);
	}
	
	public int getSize() //returns the number of cards in the pile
	{
		return cardPile.size();
	}
	
	public ArrayList<Card> getPile() //returns the deck of cards
	{
		return cardPile;
	}
	
	public boolean isEmpty()
	{
		if (cardPile.size() == 0)
			return true;
		else
			return false;
	}
}