package bakersDozen;


import java.util.ArrayList;

public class BakersDozen{
	/*
	 * @author Yuanyi Yang
	 */
	
	private ArrayList<Deck> tableauPiles = new ArrayList<Deck>();
	private ArrayList<Deck> homecellPiles = new ArrayList<Deck>();
	Deck one= new Deck();
	Deck two= new Deck();
	Deck three=new Deck();
	Deck four= new Deck();
	
	


	
	public ArrayList<Deck> getTableauPiles(){
		return this.tableauPiles;
	}
	
	public ArrayList<Deck> getHomecellPiles(){
		return this.homecellPiles;
	}
	
	
	
	public BakersDozen(){
		
		
		
		
		Deck deck = new Deck();
		for(int i=0; i<13; i++){
			Deck tableau = new Deck();
			tableau.clear();
			for(int o=0; o<4; o++){
				tableau.add((deck.get(0)));
				deck.remove(0);
			}
			//next is to move every King card to the bottom of the pile
			for(int p=0; p<tableau.size(); p++){
				if(tableau.get(p).getRank().toString().equals("King")){
					tableau.moveToBottom(tableau.get(p));
				}
			}
			tableauPiles.add(tableau);
		}
		
		
		System.out.println(homecellPiles.size()+"$$$$");
		
		homecellPiles.add(one);
		homecellPiles.add(two);
		homecellPiles.add(three);
		homecellPiles.add(four);
	 homecellPiles.get(0).clear();
	 homecellPiles.get(1).clear();
	 homecellPiles.get(2).clear();
	 homecellPiles.get(3).clear();
		
	
	//homecellPiles.get(0).add(this.tableauPiles.get(0).get(0));
		
		
		
		
		
	}
	
	public boolean removeTableau(int num){
		if(num<=13){
			if(this.tableauPiles.get(num).isEmpty()){
				return false;
			}else{
				this.tableauPiles.get(num).remove(this.tableauPiles.get(num).size()-1);
				return true;
			}
		}else{
			return false;
		}
		
	}
	
	public boolean addTableau(int num, Card c){
		Card temp;
		int size;
		if(num<=13){
			if(this.tableauPiles.get(num).isEmpty()==false){
				size = this.tableauPiles.get(num).size();
				temp = this.tableauPiles.get(num).get(size-1);
				if(c.getRank().compareTo(temp.getRank())==-1){
					this.tableauPiles.get(num).add(c);
					return true;
				}
			}else if(this.tableauPiles.get(num).isEmpty()){
				return false;
			}
		}else if(num>13){
			return false;
		}
		return false;
	}
	
	public boolean removeHomecell(){
		return false;
	}
	
	
	public boolean addHomecell(int num, Card c){
		if(num<=3){
			if(homecellPiles.get(num).isEmpty()){
				if(c.getRank().toString().equals("Ace")){
					homecellPiles.get(num).add(c);
					
					
					
					
					
					return true;
				}
			}else if(this.homecellPiles.get(num).isEmpty()==false){
				Card temp = this.homecellPiles.get(num).get(this.homecellPiles.get(num).size()-1);
				if(c.getSuit().compareTo(temp.getSuit())==0){
					if(c.getRank().compareTo(temp.getRank())==1){
						this.homecellPiles.get(num).add(c);
						return true;
					}
				}
			}
		}else if(num>3){
			return false;
		}
		return false;
	}


	public int removeCard(Card yoyo, int num) {
		for (int i = 0; i < tableauPiles.size(); i++) {
			int green = tableauPiles.get(i).size() - 1;
			if (tableauPiles.get(i).get(green).getCardInfo().equals(yoyo.getCardInfo()) &&i!=num) {
				tableauPiles.get(i).remove(green);
				return i;

			}
		}
		return 0;
	}
	
	public  String grabtableau(int number) {
		if(tableauPiles.get(number).isEmpty()) {
			return "";
		}
		int blue = tableauPiles.get(number).size()-1;
		return tableauPiles.get(number).get(blue).getCardInfo();
		
	}
	public  String grabhomecell(int number) {
		if(getHomecellPiles().get(number).isEmpty()) {
			return "";
		}
		int blue = homecellPiles.get(number).size()-1;
		return homecellPiles.get(number).get(blue).getCardInfo();
		
	}


}
