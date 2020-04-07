package bakersDozen;

public class Card {
	/*
	 * Just a Card class that defines the suit & rank of a card
	 * Going to be added into Deck class for further uses
	 * @author Yuanyi Yang
	 */
	private Suits suit;
	private Ranks rank;
	//used to connect the card class with a card gui
	private String imageName;
	
	public Card(Suits s, Ranks r){
		this.suit = s;
		this.rank = r;
		String rank = null;
		String suit = null;
		
		if(r==Ranks.Ace){
			rank = "a";
		}else if(r==Ranks.Two){
			rank = "2";
		}else if(r==Ranks.Three){
			rank = "3";
		}else if(r==Ranks.Four){
			rank = "4";
		}else if(r==Ranks.Five){
			rank = "5";
		}else if(r==Ranks.Six){
			rank = "6";
		}else if(r==Ranks.Seven){
			rank = "7";
		}else if(r==Ranks.Eight){
			rank = "8";
		}else if(r==Ranks.Nine){
			rank = "9";
		}else if(r==Ranks.Ten){
			rank = "10";
		}else if(r==Ranks.Jack){
			rank = "j";
		}else if(r==Ranks.Queen){
			rank = "q";
		}else if(r==Ranks.King){
			rank = "k";
		}
		
		if(s==Suits.Clubs){
			suit = "c";
		}else if(s==Suits.Diamonds){
			suit = "d";
		}else if(s==Suits.Hearts){
			suit = "h";
		}else if(s==Suits.Spades){
			suit = "s";
		}
		
		imageName = rank+suit;
		
	}
	
	public Ranks getRank(){
		return this.rank;
	}
	
	public Suits getSuit(){
		return this.suit;
	}
	
	public String getCardInfo(){
		return this.suit.toString()+this.rank.toString();
	}
	
	public String getImageName(){
		
		return this.imageName;
	}


}