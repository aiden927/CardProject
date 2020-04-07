package bakersDozen;

import java.util.ArrayList;
import java.util.Collections;

public class Deck{
	/*
	 * I made the instance type ArrayList because it's going to shuffle & add/remove easier
	 * The default size of a deck is going to be 52 cards
	 * @author Yuanyi Yang
	 */
	
	private ArrayList<Card> deck;
	
	public Deck(){
		this.deck = new ArrayList<Card>();
		//loop through all suits and ranks & will eventually create a deck of 52 different cards
		for(Suits s: Suits.values()){
			for(Ranks r: Ranks.values()){
				Card c = new Card(s,r);
				this.deck.add(c);
			}
		}
		//randomize cards in deck
		Collections.shuffle(this.deck);
	}
	
	public int size(){
		return this.deck.size();
	}
	
	public boolean isEmpty(){
		return this.deck.isEmpty();
	}
	
	public void add(Card c){
		this.deck.add(c);
	}
	
	public void remove(int i){
		this.deck.remove(i);
	}
	
	public Card get(int i){
		return this.deck.get(i);
	}
	
	public void clear(){
		this.deck.clear();
	}
	
	public boolean contains(Card c){
		return this.deck.contains(c);
	}
	
	public Card draw(){
		Card d = this.deck.get(0);
		this.deck.remove(0);
		return d;
	}
	
	//in case that a deck of a different size is needed
	public void setSize(int s){
		ArrayList<Card> newDeck = new ArrayList<Card>(s);
		for(int i=0; i<s; i++){
			newDeck.add(this.deck.get(i));
		}
		this.deck = newDeck;
	}
	
	public boolean containsRank(String r){
		for(int i=0; i<this.deck.size(); i++){
			if(this.deck.get(i).getRank().toString()==r){
				return true;
			}
		}
		return false;
	}
	
	public boolean containsSuit(String s){
		for(int i=0; i<this.deck.size(); i++){
			if(this.deck.get(i).getSuit().toString()==s){
				return true;
			}
		}
		return false;
	}
	
	public boolean moveToBottom(Card c){
		Card temp = null;
		Card temp2 = null;
		if(this.deck.contains(c)){
			for(int i=0; i<this.deck.size(); i++){
				if(this.deck.get(i)==c){
					temp = this.deck.get(i);
					this.deck.remove(i);
				}
			}
			for(int i=0; i<this.deck.size(); i++){
				temp2 = this.deck.get(i);
				this.deck.set(i, temp);
				temp = temp2;
			}
			this.deck.add(temp);
			return true;
		}else{
			return false;
		}
	}
	
	

}
