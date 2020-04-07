package operator;

import javax.swing.SwingUtilities;

/**
 * @author Yuanyi Yang
 *
 * yuanyiya@buffalo.edu
 */


public class GameOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SwingUtilities.invokeLater(new Runnable() {
				@Override
	            public void run() {
	            	new MainGui();
	            }
	        });

	}
	
	

}
