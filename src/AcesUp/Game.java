package AcesUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @author Yuanyi Yang
 *
 *         yuanyiya@buffalo.edu
 */

public class Game {

	private Stack<Card> stockPile;
	private Stack<Card> homecellPile;
	private Stack<Card> tableauPile0;
	private Stack<Card> tableauPile1;
	private Stack<Card> tableauPile2;
	private Stack<Card> tableauPile3;
	private ArrayList<Stack<Card>> tableauPiles;
	private ArrayList<Card> topTableaus;

	public Game() {
		stockPile = new Stack<Card>();
		homecellPile = new Stack<Card>();
		tableauPile0 = new Stack<Card>();
		tableauPile1 = new Stack<Card>();
		tableauPile2 = new Stack<Card>();
		tableauPile3 = new Stack<Card>();
		tableauPiles = new ArrayList<Stack<Card>>();

		stockPile.push(new Card("2", "s"));
		stockPile.push(new Card("3", "s"));
		stockPile.push(new Card("4", "s"));
		stockPile.push(new Card("5", "s"));
		stockPile.push(new Card("6", "s"));
		stockPile.push(new Card("7", "s"));
		stockPile.push(new Card("8", "s"));
		stockPile.push(new Card("9", "s"));
		stockPile.push(new Card("10", "s"));
		stockPile.push(new Card("j", "s"));
		stockPile.push(new Card("q", "s"));
		stockPile.push(new Card("k", "s"));
		stockPile.push(new Card("a", "s"));
		stockPile.push(new Card("2", "d"));
		stockPile.push(new Card("3", "d"));
		stockPile.push(new Card("4", "d"));
		stockPile.push(new Card("5", "d"));
		stockPile.push(new Card("6", "d"));
		stockPile.push(new Card("7", "d"));
		stockPile.push(new Card("8", "d"));
		stockPile.push(new Card("9", "d"));
		stockPile.push(new Card("10", "d"));
		stockPile.push(new Card("j", "d"));
		stockPile.push(new Card("q", "d"));
		stockPile.push(new Card("k", "d"));
		stockPile.push(new Card("a", "d"));
		stockPile.push(new Card("2", "h"));
		stockPile.push(new Card("3", "h"));
		stockPile.push(new Card("4", "h"));
		stockPile.push(new Card("5", "h"));
		stockPile.push(new Card("6", "h"));
		stockPile.push(new Card("7", "h"));
		stockPile.push(new Card("8", "h"));
		stockPile.push(new Card("9", "h"));
		stockPile.push(new Card("10", "h"));
		stockPile.push(new Card("j", "h"));
		stockPile.push(new Card("q", "h"));
		stockPile.push(new Card("k", "h"));
		stockPile.push(new Card("a", "h"));
		stockPile.push(new Card("2", "c"));
		stockPile.push(new Card("3", "c"));
		stockPile.push(new Card("4", "c"));
		stockPile.push(new Card("5", "c"));
		stockPile.push(new Card("6", "c"));
		stockPile.push(new Card("7", "c"));
		stockPile.push(new Card("8", "c"));
		stockPile.push(new Card("9", "c"));
		stockPile.push(new Card("10", "c"));
		stockPile.push(new Card("j", "c"));
		stockPile.push(new Card("q", "c"));
		stockPile.push(new Card("k", "c"));
		stockPile.push(new Card("a", "c"));
		Collections.shuffle(stockPile);

		tableauPiles.add(tableauPile0);
		tableauPiles.add(tableauPile1);
		tableauPiles.add(tableauPile2);
		tableauPiles.add(tableauPile3);

		moveStock();
		updateTopCards();

	}

	public ArrayList<Stack<Card>> getTableauPiles() {
		return tableauPiles;
	}

	protected void setTableauPile0(Stack<Card> s) {
		tableauPile0 = s;
	}

	protected void setTableauPile1(Stack<Card> s) {
		tableauPile1 = s;
	}

	protected void setTableauPile2(Stack<Card> s) {
		tableauPile2 = s;
	}

	protected void setTableauPile3(Stack<Card> s) {
		tableauPile3 = s;
	}

	public Stack<Card> getHomecellPile() {
		return homecellPile;
	}

	protected void setHomecellPile(Stack<Card> s) {
		homecellPile = s;
	}

	public Stack<Card> getStockPile() {
		return stockPile;
	}

	protected void setStockPile(Stack<Card> s) {
		stockPile = s;
	}

	public ArrayList<Card> getTopTableaus() {
		return topTableaus;
	}

	protected void setTopTableaus(ArrayList<Card> ac) {
		topTableaus = ac;
	}

	public void updateTopCards() {
		topTableaus = new ArrayList<Card>();
		if (!tableauPile0.isEmpty()) {
			topTableaus.add(tableauPile0.peek());
		}
		if (!tableauPile1.isEmpty()) {
			topTableaus.add(tableauPile1.peek());
		}
		if (!tableauPile2.isEmpty()) {
			topTableaus.add(tableauPile2.peek());
		}
		if (!tableauPile3.isEmpty()) {
			topTableaus.add(tableauPile3.peek());
		}
	}

	public boolean moveStock() {
		if (!stockPile.isEmpty()) {
			tableauPile0.push(stockPile.pop());
			tableauPile1.push(stockPile.pop());
			tableauPile2.push(stockPile.pop());
			tableauPile3.push(stockPile.pop());
			updateTopCards();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addStock(){
		return false;
	}

	public boolean moveTableauToTableau(int from, int to) {
		if (from >= 4 || to >= 4) {
			throw new NullPointerException();
		} else {
			if (tableauPiles.get(to).isEmpty()) {
				tableauPiles.get(to).push(tableauPiles.get(from).pop());
				updateTopCards();
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean moveTableauToHomecell(int from) {
		if (from >= 4) {
			throw new NullPointerException();
		} else {
			topTableaus.remove(tableauPiles.get(from).peek());
			if (topTableaus.isEmpty()) {
				homecellPile.push(tableauPiles.get(from).pop());
				updateTopCards();
				return true;
			} else {
				int counter = 0;
				for (int i = 0; i < topTableaus.size(); i++) {
					if (tableauPiles.get(from).peek().sameSuit(topTableaus.get(i))) {
						if (tableauPiles.get(from).peek().compareTo(topTableaus.get(i)) < 0) {
							counter += 1;

						}
					}
				}
				if (counter > 0) {
					homecellPile.push(tableauPiles.get(from).pop());
					updateTopCards();
					return true;
				} else {
					updateTopCards();
					return false;
				}
			}
		}
	}

}
