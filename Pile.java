import java.util.ArrayList;

/**
   David Newman
   CS 110
   this class represents any collection of cards
*/
public class Pile //this class represents any collection of cards
{
	ArrayList<Card> cardPile;
   
	/**
      constructor instantiates the array
   */
	public Pile()
	{	
		cardPile = new ArrayList<Card>();
	}
	
   /**
      adds a card to the END of the pile
      @param a card to be added
   */
	public void addCard(Card c) //adds a card to the END of the pile
	{
		cardPile.add(c);
	}
	  
   /**
      removes a card from the pile and returns it
      @param the position of the card in the array
      @return the card
   */
	public Card getCard(int position)
   {
		return cardPile.remove(position);
	}
	
   /**
      gets the size of the array
      @return the number of cards in the pile
   */
	public int getSize() //returns the number of cards in the pile
	{
		return cardPile.size();
	}
	
   /**
      returns the pile
      @return the pile of cards
   */
	public ArrayList<Card> getPile() //returns the deck of cards
	{
		return cardPile;
	}
	
   /**
      Determines whether there are cards left in the pile
      @return whether or not there are cards
   */
	public boolean isEmpty()
	{
		if (cardPile.size() == 0)
			return true;
		else
			return false;
	}
}