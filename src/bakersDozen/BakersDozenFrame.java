package bakersDozen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * @author: Anthony Joy
 */

public class BakersDozenFrame extends JFrame {
	/**
	 * 
	 * This creates a new instance of BakersDozen
	 */
	static BakersDozen newGame = new BakersDozen();
	boolean b = Cardgui.highlight;
	/**
	 * 
	 * This the panel tableau
	 */
	static JPanel tableauPanel;
	/**
	 * This is the panel for homecell
	 */
	static JPanel homecellPanel;
	/**
	 * These are the cards for the top of the tableauPanel
	 * 
	 */
	static Card newCard1;
	static Card newCard2;
	static Card newCard3;
	static Card newCard4;
	static Card newCard5;
	static Card newCard6;
	static Card newCard7;
	static Card newCard8;
	static Card newCard9;
	static Card newCard10;
	static Card newCard11;
	static Card newCard12;
	static Card newCard13;
	/**
	 * 
	 * These are the JLabels that are to be added the tableaPanel directly
	 */
	static JLabel Cardgui1 = null;
	static JLabel Cardgui2 = null;
	static JLabel Cardgui3 = null;
	static JLabel Cardgui4 = null;
	static JLabel Cardgui5 = null;
	static JLabel Cardgui6 = null;
	static JLabel Cardgui7 = null;
	static JLabel Cardgui8 = null;
	static JLabel Cardgui9 = null;
	static JLabel Cardgui10 = null;
	static JLabel Cardgui11 = null;
	static JLabel Cardgui12 = null;
	static JLabel Cardgui13 = null;
	/**
	 * These are the cards for the that represent the HomeCell Panel
	 * 
	 */
	static Card oldCard1;
	static Card oldCard2;
	static Card oldCard3;
	static Card oldCard4;
	/**
	 * 
	 * These are the JLabels that are to be added to the HomeCellPanel directly
	 */
	static JLabel oldCardgui1 = null;
	static JLabel oldCardgui2 = null;
	static JLabel oldCardgui3 = null;
	static JLabel oldCardgui4 = null;
	Card cursor = MainGui.cursor;

	/**
	 * 
	 * This is the Constructer for the BakersDozenFrame
	 */
	public BakersDozenFrame() {

		setTitle("BakersDozen Game");
		setSize(1400, 800);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		/**
		 * 
		 * This panel is created to contain both the Tableau and the Homecell
		 */
		JPanel centralPanel = new JPanel();
		centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
		getContentPane().add(centralPanel, BorderLayout.CENTER);
		/**
		 * Creates tableau Panel
		 * 
		 */
		tableauPanel = new JPanel();
		tableauPanel.setBackground(Color.YELLOW);
		/**
		 * 
		 * Creates homeCellPanel
		 */
		homecellPanel = new JPanel();
		homecellPanel.setBackground(Color.orange);
		/**
		 * 
		 * Adds panels to the Central Panel
		 */
		centralPanel.add(tableauPanel);
		centralPanel.add(homecellPanel);
		dothis();
		listen();
		/**
		 * This panel is the endPanel
		 * 
		 * 
		 */
		JPanel endPanel = new JPanel();
		endPanel.setBackground(Color.DARK_GRAY);
		getContentPane().add(endPanel, BorderLayout.PAGE_END);
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		endPanel.add(exitButton);
	
	}

	/**
	 * 
	 * This method adds the action listener for the top cards
	 */
	public void listen() {

		oldCardgui1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (b == false) {
					if ((newGame.addHomecell(0, MainGui.cursor) == true)) {
						newGame.removeCard(MainGui.cursor, 10000);
						tableauPanel.removeAll();

						Cardgui.highlight = false;
						MainGui.highlightCheck = false;
						dothis();
						revalidate();
						repaint();
					} else {
						MainGui.show();
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		oldCardgui2.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (b == false) {
					if ((newGame.addHomecell(1, MainGui.cursor) == true)) {
						newGame.removeCard(MainGui.cursor, 10000);
						homecellPanel.removeAll();
						tableauPanel.removeAll();
						Cardgui.highlight = false;
						MainGui.highlightCheck = false;
						dothis();
						revalidate();
						repaint();
					} else {
						MainGui.show();
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		oldCardgui3.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (b == false) {
					if ((newGame.addHomecell(2, MainGui.cursor) == true)) {
						newGame.removeCard(MainGui.cursor, 10000);
						homecellPanel.removeAll();
						tableauPanel.removeAll();
						Cardgui.highlight = false;
						MainGui.highlightCheck = false;
						dothis();
						revalidate();
						repaint();
					} else {
						MainGui.show();
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		oldCardgui4.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (b == false) {
					if ((newGame.addHomecell(3, MainGui.cursor) == true)) {
						newGame.removeCard(MainGui.cursor, 10000);
						homecellPanel.removeAll();
						tableauPanel.removeAll();
						Cardgui.highlight = false;
						MainGui.highlightCheck = false;
						dothis();
						revalidate();
						repaint();
					} else {

						MainGui.show();
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		/**
		 * 
		 * Action Listener Card 1
		 */
		Cardgui1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Cardgui.highlight == true && !MainGui.cursor.getCardInfo().equals(newGame.grabtableau(0))) {
					if (newGame.addTableau(0, MainGui.cursor) == true) {
						tableauPanel.removeAll();
						homecellPanel.removeAll();
                       newGame.removeCard(MainGui.cursor, 0);
						Cardgui.highlight = false;
						MainGui.highlightCheck = false;
						dothis();
						revalidate();
						repaint();

					} else {
						MainGui.show();

					}

				} else {

				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		/**
		 * 
		 *
		 * Action Listener Card 2
		 */
		Cardgui2.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Cardgui.highlight == true && !MainGui.cursor.getCardInfo().equals(newGame.grabtableau(1))) {
					if (newGame.addTableau(1, MainGui.cursor) == true) {
						tableauPanel.removeAll();
						homecellPanel.removeAll();
						newGame.removeCard(MainGui.cursor, 1);
						Cardgui.highlight = false;
						MainGui.highlightCheck = false;
						dothis();
						revalidate();
						repaint();

					} else {
						MainGui.show();

					}

				} else {

				}

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		/**
		 * 
		 * Action Listener Card 3
		 */
		Cardgui3.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (b == false) {
					if (Cardgui.highlight == true && !MainGui.cursor.getCardInfo().equals(newGame.grabtableau(2))) {
						if (newGame.addTableau(2, MainGui.cursor) == true) {
							tableauPanel.removeAll();
							homecellPanel.removeAll();
							newGame.removeCard(MainGui.cursor, 2);
							Cardgui.highlight = false;
							MainGui.highlightCheck = false;
							dothis();
							revalidate();
							repaint();

						} else {
							MainGui.show();

						}

					} else {

					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		/**
		 * 
		 * 
		 * Action Listener Card 4
		 */
		Cardgui4.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Cardgui.highlight == true && !MainGui.cursor.getCardInfo().equals(newGame.grabtableau(3))) {
					if (newGame.addTableau(3, MainGui.cursor) == true) {
						tableauPanel.removeAll();
						homecellPanel.removeAll();
						newGame.removeCard(MainGui.cursor, 3);
						Cardgui.highlight = false;
						MainGui.highlightCheck = false;
						dothis();
						revalidate();
						repaint();

					} else {
						MainGui.show();

					}

				} else {

				}

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		/**
		 * 
		 * Action Listener Card 5
		 */
		Cardgui5.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Cardgui.highlight == true && !MainGui.cursor.getCardInfo().equals(newGame.grabtableau(4))) {
					if (newGame.addTableau(4, MainGui.cursor) == true) {
						tableauPanel.removeAll();
						homecellPanel.removeAll();
						newGame.removeCard(MainGui.cursor, 4);
						Cardgui.highlight = false;
						MainGui.highlightCheck = false;
						dothis();
						revalidate();
						repaint();

					} else {
						MainGui.show();

					}

				} else {

				}

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		/**
		 * 
		 * Action Listener Card 6
		 */
		Cardgui6.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Cardgui.highlight == true && !MainGui.cursor.getCardInfo().equals(newGame.grabtableau(5))) {
					if (newGame.addTableau(5, MainGui.cursor) == true) {
						tableauPanel.removeAll();
						homecellPanel.removeAll();
						newGame.removeCard(MainGui.cursor, 5);
						Cardgui.highlight = false;
						MainGui.highlightCheck = false;
						dothis();
						revalidate();
						repaint();

					} else {
						MainGui.show();

					}

				} else {

				}

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		/**
		 * 
		 * Action Listener Card 7
		 */
		Cardgui7.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Cardgui.highlight == true && !MainGui.cursor.getCardInfo().equals(newGame.grabtableau(6))) {
					if (newGame.addTableau(6, MainGui.cursor) == true) {
						tableauPanel.removeAll();
						homecellPanel.removeAll();
						newGame.removeCard(MainGui.cursor, 6);
						Cardgui.highlight = false;
						MainGui.highlightCheck = false;
						dothis();
						revalidate();
						repaint();

					} else {
						MainGui.show();

					}

				} else {

				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		/**
		 * 
		 * Action Listener Card 8
		 */
		Cardgui8.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Cardgui.highlight == true && !MainGui.cursor.getCardInfo().equals(newGame.grabtableau(7))) {
					if (newGame.addTableau(7, MainGui.cursor) == true) {
						tableauPanel.removeAll();
						homecellPanel.removeAll();
						newGame.removeCard(MainGui.cursor, 7);
						Cardgui.highlight = false;
						MainGui.highlightCheck = false;
						dothis();
						revalidate();
						repaint();

					} else {
						MainGui.show();

					}

				} else {

				}

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		/**
		 * 
		 * Action Listener Card 9
		 */
		Cardgui9.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Cardgui.highlight == true && !MainGui.cursor.getCardInfo().equals(newGame.grabtableau(8))) {
					if (newGame.addTableau(8, MainGui.cursor) == true) {
						tableauPanel.removeAll();
						homecellPanel.removeAll();
						newGame.removeCard(MainGui.cursor, 8);
						Cardgui.highlight = false;
						MainGui.highlightCheck = false;
						dothis();
						revalidate();
						repaint();

					} else {
						MainGui.show();

					}

				} else {

				}

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		/**
		 * 
		 * Action Listener Card 10
		 */
		Cardgui10.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Cardgui.highlight == true && !MainGui.cursor.getCardInfo().equals(newGame.grabtableau(9))) {
					if (newGame.addTableau(9, MainGui.cursor) == true) {
						tableauPanel.removeAll();
						homecellPanel.removeAll();
						newGame.removeCard(MainGui.cursor, 9);
						Cardgui.highlight = false;
						MainGui.highlightCheck = false;
						dothis();
						revalidate();
						repaint();

					} else {
						MainGui.show();

					}

				} else {

				}

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		/**
		 * 
		 * 
		 * Action Listener Card 11
		 */
		Cardgui11.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Cardgui.highlight == true && !MainGui.cursor.getCardInfo().equals(newGame.grabtableau(10))) {
					if (newGame.addTableau(10, MainGui.cursor) == true) {
						tableauPanel.removeAll();
						homecellPanel.removeAll();
						newGame.removeCard(MainGui.cursor, 10);
						Cardgui.highlight = false;
						MainGui.highlightCheck = false;
						dothis();
						revalidate();
						repaint();

					} else {
						MainGui.show();

					}

				} else {

				}

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		/**
		 * 
		 * Action Listener Card 12
		 */
		Cardgui12.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Cardgui.highlight == true && !MainGui.cursor.getCardInfo().equals(newGame.grabtableau(11))) {
					if (newGame.addTableau(11, MainGui.cursor) == true) {
						tableauPanel.removeAll();
						homecellPanel.removeAll();
						newGame.removeCard(MainGui.cursor, 11);
						Cardgui.highlight = false;
						MainGui.highlightCheck = false;
						dothis();
						revalidate();
						repaint();

					} else {
						MainGui.show();

					}

				} else {

				}

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		/**
		 * 
		 * Action Listener Card 13
		 */
		Cardgui13.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Cardgui.highlight == true && !MainGui.cursor.getCardInfo().equals(newGame.grabtableau(12))) {
					if (newGame.addTableau(12, MainGui.cursor) == true) {
						tableauPanel.removeAll();
						homecellPanel.removeAll();
						newGame.removeCard(MainGui.cursor, 12);
						Cardgui.highlight = false;
						MainGui.highlightCheck = false;
						dothis();
						revalidate();
						repaint();

					} else {
						MainGui.show();

					}

				} else {

				}

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
	}

	/**
	 * 
	 * This method adds the Cards to the Tableau Panel
	 */
	public void dothis() {

		homecellPanel.removeAll();

		/**
		 * 
		 * But first we must remove all of the homecell panels from previous additions
		 */

		/**
		 * The tableauPiles represents the tableauPiles in the Game
		 * 
		 */
		ArrayList<Deck> tableauPiles = newGame.getTableauPiles();
		/**
		 * 
		 * ThehomecellPiles represents the HomeCell Piles in the game
		 */
		ArrayList<Deck> homecellPiles = newGame.getHomecellPiles();
		/**
		 * Creates 1st Card 1st HomeCell Pile
		 */
		if (!homecellPiles.get(0).isEmpty()) {

			oldCard1 = homecellPiles.get(0).get(0);
			oldCardgui1 = new Cardgui(oldCard1.getImageName());
			homecellPanel.add(oldCardgui1, 0);
		} else {
			JLabel HomeCell1 = new JLabel("(Homecell1)");
			oldCardgui1 = HomeCell1;
			homecellPanel.add(oldCardgui1, 0);
		}
		/**
		 * 
		 * Creates 1st Card 2nd Homecell Pile
		 */
		if (!homecellPiles.get(1).isEmpty()) {
			oldCard2 = homecellPiles.get(1).get(0);
			oldCardgui2 = new Cardgui(oldCard2.getImageName());
			homecellPanel.add(oldCardgui2, 1);
		} else {
			JLabel HomeCell2 = new JLabel("(HomeCell2)");
			oldCardgui2 = HomeCell2;
			homecellPanel.add(oldCardgui2, 1);
		}
		/**
		 * 
		 * Creates 1st Card 3rd Homecell Pile
		 */
		if (!homecellPiles.get(2).isEmpty()) {
			oldCard3 = homecellPiles.get(2).get(0);
			oldCardgui3 = new Cardgui(oldCard3.getImageName());
			homecellPanel.add(oldCardgui3, 2);
		} else {
			JLabel HomeCell3 = new JLabel("(HomeCell3)");
			oldCardgui3 = HomeCell3;
			homecellPanel.add(oldCardgui3, 2);
		}
		/**
		 * 
		 * Creates 1st Card 4th Homecell Pile
		 */
		if (!homecellPiles.get(3).isEmpty()) {
			oldCard4 = homecellPiles.get(3).get(0);
			oldCardgui4 = new Cardgui(oldCard4.getImageName());
			homecellPanel.add(oldCardgui4, 3);
		} else {
			JLabel HomeCell4 = new JLabel("(HomeCell4)");
			oldCardgui4 = HomeCell4;
			homecellPanel.add(oldCardgui4, 3);
		}
		/**
		 * 
		 * Creates 1st Card Tableau 1st Tableau Pile
		 */
		if (!tableauPiles.get(0).isEmpty()) {
			System.out.println(newGame.getTableauPiles().get(0).size());
			newCard1 = tableauPiles.get(0).get(0);
			Cardgui1 = new Cardgui(newCard1.getImageName());
			tableauPanel.add(Cardgui1, 0);
		} else {
			JLabel hello = new JLabel("(Pile 1 Empty)");
			Cardgui1 = hello;
			tableauPanel.add(Cardgui1, 0);
		}

		/**
		 * 
		 * Creates 1st Card 2nd Tableau Pile
		 */

		if (!tableauPiles.get(1).isEmpty()) {
			newCard2 = tableauPiles.get(1).get(0);
			Cardgui2 = new Cardgui(newCard2.getImageName());
			tableauPanel.add(Cardgui2, 1);
		} else {
			JLabel hello = new JLabel("Pile 2 Empty");
			Cardgui1 = hello;
			tableauPanel.add(Cardgui1, 1);
		}

		/**
		 * 
		 * Creates 1st Card 3rd Tableau Pile
		 */

		if (!tableauPiles.get(2).isEmpty()) {
			newCard3 = tableauPiles.get(2).get(0);
			Cardgui3 = new Cardgui(newCard3.getImageName());
			tableauPanel.add(Cardgui3, 2);
		} else {
			JLabel hello = new JLabel("(Pile 3 Empty)");
			Cardgui1 = hello;
			tableauPanel.add(Cardgui1, 2);
		}

		/**
		 * 
		 * Creates 1st Card 4th Tableau Pile
		 */

		if (!tableauPiles.get(3).isEmpty()) {
			newCard4 = tableauPiles.get(3).get(0);
			Cardgui4 = new Cardgui(newCard4.getImageName());
			tableauPanel.add(Cardgui4, 3);
		} else {
			JLabel hello = new JLabel("(Pile 4 Empty)");
			Cardgui1 = hello;
			tableauPanel.add(Cardgui3);
		}

		/**
		 * 
		 * 
		 * Creates 1st Card 5th Tableau Pile
		 */

		if (!tableauPiles.get(4).isEmpty()) {
			newCard5 = tableauPiles.get(4).get(0);
			Cardgui5 = new Cardgui(newCard5.getImageName());
			tableauPanel.add(Cardgui5, 4);
		} else {
			JLabel hello = new JLabel("(Pile 5 Empty)");
			Cardgui1 = hello;
			tableauPanel.add(Cardgui1);
		}

		/**
		 *
		 * Creates 1st Card 6th Tableau Pile
		 */

		if (!tableauPiles.get(5).isEmpty()) {
			newCard6 = tableauPiles.get(5).get(0);
			Cardgui6 = new Cardgui(newCard6.getImageName());
			tableauPanel.add(Cardgui6, 5);
		} else {
			JLabel hello = new JLabel("(Pile 6 Empty");
			Cardgui1 = hello;
			tableauPanel.add(Cardgui1);
		}

		/**
		 * 
		 * 
		 * Creates 1st Card 7th Tableau Pile
		 */

		if (!tableauPiles.get(6).isEmpty()) {
			newCard7 = tableauPiles.get(6).get(0);
			Cardgui7 = new Cardgui(newCard7.getImageName());
			tableauPanel.add(Cardgui7, 6);
		} else {
			JLabel hello = new JLabel("(Pile 7 Empty)");
			Cardgui1 = hello;
			tableauPanel.add(Cardgui1);
		}

		/**
		 *
		 * Creates 1st CArd 8th Tableau Pile
		 */

		if (!tableauPiles.get(7).isEmpty()) {
			newCard8 = tableauPiles.get(7).get(0);
			Cardgui8 = new Cardgui(newCard8.getImageName());
			tableauPanel.add(Cardgui8, 7);
		} else {
			JLabel hello = new JLabel("(Pile 8 Empty)");
			Cardgui1 = hello;
			tableauPanel.add(Cardgui1);
		}

		/**
		 * 
		 * Creates 1st Card 9th Tableau Pile
		 */

		if (!tableauPiles.get(8).isEmpty()) {
			newCard9 = tableauPiles.get(8).get(0);
			Cardgui9 = new Cardgui(newCard9.getImageName());
			tableauPanel.add(Cardgui9, 8);
		} else {
			JLabel hello = new JLabel("(Pile 9 Empty)");
			Cardgui1 = hello;
			tableauPanel.add(Cardgui1);
		}

		/**
		 * 
		 * Creates 1st Card 10th Tableau Pile
		 */

		if (!tableauPiles.get(9).isEmpty()) {
			newCard10 = tableauPiles.get(9).get(0);
			Cardgui10 = new Cardgui(newCard10.getImageName());
			tableauPanel.add(Cardgui10, 9);
		} else {
			JLabel hello = new JLabel("(Pile 10)");
			Cardgui1 = hello;
			tableauPanel.add(Cardgui1);
		}

		/**
		 * 
		 * Creates 1st Card 11th Tableau Pile
		 */

		if (!tableauPiles.get(10).isEmpty()) {
			newCard11 = tableauPiles.get(10).get(0);
			Cardgui11 = new Cardgui(newCard11.getImageName());
			tableauPanel.add(Cardgui11, 10);
		} else {
			JLabel hello = new JLabel("(Pile 11 )");
			Cardgui1 = hello;
			tableauPanel.add(Cardgui1);
		}

		/**
		 * 
		 * 
		 * Creates 1st Card 12th Tableau Pile
		 */
		if (!tableauPiles.get(11).isEmpty()) {
			newCard12 = tableauPiles.get(11).get(0);
			Cardgui12 = new Cardgui(newCard12.getImageName());
			tableauPanel.add(Cardgui12, 11);
		} else {
			JLabel hello = new JLabel("(Pile 12 Empty)");
			Cardgui1 = hello;
			tableauPanel.add(Cardgui1);
		}
		/**
		 * 
		 * Creates 1st Card 13th Tableau Pile
		 */

		if (!tableauPiles.get(12).isEmpty()) {
			newCard13 = tableauPiles.get(12).get(0);
			Cardgui13 = new Cardgui(newCard13.getImageName());
			tableauPanel.add(Cardgui13, 12);
		} else {
			JLabel hello = new JLabel("(Pile 13 Empty)");
			Cardgui1 = hello;
			tableauPanel.add(Cardgui1);
		}

		/**
		 * 
		 * Adds Remaining Cards Tableau Pile 1
		 */

		for (int i = 1; i < tableauPiles.get(0).size(); i++) {
			JLabel Cardgui1a = new Cardgui(tableauPiles.get(0).get(i).getImageName());

			Cardgui1.add(Cardgui1a);
			Cardgui1a.move(0, 10);
			Cardgui1 = Cardgui1a;
		}

		/**
		 * 
		 * Adds Remaining Cards Tableau Pile 2
		 */

		for (int i = 1; i < tableauPiles.get(1).size(); i++) {
			JLabel Cardgui1a = new Cardgui(tableauPiles.get(1).get(i).getImageName());

			Cardgui2.add(Cardgui1a);
			Cardgui1a.move(0, 10);
			Cardgui2 = Cardgui1a;
		}

		/**
		 * 
		 * Adds Remaining Cards Tableau Pile 3
		 */

		for (int i = 1; i < tableauPiles.get(2).size(); i++) {
			JLabel Cardgui1a = new Cardgui(tableauPiles.get(2).get(i).getImageName());

			Cardgui3.add(Cardgui1a);
			Cardgui1a.move(0, 10);
			Cardgui3 = Cardgui1a;
		}

		/**
		 * 
		 * Adds Remaining Cards Tableau Pile 4
		 */

		for (int i = 1; i < tableauPiles.get(3).size(); i++) {
			JLabel Cardgui1a = new Cardgui(tableauPiles.get(3).get(i).getImageName());

			Cardgui4.add(Cardgui1a);
			Cardgui1a.move(0, 10);
			Cardgui4 = Cardgui1a;
		}

		/**
		 * 
		 * Adds Remaining Cards Tableau Pile 5
		 */

		for (int i = 1; i < tableauPiles.get(4).size(); i++) {
			JLabel Cardgui1a = new Cardgui(tableauPiles.get(4).get(i).getImageName());

			Cardgui5.add(Cardgui1a);

			Cardgui1a.move(0, 20);
			Cardgui5 = Cardgui1a;
		}

		/**
		 * 
		 * Adds Remaining Cards Tableau Pile 6
		 */

		for (int i = 1; i < tableauPiles.get(5).size(); i++) {
			JLabel Cardgui1a = new Cardgui(tableauPiles.get(5).get(i).getImageName());

			Cardgui6.add(Cardgui1a);
			Cardgui1a.move(0, 10);
			Cardgui6 = Cardgui1a;
		}

		/**
		 * 
		 * Adds Remaining Cards Tableau Pile 7
		 */

		for (int i = 1; i < tableauPiles.get(6).size(); i++) {
			JLabel Cardgui1a = new Cardgui(tableauPiles.get(6).get(i).getImageName());

			Cardgui7.add(Cardgui1a);
			Cardgui1a.move(0, 10);
			Cardgui7 = Cardgui1a;
		}

		/**
		 * 
		 * Adds Remaining Cards Tableau Pile 8
		 */

		for (int i = 1; i < tableauPiles.get(7).size(); i++) {
			JLabel Cardgui1a = new Cardgui(tableauPiles.get(7).get(i).getImageName());

			Cardgui8.add(Cardgui1a);
			Cardgui1a.move(0, 10);
			Cardgui8 = Cardgui1a;
		}

		/**
		 * 
		 * Adds Remaining Cards Tableau Pile 9
		 */
		for (int i = 1; i < tableauPiles.get(8).size(); i++) {
			JLabel Cardgui1a = new Cardgui(tableauPiles.get(8).get(i).getImageName());
			Cardgui9.add(Cardgui1a);
			Cardgui1a.move(0, 10);
			Cardgui9 = Cardgui1a;
		}

		/**
		 * 
		 * Adds Remaining Cards Tableau Pile 10
		 */
		for (int i = 1; i < tableauPiles.get(9).size(); i++) {
			JLabel Cardgui1a = new Cardgui(tableauPiles.get(9).get(i).getImageName());
			Cardgui10.add(Cardgui1a);
			Cardgui1a.move(0, 10);
			Cardgui10 = Cardgui1a;
		}

		/**
		 * 
		 * Adds Remaining Cards Tableau Pile 11
		 */
		for (int i = 1; i < tableauPiles.get(10).size(); i++) {
			JLabel Cardgui1a = new Cardgui(tableauPiles.get(10).get(i).getImageName());
			Cardgui11.add(Cardgui1a);
			Cardgui1a.move(0, 10);
			Cardgui11 = Cardgui1a;
		}

		/**
		 * 
		 * Adds Remaining Cards Tableau Pile 12
		 */
		for (int i = 1; i < tableauPiles.get(11).size(); i++) {
			JLabel Cardgui1a = new Cardgui(tableauPiles.get(11).get(i).getImageName());
			Cardgui12.add(Cardgui1a);
			Cardgui1a.move(0, 10);
			Cardgui12 = Cardgui1a;
		}

		/**
		 * 
		 * Adds Remaining Cards Tableau Pile 13
		 */
		for (int i = 1; i < tableauPiles.get(12).size(); i++) {
			JLabel Cardgui1a = new Cardgui(tableauPiles.get(12).get(i).getImageName());
			Cardgui13.add(Cardgui1a);
			Cardgui1a.move(0, 10);
			Cardgui13 = Cardgui1a;
		}
		listen();
	}

}
