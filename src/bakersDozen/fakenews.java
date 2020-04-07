package bakersDozen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




@SuppressWarnings("serial")
public class fakenews extends JFrame {



	JLabel helloworld = new JLabel("INVALID");

	public fakenews() {
		setTitle("Error");
		setSize(200, 50);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		

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
		endPanel.add(helloworld);
		

	}

}

	
