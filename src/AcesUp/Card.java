package AcesUp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuanyi Yang
 *
 * yuanyiya@buffalo.edu
 */

public class Card implements Comparable<Card> {

	private Rank rank;
	private Suit suit;
	private int compare;

	public Card(String rank, String suit) {

		this.suit = new Suit(suit);
		this.rank = new Rank(rank);

		if (this.rank.rankName.equals("2")) {
			compare = 2;
		} else if (this.rank.rankName.equals("3")) {
			compare = 3;
		} else if (this.rank.rankName.equals("4")) {
			compare = 4;
		} else if (this.rank.rankName.equals("5")) {
			compare = 5;
		} else if (this.rank.rankName.equals("6")) {
			compare = 6;
		} else if (this.rank.rankName.equals("7")) {
			compare = 7;
		} else if (this.rank.rankName.equals("8")) {
			compare = 8;
		} else if (this.rank.rankName.equals("9")) {
			compare = 9;
		} else if (this.rank.rankName.equals("10")) {
			compare = 10;
		} else if (this.rank.rankName.equals("j")) {
			compare = 11;
		} else if (this.rank.rankName.equals("q")) {
			compare = 12;
		} else if (this.rank.rankName.equals("k")) {
			compare = 13;
		} else if (this.rank.rankName.equals("a")) {
			compare = 14;
		}

	}
	
	public String getRank(){
		return rank.rankName;
	}
	
	public String getSuit(){
		return suit.suitName;
	}

	@Override
	public int compareTo(Card o) {
		if (compare > o.compare) {
			return 1;
		} else if (compare < o.compare) {
			return -1;
		} else {
			return 0;
		}

	}

	public boolean sameSuit(Card o) {
		if (suit.suitName.equals(o.suit.suitName)) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return rank.rankName + suit.suitName;
	}

	private class Suit {
		protected String suitName;

		protected Suit(String name) {
			List<String> nameList = new ArrayList<String>();
			nameList.add("s");
			nameList.add("d");
			nameList.add("h");
			nameList.add("c");

			if (nameList.contains(name)) {
				suitName = name;
			} else {
				throw new IllegalArgumentException();
			}
		}
	}

	private class Rank {
		protected String rankName;

		protected Rank(String name) {
			List<String> nameList = new ArrayList<String>();
			nameList.add("2");
			nameList.add("3");
			nameList.add("4");
			nameList.add("5");
			nameList.add("6");
			nameList.add("7");
			nameList.add("8");
			nameList.add("9");
			nameList.add("10");
			nameList.add("j");
			nameList.add("q");
			nameList.add("k");
			nameList.add("a");

			if (nameList.contains(name)) {
				rankName = name;
			} else {
				throw new IllegalArgumentException();
			}
		}
	}

}
