import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;
//import java.lang.Thread;



public class GUI3 extends JFrame
{
	JLabel left; //holds images of war initiator cards during battle
	JLabel right;
	
	JLabel leftLabel;
	JLabel rightLabel;
	
	
	ImageIcon end;
	
	ImageIcon pIc; //for holding image icons
	ImageIcon cIc;
	ImageIcon playerIcon;
	ImageIcon compIcon;
	GUI3 thisFrame;
	Card pCard; //for holding temporary cards pulled from hand
	Card cCard;
	ImageIcon blank;
	
	Card playerCheck; //for holding last war card that determines war outcome
	Card compCheck;
	
	JLabel compCard; //The images that will show the cards in the playing field
	JLabel playerCard;
	
	JLabel display; //the label that will display the current game info 
	
	WarGame2 game; //for the GAME
	
	JButton play; //the play button
	
	ArrayList<Card> compWarCards;   //for holding cards during war
	ArrayList<Card> playerWarCards; 
	
	String warWinner; //holds the winner of each war 
	
	boolean war; //for determining whether or not a war is occurring
	
	boolean gameOver; //tells whether the game is over
	
	ImageIcon warCard;
	
	/*
		Creates the frame for the game
	*/
	public GUI3()
	{	
		setBackground(Color.BLUE);



		
		end = new ImageIcon("theend.jpg");
		
		blank = new ImageIcon("blankpic.jpg");
		
		game = new WarGame2(); //fires up a game of war
		war = false; //initializes the war variable
		compWarCards = new ArrayList<Card>();
		playerWarCards = new ArrayList<Card>();
		
		gameOver = false;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,800);
		setLayout(new BorderLayout());

		////Setting left side////
		ImageIcon cardBack = new ImageIcon("back.jpg");
		
		JLabel cardBackLabel = new JLabel(cardBack); //creates a label with the back of the card image
		JLabel comp = new JLabel("COMPUTER'S HAND"); //defines computer label
		comp.setFont(new Font("Serif", Font.BOLD, 20));

		comp.setBackground(Color.blue);
		JLabel blank = new JLabel("");
		
		JPanel compLabels = new JPanel(); //creates a new panel to hold those labels
		compLabels.setSize(150,400); //sets the size of that panel
		compLabels.setLayout(new GridLayout(3,1)); //defines the layout of that new panel (a 2x1 matrix of labels

		compLabels.add(comp); //adds to position 1,1 in panel
		compLabels.add(cardBackLabel); //adds to position 2,1 in panel
		compLabels.add(blank); //adds a blank label to position 3,1 in panel

		add(compLabels, BorderLayout.WEST); //adds the panel to the frame
		
		
		////Setting right side/////
		JLabel player = new JLabel("PLAYER'S HAND");
		player.setFont(new Font("Serif", Font.BOLD, 20));
		
		JLabel cardBackLabel2 = new JLabel(cardBack);
		play = new JButton("Flip a Card");
		play.setFont(new Font("Serif", Font.BOLD, 20));
		play.setBackground(Color.green);
		play.addActionListener(new ButtonListener()); //NEED TO WRITE A CLASS FOR THIS ONE


		
		JPanel playerLabels = new JPanel();
		playerLabels.setSize(150,500);
		playerLabels.setLayout(new GridLayout(3,1));
		
		playerLabels.add(player);
		playerLabels.add(cardBackLabel2);
		playerLabels.add(play);
		
		add(playerLabels, BorderLayout.EAST);
		
		//////Setting the north block/////-->>THIS NEEDS TO BE FIXED. HOW CAN I CENTER A LABEL WITHIN A REGION OF A BORDERLAYOUT?
		JLabel titleText = new JLabel("GAME OF WAR!");
		titleText.setFont(new Font("Serif", Font.BOLD, 25));

		titleText.setHorizontalAlignment(SwingConstants.CENTER); //centers the label
		
		add(titleText, BorderLayout.NORTH); //adds the label to the frame
		
		/////Setting the center block//////
		ImageIcon card = new ImageIcon("blankpic.jpg");
		compCard = new JLabel(card);
		playerCard = new JLabel(card);
		
		JPanel center = new JPanel(); //creates a new panel to hold the played cards
		center.setLayout(new GridLayout(3,2)); //1x2 matrix
		
		center.add(compCard); //adds the computer's blank card to the display (left)
		center.add(playerCard); //adds the player's blank card to the display (right)
		
		left = new JLabel(card);
		right = new JLabel(card);
		center.add(left); //adds the computer's blank card to the display (left)
		center.add(right); //adds the player's blank card to the display (right)
		
		leftLabel = new JLabel("      Computer War Card");
		rightLabel = new JLabel("      Player War Card");
		leftLabel.setVerticalAlignment(SwingConstants.TOP);
		rightLabel.setVerticalAlignment(SwingConstants.TOP);


		leftLabel.setFont(new Font("Serif", Font.BOLD, 20));
		rightLabel.setFont(new Font("Serif", Font.BOLD, 20));
		center.add(leftLabel);
		center.add(rightLabel);
		
		add(center, BorderLayout.CENTER); //adds the panel to the frame
		
		/////Setting the southern block//////
		display = new JLabel("GET READY FOR WAR"); //creates a label to display what is happening in game
		display.setHorizontalAlignment(SwingConstants.CENTER); //centers the label
		display.setFont(new Font("Serif", Font.BOLD, 40));

		add(display, BorderLayout.SOUTH); //adds the label to the frame
		
		setVisible(true); //makes the frame visible
	}
	/*
		ButtonListener executes the button action
	*/
	private class ButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)  
		{	
				play.setEnabled(false);
				display.setForeground(Color.BLACK);

				pCard = game.playCompCard(); //these are the cards that are being used for this play
				cCard = game.playPlayerCard();
				
				war = game.warCheck(pCard, cCard); //checks to see if there's going to be war
				
				if (!war) //if there isn't a war
				{
					left.setIcon(blank);
					right.setIcon(blank);
					String result = game.play(pCard, cCard); //gets the result of the game
					
					String pCardFileName = pCard.cardToPicName(); //gets the name file name of the card picture corresponding to the
					String cCardFileName = cCard.cardToPicName(); //card that was played
					
					playerIcon = new ImageIcon(pCardFileName); //creates an image icon with that filename
					playerCard.setIcon(playerIcon); //updates the 'playerCard' JLabel with the new icon
					
					compIcon = new ImageIcon(cCardFileName); //creates an image with that file name
					compCard.setIcon(compIcon); //updates the 'compCard' JLabel with the new icon
					
					if (result.equals("computerlost"))
					{
						compCard.setIcon(end);
						playerCard.setIcon(end);

						display.setForeground(Color.RED);

						display.setText("COMPUTER LOSES!");
						gameOver = true;
					}
					
					else if (result.equals("playerlost"))
					{
						compCard.setIcon(end);
						playerCard.setIcon(end);
						
						display.setForeground(Color.RED);

						display.setText("YOU LOSE!");
						gameOver = true;
					}
					
					else if (result.equals("computergetscards"))
						display.setText("Computer wins this play");
					else if (result.equals("playergetscards"))
						display.setText("Player wins this play");
					else 
						display.setText("PROGRAM ERROR!");
					
					System.out.println("Player hand size: " + game.getPlayerHandSize());
					System.out.println("Computer hand size: " + game.getCompHandSize());
	
				}
				
			
				else //there must be a war - you get to this loop if there wasn't a war before the play but now there is as a result of play
				{	
					game.addCardPlayerWarHand(pCard); //adds the initial card to player's war array in game class
					game.addCardCompWarHand(cCard);	//adds the initial card to comp's war array in game class
					
					game.setPlayerWarInitiator(pCard); //sets the card that started the war
					game.setCompWarInitiator(cCard);
					
					while(war) //while there is a war going on
					{
						
						pIc = new ImageIcon(game.getPlayerWarInitiator().cardToPicName()); //uses the card that started the war to update the picture
						left.setIcon(pIc);
						cIc = new ImageIcon(game.getCompWarInitiator().cardToPicName());
						right.setIcon(cIc);
						display.setText("WAR STARTED");

						warCard = new ImageIcon("back.jpg"); //creates a new imageicon with the back of the card
						compCard.setIcon(warCard); //then sets the playing field to display facedown cards
						playerCard.setIcon(warCard);


						display.setText("Engaged in a war!");
						System.out.println("WWWAAARRR sleep");
												
						warWinner = game.war(); //gets the result of the war and updates the compWarInitiator and playerWarInitiator variables of the WarGame class

						playerCheck = game.getPlayerWarInitiator(); //gets the card that determines the result of the war ---\/
						compCheck = game.getCompWarInitiator();//					\/-------<---<-------<-----<-----------------<--|														
																			//					 |
						pIc = new ImageIcon(playerCheck.cardToPicName()); //   |__> and uses that last card in each array to update the picture
						playerCard.setIcon(pIc);
						cIc = new ImageIcon(compCheck.cardToPicName());
						compCard.setIcon(cIc);
						
						if (warWinner.equals("computer")) //if computer won
						{
							display.setForeground(Color.RED);

							display.setText("WAR OCCURRED - COMPUTER WON");
							war = false;
						}
						
						else if (warWinner.equals("player")) //if player won
						{
							display.setForeground(Color.RED);
							display.setText("WAR OCCURRED - PLAYER WON");
							war = false;
						}
						
						else if (warWinner.equals("playerloses"))
						{
							display.setForeground(Color.RED);
							display.setText("YOU LOSE!");
							war = false;
							gameOver = true;
							compCard.setIcon(end);
							playerCard.setIcon(end);
						}
						
						else if (warWinner.equals("computerloses"))
						{
							display.setForeground(Color.RED);
							war = false;
							gameOver = true;
							compCard.setIcon(end);
							playerCard.setIcon(end);
						}
						
						else
						{
							display.setForeground(Color.RED);
							war = true;
							display.setText("ANOTHER WAR!");
						}
						
							

						
					} //closing bracket for the while loop
					System.out.println("Player hand size: " + game.getPlayerHandSize());
					System.out.println("Computer hand size: " + game.getCompHandSize());

				}//closing bracket for else (there must be a war) block
			if (gameOver) //if the game is over
			{    	//Do nothing with regards to the button. It should be deactivated from the beginning of the eventlistener method
				left.setIcon(end);
				right.setIcon(end);
			}
			else
				play.setEnabled(true); //otherwise re-enable the button so it can be used for further plays
				
		}		
	}
	
	public void sleep(int delayTime)
	{
		long t1 = System.currentTimeMillis();
		long t2 = System.currentTimeMillis();
		
		while ((t2 - t1) < delayTime)
			t2 = System.currentTimeMillis();
	}
	
	public static void main(String[] args)
	{
		new GUI3();
		System.out.println(JFrame.EXIT_ON_CLOSE);
	}
}