import java.util.ArrayList;

/**
   David Newman
   CS 110
   This class contains all of the methods needed for playing a game of war
*/
public class WarGame2
{
	WarHand compHand;   //for holding the hands
	WarHand playerHand;
	
	Card playerCard; //for holding the resulting card from each play
	Card compCard;
	
	boolean inWar; //for determining whether the game is in 'warmode' or not
	
	boolean empty; //for holding result of player or computer having empty hand
	String result; //for result of each play
	
	ArrayList<Card> compWarCards; //for storing the cards during the war
	ArrayList<Card> playerWarCards;
	
	String warWinner; //for holding the result of the war
	
//Card playerWarCard;
//Card compWarCard;
	
	Card playerWarInitiator;
	Card compWarInitiator;

	/**
		Constructor instantiates the objects
	*/
	public WarGame2()
	{
		compHand = new WarHand();
		playerHand = new WarHand();
		
		inWar = false;
		
		compWarCards = new ArrayList<Card>(); //for holding built up cards during war
		playerWarCards = new ArrayList<Card>();
		
	}
	
	/**
		removes and returns a card from the BEGINNING (top) of computer's hand
		@return the card
	*/
	public Card playCompCard()
	{
		return compHand.getCard(0); 
	}
	
	/**
		removes and returns a card from the BEGINNING (top) of player's hand
		@return the card
	*/
	public Card playPlayerCard()
	{
		return playerHand.getCard(0); 
	}
	
	/**
		determines whether a war will occur
		@return whether or not a war will occur
	*/
	public boolean warCheck(Card playerCard, Card compCard)
	{
		if (playerCard.getRank() == compCard.getRank()) //if the ranks of the cards are equal
			return true;
		else //if they aren't equal
			return false;
	}
	
	/**
		plays the hand, when there is NOT a war
		@return the result of the play
	*/
	public String play(Card playerCard, Card compCard) //only used when the ranks are not equal!
	{
		empty = false;
			
			if (compCard.getRank() > playerCard.getRank()) //if computer's card is higher
			{
				compHand.addCard(playerCard); //load both the cards onto the END (bottom) of the computer's hand
				compHand.addCard(compCard);
				result = "computergetscards";
				
				if (playerHand.getSize() == 0) //if the player's hand is now empty as a result of the match
					result = "playerlost";
			}
			
			else if (playerCard.getRank() > compCard.getRank()) //if player's card is higher
			{
				playerHand.addCard(playerCard); //add both cards to END (bottom) of player's hand
				playerHand.addCard(compCard);
				result = "playergetscards";
				
				if (compHand.getSize() == 0) //if the computer's hand is now empty as a result of the match
					result = "computerlost";
			}
			
			else
				result = "PROGRAM ERROR"; //this should never happen since this method is only called when the ranks are not equal
			
			return result;
	}

	/**
		for adding cards to computer hand
		@param a computer card
	*/
	public void addCompCard(Card compCard) 
	{
		compHand.addCard(compCard);
	}

	/**
		for adding cards to player hand
		@param a player card
	*/
	public void addPlayerCard(Card playerCard) 
	{
		playerHand.addCard(playerCard);
	}
	
	/**
		returns size of player hand
		@return the size of player's hand
	*/
	public int getPlayerHandSize() 
	{
		return playerHand.getSize();
	}
	
	/**
		returns size of computer hand
		@return the size of computer's hand
	*/
	public int getCompHandSize()
	{
		return compHand.getSize();
	}
	
	/**
		stores the player's card that initiated the most recent war
	*/
	public void setPlayerWarInitiator() //
	{
		playerWarInitiator = playerWarCards.get(playerWarCards.size() - 1); 
	}
	
	/**
		stores the computer's card that initiated the most recent war
	*/
	public void setCompWarInitiator() 
	{
		compWarInitiator = compWarCards.get(compWarCards.size() - 1);
	}
	
	/**
		sets the player's card that initiated the most recent war
		@param a player card
	*/
	public void setPlayerWarInitiator(Card playerWarInitiatorCard) 
	{
		playerWarInitiator = playerWarInitiatorCard;
	}
	
	/**
		sets the computer's card that initiated the most recent war
		@param a computer card
	*/
	public void setCompWarInitiator(Card compWarInitiatorCard)
	{
		compWarInitiator = compWarInitiatorCard;
	}
	
	/**
		return the last card in the player's war array
		@return the last card in the player's war array
	*/
	public Card getPlayerWarInitiator() //
	{
		return playerWarInitiator; 
	}
	
	/**
		return the last card in the computer's war array
		@return the last card in the computer's war array
	*/
	public Card getCompWarInitiator()
	{
		return compWarInitiator;  
	}
	
	/**
		adds a player's card to the array holding the cards during war
		@param a player's card
	*/
	public void addCardPlayerWarHand(Card playerCard) 
   {
		playerWarCards.add(playerCard);
	}
	
	/**
		adds a computer's card to the array holding the cards during war
		@param a computer's card
	*/
	public void addCardCompWarHand(Card compCard) 
	{
		compWarCards.add(compCard);
	}
	
	/**
		simulates a war
		@return the result of the war
	*/
	public String war()
	{	
		if (getCompHandSize() >= 2 && getPlayerHandSize() >= 2) //if both hands have at least 2 cards
		{
			for (int i = 0; i < 2; i++) //repeat this procedure twice
			{	
				//System.out.println("Player Hand Size: " + getPlayerHandSize()); //displays hand sizes before war
				//System.out.println("Computer Hand Size: " + getCompHandSize());
				
				compWarCards.add(playCompCard()); //adds a comp card to the compWarCards array
				playerWarCards.add(playPlayerCard()); //adds a player card to playerWarCards array
				
				//System.out.println("compWarCardsArray size: " + compWarCards.size()); //for first war, should be 2 for both
				//System.out.println("playerWarCardsArray size: " + playerWarCards.size());
	
			}
			
			setPlayerWarInitiator(); //gets copy of the reference to the last variable in the array and stores it in a new card
			setCompWarInitiator();
					
			//System.out.println("\ncompWarCardsArray size: " + compWarCards.size()); //should be same as above
			//System.out.println("playerWarCardsArray size: " + playerWarCards.size());
			
			if (compWarInitiator.getRank() > playerWarInitiator.getRank())
			{						
				warWinner = "computer";
				
				while (!playerWarCards.isEmpty()) //while there are still cards to remove from the player's temporary array
				{
					addCompCard(playerWarCards.remove(0)); //remove the cards from both arrays and add the cards
					addCompCard(compWarCards.remove(0));   //to the computer's hand
				}
				//System.out.println(compWarCards.size() + playerWarCards.size());
			}
			
			else if (compWarInitiator.getRank() < playerWarInitiator.getRank())
			{
				warWinner = "player";
				
				while (!playerWarCards.isEmpty()) //while there are still cards to remove from the player's temporary array
				{
					addPlayerCard(playerWarCards.remove(0)); //remove the cards from both arrays and add the cards
					addPlayerCard(compWarCards.remove(0));   //to the computer's hand
				}
					//System.out.println(compWarCards.size() + playerWarCards.size());
	
			}
			
			else
				warWinner = "tie";
				
				//setCompWarInitiator(getLastCompWarCard());  //set those cards to be the initiators of the war next war (for GUI display purposes)
				//setPlayerWarInitiator(getLastPlayerWarCard());
		}
		
		else //if one of the hands doesn't have 2 cards
		{
			if (getCompHandSize() < 2)
				warWinner = "computerloses";
			else
				warWinner = "playerloses";
		}
			
			
		return warWinner;
		
	}
}
