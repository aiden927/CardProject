package AcesUp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import library.OverlapLayout;
import operator.MainGui;

/**
 * @author Yuanyi Yang
 *
 * yuanyiya@buffalo.edu
 */

@SuppressWarnings("serial")
public class Gui extends JFrame {
	private Game link;
	private boolean highlightSwitch;
	private CardPanel stockPanel;
	private CardPanel tableauPanel0;
	private CardPanel tableauPanel1;
	private CardPanel tableauPanel2;
	private CardPanel tableauPanel3;
	private CardPanel homecellPanel;
	private CardPanel cursor;
	private Gui frame = this;

	public Gui() {
		// new game instance
		link = new Game();
		highlightSwitch = false;
		cursor = null;

		// main frame
		new JFrame("Ace's Up");
		setSize(1600, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		Box gameBox = Box.createHorizontalBox();
		add(gameBox, BorderLayout.CENTER);

		stockPanel = new CardPanel(link.getStockPile(), "s", 4);
		stockPanel.setBackground(Color.GRAY);
		gameBox.add(stockPanel);
		gameBox.add(Box.createGlue());
		tableauPanel0 = new CardPanel(link.getTableauPiles().get(0), "t", 0);
		tableauPanel0.setBackground(Color.LIGHT_GRAY);
		gameBox.add(tableauPanel0);
		tableauPanel1 = new CardPanel(link.getTableauPiles().get(1), "t", 1);
		tableauPanel1.setBackground(Color.GRAY);
		gameBox.add(Box.createGlue());
		gameBox.add(tableauPanel1);
		tableauPanel2 = new CardPanel(link.getTableauPiles().get(2), "t", 2);
		tableauPanel2.setBackground(Color.LIGHT_GRAY);
		gameBox.add(Box.createGlue());
		gameBox.add(tableauPanel2);
		tableauPanel3 = new CardPanel(link.getTableauPiles().get(3), "t", 3);
		tableauPanel3.setBackground(Color.GRAY);
		gameBox.add(Box.createGlue());
		gameBox.add(tableauPanel3);
		homecellPanel = new CardPanel(link.getHomecellPile(), "h", 5);
		homecellPanel.setBackground(Color.LIGHT_GRAY);
		gameBox.add(Box.createGlue());
		gameBox.add(homecellPanel);

		JPanel buttonMenu = new JPanel();
		buttonMenu.setBackground(Color.DARK_GRAY);
		JButton exit = new JButton("Exit to Menu");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new MainGui();

					}
				});
				dispose();

			}

		});
		JButton restart = new JButton("Restart the Game");
		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new Gui();

					}
				});
				dispose();
			}

		});
		//This eastern egg is from luis's idea
		JButton ee = new JButton("Cheat to Win");
		ee.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {

        		Desktop d = Desktop.getDesktop();
        		try {
					d.browse(new URI("https://www.youtube.com/watch?v=r9L4AseD-aA"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
		buttonMenu.add(restart);
		buttonMenu.add(ee);
		buttonMenu.add(exit);
		add(buttonMenu, BorderLayout.SOUTH);
	}

	public void frameValidate() {
		validate();
	}

	public void checkWinner() {
		if (stockPanel.sc.isEmpty() && tableauPanel0.sc.peek().getCard().getRank().equals("a")
				&& tableauPanel1.sc.peek().getCard().getRank().equals("a")
				&& tableauPanel2.sc.peek().getCard().getRank().equals("a")
				&& tableauPanel3.sc.peek().getCard().getRank().equals("a")) {
			JOptionPane.showMessageDialog(frame, "Congratulations! Genius", "Success", JOptionPane.ERROR_MESSAGE);
		}
	}

	private class CardGui extends JLabel {
		private ImageIcon cardImage;
		private String name;

		public CardGui(String name) {
			cardImage = new ImageIcon("Cards/" + name + ".gif");
			setIcon(cardImage);
			Dimension d = new Dimension(cardImage.getIconWidth() + 5, cardImage.getIconHeight() + 5);
			setSize(d);
			setPreferredSize(d);
			setMaximumSize(d);
			setMinimumSize(d);
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			this.name = name;

		}

		public Card getCard() {
			return new Card("" + name.charAt(0), "" + name.charAt(1));
		}

	}

	private class CardPanel extends JPanel {

		private Stack<CardGui> sc;
		private OverlapLayout layout = new OverlapLayout(new Point(0, 20));
		private CardPanel me = this;
		private boolean reselectable;
		private String pos;
		private int posNum;

		public CardPanel(Stack<Card> param, String pos, int posNum) {
			this.pos = pos;
			this.posNum = posNum;
			reselectable = false;
			setLayout(layout);
			sc = new Stack<CardGui>();
			Iterator<Card> it = param.iterator();
			while (it.hasNext()) {
				CardGui temp = new CardGui(it.next().toString());
				sc.push(temp);
				add(temp);
			}
			Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
			Border SELECTED_BORDER = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK);
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!highlightSwitch) {
						sc.peek().setBorder(SELECTED_BORDER);
						repaint();
						highlightSwitch = true;
						reselectable = true;
						cursor = me;
					} else if (highlightSwitch && reselectable) {
						sc.peek().setBorder(UNSELECTED_BORDER);
						repaint();
						highlightSwitch = false;
						reselectable = false;
						System.out.println("");
						System.out.println("Move Stock " + ms());
						System.out.println("Current Stockpile" + link.getStockPile().toString());
						System.out.println("Current Tableau0" + link.getTableauPiles().get(0).toString());
						System.out.println("Current Tableau1" + link.getTableauPiles().get(1).toString());
						System.out.println("Current Tableau2" + link.getTableauPiles().get(2).toString());
						System.out.println("Current Tableau3" + link.getTableauPiles().get(3).toString());
						System.out.println("Current Top Tableaus" + link.getTopTableaus());
						System.out.println("");
						revalidate();
						cursor = null;

					} else if (highlightSwitch && !reselectable) {
						cursor.sc.peek().setBorder(UNSELECTED_BORDER);
						cursor.repaint();
						repaint();
						cursor.reselectable = false;
						highlightSwitch = false;
						if (cursor.pos.equals("t") && pos.equals("t")) {
							System.out.println("");
							System.out.println("Move Tableau to Tableau" + ttt(cursor.posNum, posNum));
							System.out.println("Current Tableau0" + link.getTableauPiles().get(0).toString());
							System.out.println("Current Tableau1" + link.getTableauPiles().get(1).toString());
							System.out.println("Current Tableau2" + link.getTableauPiles().get(2).toString());
							System.out.println("Current Tableau3" + link.getTableauPiles().get(3).toString());
							System.out.println("Current Top Tableaus" + link.getTopTableaus());
							System.out.println("");
							revalidate();

						} else if (cursor.pos.equals("t") && pos.equals("h")) {
							System.out.println("");
							System.out.println("Move Tableau to Homecell" + tth(cursor.posNum));
							System.out.println("Current Tableau0" + link.getTableauPiles().get(0).toString());
							System.out.println("Current Tableau1" + link.getTableauPiles().get(1).toString());
							System.out.println("Current Tableau2" + link.getTableauPiles().get(2).toString());
							System.out.println("Current Tableau3" + link.getTableauPiles().get(3).toString());
							System.out.println("Current Homecellpile" + link.getHomecellPile().toString());
							System.out.println("Current Top Tableaus" + link.getTopTableaus());
							System.out.println("");
							checkWinner();
							revalidate();

						}
						cursor = null;

					}
					frameValidate();

				}

				@Override
				public void mouseReleased(MouseEvent e) {

				}
			});
		}

		public boolean ms() {
			if (pos.equals("s")) {
				if (link.moveStock()) {
					addToPanel(tableauPanel0);
					addToPanel(tableauPanel1);
					addToPanel(tableauPanel2);
					addToPanel(tableauPanel3);
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}

		public boolean ttt(int f, int t) {
			if (cursor.pos.equals("t") && pos.equals("t")) {
				if (link.moveTableauToTableau(cursor.posNum, posNum)) {
					cursor.addToPanel(me);
					return true;
				} else {
					JOptionPane.showMessageDialog(frame, "nope", "Failure", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			} else {
				return false;
			}

		}

		public boolean tth(int f) {
			if (cursor.pos.equals("t") && pos.equals("h")) {
				if (link.moveTableauToHomecell(cursor.posNum)) {
					cursor.addToPanel(me);
					return true;
				} else {
					JOptionPane.showMessageDialog(frame, "nope", "Failure", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			} else {
				return false;
			}
		}

		private CardGui removeHead() {
			remove(sc.peek());
			CardGui retVal = sc.pop();
			return retVal;
		}

		public void addToPanel(CardPanel param) {
			CardGui toAdd = removeHead();
			param.add(toAdd);
			param.sc.push(toAdd);

		}
	}

}
