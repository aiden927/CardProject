package bakersDozen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

import bakersDozen.Card;
import bakersDozen.Deck;
//import game.BakersDozen;
//import game.Freecell;

/*
 * Author: Yuanyi Yang
 */
@SuppressWarnings("serial")
public class Cardgui extends JLabel{
	
	//boolean that shows if the current cardgui is highlighted or not
	static boolean highlight;
	//to link the cardgui with a card class
	   Card card;
	 
	

	public Cardgui(String i) {
		//to link the cardgui with a card class
		Deck deck = new Deck();
		for(int cursor = 0; cursor<deck.size(); cursor++){
			if(i.equals(deck.get(cursor).getImageName())){
				card = deck.get(cursor);
			}
		}
		//loading the image files and creating a card label
	    ImageIcon cardImage = new ImageIcon("Cards/"+i+".gif");

	    setIcon(cardImage);
	    Dimension d = new Dimension(cardImage.getIconWidth() + 10, cardImage.getIconHeight() + 10);
	    
//	    MainGui hello= new MainGui();
	     
	    
	    
	    
	    setSize(d);
	    setPreferredSize(d);
	    setMaximumSize(d);
	    setMinimumSize(d);
	    highlight = false;
	    Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
	    Border SELECTED_BORDER = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK);
	    //mouse listener of highlighting a card if clicked
	    //and unhighlight if clicked when it's already highlighted
//	    BakersDozen b = new BakersDozen();
//	    Freecell f = new Freecell();
	    addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(highlight==false && MainGui.highlightCheck==false){
					setBorder(SELECTED_BORDER);
				    repaint();
				   // setLocation(getHorizontalAlignment() - 14, getVerticalAlignment());
				    highlight = true;
				    MainGui.cursor = card;
				    MainGui.highlightCheck = true;
				}else if(highlight==true){
					if(MainGui.cursor==card) {
						setBorder(UNSELECTED_BORDER);
					    repaint();
					    //setLocation(getHorizontalAlignment() - 14, getVerticalAlignment());
					    highlight = false;
					    MainGui.highlightCheck = false;
					    MainGui.cursor=null;
					}else {
						if(MainGui.bakersdozenCheck == true) {
							
							if(MainGui.cursor.getRank().compareTo(card.getRank())==-1){
								
								//BakersDozenFrame.newGame.addTableau(MainGui.cursor.getTableau() , card);
							}
						}else if(MainGui.freecellCheck == true) {
							
						}
					}
				
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
	    });
	    
	    
	  }
	
	//return a card object of the current cardgui/card label
	public Card getGuiCard(){
		return card;
	}
	
	//Check to see if this cardgui is highlighted or not
	public boolean highlightable(){
		if(highlight){
			return false;
		}else{
			return true;
		}
	}
	
	public void reset() {
		
	}
	
}