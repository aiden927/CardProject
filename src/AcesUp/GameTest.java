package AcesUp;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

/**
 * @author Yuanyi Yang
 *
 *         yuanyiya@buffalo.edu
 */

public class GameTest extends Game {
	Game test;

	@Test
	public void tableauPileTest() {

		test = new Game();

		// Tableau piles in Ace's Up initially hold 1 card [2 points]
		for (int i = 0; i < 4; i++) {
			assertEquals(1, test.getTableauPiles().get(i).size());
		}

		// Ace's Up tableau pile method correctly determines if adding a
		// specific card is legal or illegal.
		// To receive points, your test cannot call two separate methods (e.g.,
		// one for when the card comes from the stock pile and one for when the
		// card comes from another tableau) to perform this check. [4 points]
		// Let's create a stack containing only 4 cards that's going to
		// represent our game's stock pile
		Stack<Card> s0 = new Stack<Card>();
		s0.push(new Card("2", "s"));
		s0.push(new Card("3", "s"));
		s0.push(new Card("4", "s"));
		s0.push(new Card("5", "s"));
		test.setStockPile(s0);
		// Now testing adding tableau from stock pile
		assertTrue(test.moveStock());
		// Since the stock pile we set contained only 4 cards, it now should be
		// empty. Testing it again should return a false
		assertFalse(test.moveStock());

		// Ace's Up tableau pile method correctly determines if removing a
		// specific card is legal or illegal.
		// To receive points, your test cannot call two separate methods (e.g.,
		// one for when the card is being moved to the homecell pile and one for
		// when the card is moved to another tableau pile) to perform this
		// check. [4 points]
		// After the previous test, top cards of tableau piles should be 5s, 4s,
		// 3s, and 2s now, Let's test about 5s
		assertFalse(test.moveTableauToHomecell(0));
		// the last tableau pile should contain card 2s, the smallest but has
		// the same suit, we should be able to move it to our homecell pile
		assertTrue(test.moveTableauToHomecell(3));

		// Adding card to Ace's Up tableau pile increases its number of cards
		// and results in that card being the tableau pile's new top card [4
		// points]
		// Fortunately I do have an instance that contains current top cards,
		// which is the topTableaus that can be accessed by getTopTableaus()
		// method
		test = new Game();
		// Recording all 4 current tableau pile's size
		int curTabNum0 = test.getTableauPiles().get(0).size();
		int curTabNum1 = test.getTableauPiles().get(1).size();
		int curTabNum2 = test.getTableauPiles().get(2).size();
		int curTabNum3 = test.getTableauPiles().get(3).size();
		test.moveStock();
		// Testing new size
		assertEquals(curTabNum0 + 1, test.getTableauPiles().get(0).size());
		assertEquals(curTabNum1 + 1, test.getTableauPiles().get(1).size());
		assertEquals(curTabNum2 + 1, test.getTableauPiles().get(2).size());
		assertEquals(curTabNum3 + 1, test.getTableauPiles().get(3).size());

		// Removing card from Ace's Up tableau pile decreases its number of
		// cards and results in following card being the new top card [4 points]
		test = new Game();
		Stack<Card> s1 = new Stack<Card>();
		s1.push(new Card("2", "s"));
		s1.push(new Card("3", "s"));
		s1.push(new Card("4", "s"));
		s1.push(new Card("5", "s"));
		test.setStockPile(s1);
		test.moveStock();
		// Testing top tableau cards
		assertEquals("[5s, 4s, 3s, 2s]", test.getTopTableaus().toString());
		int curTabNum = test.getTableauPiles().get(3).size();
		// Testing decreasing tableau piles size
		test.moveTableauToHomecell(3);
		assertEquals(curTabNum - 1, test.getTableauPiles().get(3).size());

	}

	@Test
	public void homecellPileTest() {

		test = new Game();

		// Homecell pile in Ace's Up initially holds 0 cards [2 points]
		assertEquals(0, test.getHomecellPile().size());

		// Ace's Up homecell pile correctly determines if adding a specific card
		// is legal or illegal (e.g., always legal) [2 points]
		Stack<Card> s0 = new Stack<Card>();
		s0.push(new Card("2", "s"));
		s0.push(new Card("3", "s"));
		s0.push(new Card("4", "s"));
		s0.push(new Card("5", "s"));
		Stack<Card> s1 = s0;
		test.setStockPile(s0);
		test.moveStock();
		// last tableau pile contains 2s, which will be able to added into
		// homecell pile
		assertTrue(test.moveTableauToHomecell(3));

		// Ace's Up homecell pile correctly returns if removing top card is
		// legal or illegal (e.g., always illegal) [2 points]
		test.setStockPile(s1);
		test.moveStock();
		assertFalse(test.moveTableauToHomecell(0));

		// Adding card to Ace's Up homecell pile increases its number of cards
		// and results in that card being the homecell pile's new top card [2
		// points]
		Stack<Card> s2 = new Stack<Card>();
		s2.push(new Card("2", "s"));
		s2.push(new Card("3", "s"));
		s2.push(new Card("4", "s"));
		s2.push(new Card("5", "s"));
		test.setStockPile(s2);
		test.moveStock();
		int curHomNum = test.getHomecellPile().size();
		test.moveTableauToHomecell(3);
		assertEquals(curHomNum + 1, test.getHomecellPile().size());
		assertEquals("2s", test.getHomecellPile().peek().toString());

	}
	
	@Test
	public void stockPileTest() {

		test = new Game();

		// Ace's Up stock pile initially holds 48 cards [2 points]
		assertEquals(48, test.getStockPile().size());

		// Ace's Up stock pile correctly returns if adding a specific card is
		// legal or illegal (e.g., always illegal) [2 points]
		assertFalse(test.addStock());

		// Ace's Up stock pile correctly returns if removing a specific card is
		// legal or illegal (e.g., legal if the stock pile is not empty) [2
		// points]
		test = new Game();
		Stack<Card> s0 = new Stack<Card>();
		s0.push(new Card("2", "s"));
		s0.push(new Card("3", "s"));
		s0.push(new Card("4", "s"));
		s0.push(new Card("5", "s"));
		test.setStockPile(s0);
		assertTrue(test.moveStock());
		assertFalse(test.moveStock());

		// Dealing cards from Ace's Up stock pile removes the top 4 cards, adds
		// the removed cards to the tableau piles, and results in the 5th card
		// being the new top card [2 points]
		test = new Game();
		Stack<Card> s1 = new Stack<Card>();
		s1.push(new Card("2", "s"));
		s1.push(new Card("3", "s"));
		s1.push(new Card("4", "s"));
		s1.push(new Card("5", "s"));
		s1.push(new Card("2", "h"));
		s1.push(new Card("3", "h"));
		s1.push(new Card("4", "h"));
		s1.push(new Card("5", "h"));
		test.setStockPile(s1);
		test.moveStock();
		// First tableau pile after move stock
		assertEquals("5h", test.getTableauPiles().get(0).peek().toString());
		// Second tableau pile after move stock
		assertEquals("4h", test.getTableauPiles().get(1).peek().toString());
		// Third tableau pile after move stock
		assertEquals("3h", test.getTableauPiles().get(2).peek().toString());
		// Fourth tableau pile after move stock
		assertEquals("2h", test.getTableauPiles().get(3).peek().toString());
		// remaining card in stock pile
		assertEquals("5s", test.getStockPile().peek().toString());

	}

}
