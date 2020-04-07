package bakersDozen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*
 * Author: Yuanyi Yang
 */

public class MainGui {
	static JFrame frame = new JFrame("The Game");
	//a card object representing current highlighted card
	static Card cursor;
	//a boolean indicate if there's any card on highlight, prevents multiple highlights at once
	static boolean highlightCheck = false;
	
	static boolean freecellCheck = false;
	
	static boolean bakersdozenCheck = false;
	
	static boolean AcesCheck = false;
	
	//the main control center of the game's gui, contains three button to operate the game
	public static void runGUI(){
		
		frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        //the central panel that can add other panels, panels will separate vertically when added onto the central panel
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel,BoxLayout.Y_AXIS));
        frame.getContentPane().add(centralPanel, BorderLayout.CENTER);
        
        //homecell panel will be added onto the central panel first, so that it's position will be on a higher y-axis than other panels
        
        //tableau panel are the second element to be added onto the central panel, so that its position will be lower than our homecells
        JPanel tableauPanel = new JPanel();
        tableauPanel.setBackground(Color.GRAY);
        
        //now finally adding the two panels
        
        centralPanel.add(tableauPanel);
        
        //adding suits image into different homecell panels
        //I added the images from the web, it wasn't in the folder that Prof. provided to us
        
        //end panel is a panel that can be added onto the frame as a bottom panel, I will add the three buttons onto this end panel
        JPanel endPanel = new JPanel();
        endPanel.setBackground(Color.DARK_GRAY);;
        frame.getContentPane().add(endPanel, BorderLayout.PAGE_END);
        
       // Choosing the Exit menu item ends the application [2 points]
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });  
        
        JButton bakersDozenButton = new JButton("Baker's Dozen");
        bakersDozenButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// It will not do anything until the FreecellFrame class is finished
				frame = new BakersDozenFrame();
				bakersdozenCheck = true;
			}
        	
        });
        
        
        
        
        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {

        		Desktop d = Desktop.getDesktop();
        		try {
					d.browse(new URI("https://www.youtube.com/watch?v=oHg5SJYRHA0"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        
       
        
        endPanel.add(bakersDozenButton);
        endPanel.add(exitButton);
        endPanel.add(newGameButton);
       
        Deck test = new Deck();
       Card one= test.get(0);
   JLabel Cardgui;
       Cardgui = new Cardgui(one.getImageName());
        for(int i = 1; i <test.size(); i++) {	
			JLabel Cardgui1a = new Cardgui(test.get(i).getImageName());
			     Cardgui.add(Cardgui1a);
			     Cardgui1a.move(0,1);
			 	  Cardgui=Cardgui1a;
        }
			   }		
	
	
	public static void show() {
		frame= new fakenews();
		
	}
			 
	
	public MainGui(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BakersDozenFrame();
                
            }
        });
    }

}