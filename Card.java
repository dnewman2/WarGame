/**
   David Newman
   CS 110
   This class makes a card and has various methods
   for returning the suit and rank of the card and 
   comparing two cards to each other
*/

public class Card
{                                                     //public means that the public thing can be accessed outside of the class
   final public static int SPADES = 1;              //static means that the methods/variable can be accessed without and instance of the class being created
   final public static int CLUBS = 2;
   final public static int HEARTS = 3;
   final public static int DIAMONDS = 4;
   final public static int JACK = 11;
   final public static int QUEEN = 12;
   final public static int KING = 13;
   final public static int ACE = 1;
   
   private int rank; //The rank
   private int suit; //The suit

	
	/**
		Assigns suit and rank
	*/
   public Card(int suit, int rank) //Constructor
   {
      this.suit = suit;
      this.rank = rank;
   }
   /**
		Returns suit
		@return the suit
	*/
   public int getSuit() //Returns the suit to the main method
   {
      return suit;
   }
   
	/**
		Returns rank
		@return the rank
	*/
   public int getRank() //Returns the rank to the main method
   {
      return rank;
   }
   
	/**
		displays rank and suit
		@return the rank and suit
	*/
   public String toString() //Displays the rank and suit of the card as a string
   {
      String suitName;
      String rankName;
      
      if (suit == SPADES)
         suitName = "spades";
      else if (suit == CLUBS)
         suitName = "clubs";
      else if (suit == HEARTS)
         suitName = "hearts";
      else
         suitName = "diamonds";

      
      if (rank == 1 || rank > 10) //If the rank is something other than a 1, 11, 12 or 13...
      {
         if (rank == ACE)
            rankName = "ace";
         else if (rank == JACK)
            rankName = "jack";
         else if (rank == QUEEN)
            rankName = "queen";
         else
            rankName = "king";
      }
      
      else
         rankName = rank + "";
         
      return ("the suit is " + suitName + " and the rank is " + rankName + "."); //Displays the suit name and the card's rank
   }
   
	/**
		compares ranks of two cards
		@param a card
		@return whether or not the cards have the same rank
	*/
   public boolean equals(Card carrd) //Compares the "equality" (in this case, the rank) of two cards
   {
      if (rank == carrd.getRank())
         return true;
      else
         return false;
   }
	
	/**
		Creates a filename for each card
		@return the filename
	*/
	public String cardToPicName() //creates a filename of the card picture for the GUI card game
	{
		String fileName;
		if (getSuit() == SPADES) //if the suit is spades
		{
			if (getRank() == 1)		//determine filename by card rank
				fileName = "aces.jpg";
			else if (getRank() == 2)
				fileName = "2s.jpg";
			else if (getRank() == 3)
				fileName = "3s.jpg";
			else if (getRank() == 4)
				fileName = "4s.jpg";
			else if (getRank() == 5)
				fileName = "5s.jpg";
			else if (getRank() == 6)
				fileName = "6s.jpg";
			else if (getRank() == 7)
				fileName = "7s.jpg";
			else if (getRank() == 8)
				fileName = "8s.jpg";
			else if (getRank() == 9)
				fileName = "9s.jpg";
			else if (getRank() == 10)
				fileName = "10s.jpg";
			else if (getRank() == 11)
				fileName = "jacks.jpg";
			else if (getRank() == 12)
				fileName = "queens.jpg";
			else
				fileName = "kings.jpg";
		}
		
		else if (getSuit() == CLUBS) //if the suit is clubs
		{
			if (getRank() == 1)		//determine filename by card rank
				fileName = "acec.jpg";
			else if (getRank() == 2)
				fileName = "2c.jpg";
			else if (getRank() == 3)
				fileName = "3c.jpg";
			else if (getRank() == 4)
				fileName = "4c.jpg";
			else if (getRank() == 5)
				fileName = "5c.jpg";
			else if (getRank() == 6)
				fileName = "6c.jpg";
			else if (getRank() == 7)
				fileName = "7c.jpg";
			else if (getRank() == 8)
				fileName = "8c.jpg";
			else if (getRank() == 9)
				fileName = "9c.jpg";
			else if (getRank() == 10)
				fileName = "10c.jpg";
			else if (getRank() == 11)
				fileName = "jackc.jpg";
			else if (getRank() == 12)
				fileName = "queenc.jpg";
			else
				fileName = "kingc.jpg";
		}
		
		else if (getSuit() == HEARTS) //if the suit is hearts
		{
			if (getRank() == 1)		//determine filename by card rank
				fileName = "aceh.jpg";
			else if (getRank() == 2)
				fileName = "2h.jpg";
			else if (getRank() == 3)
				fileName = "3h.jpg";
			else if (getRank() == 4)
				fileName = "4h.jpg";
			else if (getRank() == 5)
				fileName = "5h.jpg";
			else if (getRank() == 6)
				fileName = "6h.jpg";
			else if (getRank() == 7)
				fileName = "7h.jpg";
			else if (getRank() == 8)
				fileName = "8h.jpg";
			else if (getRank() == 9)
				fileName = "9h.jpg";
			else if (getRank() == 10)
				fileName = "10h.jpg";
			else if (getRank() == 11)
				fileName = "jackh.jpg";
			else if (getRank() == 12)
				fileName = "queenh.jpg";
			else
				fileName = "kingh.jpg";
		}
		
		else  //the suit must be diamonds
		{
			if (getRank() == 1)		//determine filename by card rank
				fileName = "aced.jpg";
			else if (getRank() == 2)
				fileName = "2d.jpg";
			else if (getRank() == 3)
				fileName = "3d.jpg";
			else if (getRank() == 4)
				fileName = "4d.jpg";
			else if (getRank() == 5)
				fileName = "5d.jpg";
			else if (getRank() == 6)
				fileName = "6d.jpg";
			else if (getRank() == 7)
				fileName = "7d.jpg";
			else if (getRank() == 8)
				fileName = "8d.jpg";
			else if (getRank() == 9)
				fileName = "9d.jpg";
			else if (getRank() == 10)
				fileName = "10d.jpg";
			else if (getRank() == 11)
				fileName = "jackd.jpg";
			else if (getRank() == 12)
				fileName = "queend.jpg";
			else
				fileName = "kingd.jpg";
		}
		return fileName;
	}
}