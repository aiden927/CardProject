package operator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import AcesUp.Gui;

/**
 * @author Yuanyi Yang
 *
 * yuanyiya@buffalo.edu
 */

@SuppressWarnings("serial")
public class MainGui extends JFrame {

	@SuppressWarnings("unused")
	private MainGui me = this;
	

	public MainGui() {
		
		
		new JFrame("Ace's Up");
		setSize(1600, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		JLabel menu = new JLabel();
		ImageIcon icon = new ImageIcon("Cards/au.jpg");
		menu.setIcon(icon);
		add(menu, BorderLayout.CENTER);
		JPanel bottonMenu = new JPanel();
		bottonMenu.setBackground(Color.DARK_GRAY);
		JButton start = new JButton("Ace's Up");
		start.addActionListener(new ActionListener() {

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
		JButton exit = new JButton("Exit to Desktop");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		});
		JButton bd = new JButton("Baker's Dozen");
		bd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new bakersDozen.MainGui();
				
			}
			
		});
		bottonMenu.add(start);
		bottonMenu.add(bd);
		bottonMenu.add(exit);
		add(bottonMenu, BorderLayout.SOUTH);
	}

}
