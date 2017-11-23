package se.coconutflightbooking.gui;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout.Alignment;

import com.jgoodies.forms.factories.DefaultComponentFactory;
//import javax.swing.LayoutStyle.ComponentPlacement;
//import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WinBuildTestAdmin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinBuildTestAdmin window = new WinBuildTestAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WinBuildTestAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBounds(100, 100, 484, 631);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Avsluta");
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Ta bort i Food Menu");
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Lägga till i Food Menu");
		rdbtnNewRadioButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Ta bort flight");
		rdbtnNewRadioButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("ta bort flight");
			}
		});
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Skapa flight");
		rdbtnNewRadioButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("skapa flight");
			}
		});
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Ta bort flygplan");
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Skapa flygplan");
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("Efterkalkyl, total summering");
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("Efterkalkyl, senaste flygning");
		JLabel lblCoconutAirways = DefaultComponentFactory.getInstance().createTitle("CocoNut Airways");
		
		JLabel lblUpAndRunning = DefaultComponentFactory.getInstance().createLabel("Administrative Menu");
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(72)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnNewRadioButton_6)
								.addComponent(rdbtnNewRadioButton_5)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(rdbtnNewRadioButton_8)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnNewRadioButton_7)
										.addComponent(rdbtnNewRadioButton)))
								.addComponent(rdbtnNewRadioButton_2)
								.addComponent(rdbtnNewRadioButton_1)
								.addComponent(rdbtnNewRadioButton_3)
								.addComponent(rdbtnNewRadioButton_4)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addComponent(lblCoconutAirways)
							.addGap(18)
							.addComponent(lblUpAndRunning)))
					.addContainerGap(220, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCoconutAirways)
						.addComponent(lblUpAndRunning))
					.addGap(11)
					.addComponent(rdbtnNewRadioButton_6)
					.addGap(18)
					.addComponent(rdbtnNewRadioButton_5)
					.addGap(19)
					.addComponent(rdbtnNewRadioButton_4)
					.addGap(18)
					.addComponent(rdbtnNewRadioButton_3)
					.addGap(18)
					.addComponent(rdbtnNewRadioButton_2)
					.addGap(18)
					.addComponent(rdbtnNewRadioButton_1)
					.addGap(18)
					.addComponent(rdbtnNewRadioButton_8)
					.addGap(18)
					.addComponent(rdbtnNewRadioButton_7)
					.addGap(18)
					.addComponent(rdbtnNewRadioButton)
					.addContainerGap(183, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
	}
}
