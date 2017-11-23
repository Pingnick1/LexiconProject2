package se.coconutflightbooking.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JMenuBar;
import java.awt.Canvas;
import java.awt.Choice;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

public class WinBuildTest {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinBuildTest window = new WinBuildTest();
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
	public WinBuildTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBounds(100, 100, 740, 643);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Avsluta");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Avsluta");
			}
		});
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Kolla bokningsläge");
		rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Kolla bokningsläge");
			}
		});
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Boka luftiga förfriskningar");
		rdbtnNewRadioButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Boka meny");
			}
		});
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Boka flygning");
		rdbtnNewRadioButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Boka flygning");
			}
		});
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Välja första klass");
		rdbtnNewRadioButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Välja första klass");
			}
		});
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Registrera CocoClub-poäng");
		rdbtnNewRadioButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Registrera CoCo-poäng");
			}
		});
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Välja flight");
		rdbtnNewRadioButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Välja flight");
			}
		});
		
		JLabel lblCoconutAirways = DefaultComponentFactory.getInstance().createTitle("CocoNut Airways                                                 ");
		JLabel lblUpAndRunning = DefaultComponentFactory.getInstance().createLabel("                          Flight                   "
				+ "               First Class     Economy");
		
		JSpinner spinner = new JSpinner();
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setToolTipText("Coco-points");
		
		JTextArea txtrCocolevel = new JTextArea();
		txtrCocolevel.setText("   Coco-level");
		
		JList list = new JList();
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseclick");
			}
		});
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"SK161 G\u00F6teborg 14.45", new Integer(9), new Integer(2)},
				{"departure.getDate().toString()", "2 seats", null},
				{"departure.getDate().toString()", "i", null},
				{"departure.getDate().toString()", "9", "2"},
				{"departure.getDate().toString()", null, null},
				{"departure.getDate().toString()", null, null},
				{"departure.getDate().toString()", null, "Line7"},
				{"SK162 Göteborg 16.45", null, null},
				{"departure.getDate().toString()", "0", "0"},
				{ "SK161 Göteborg 18.45", "0", "2"},
				{"departure.getDate().toString()", "2", "0"},
				{"departure.getDate().toString()", null, null},
				{"departure.getDate().toString()", null, "Bottom"},
				{"departure.getDate().toString()", null, null},
				{"departure.getDate().toString()", null, null},
				{"departure.getDate().toString()", null, null},
			},
			new String[] {
				"Flight", "First Class/Available", "Economy/Available"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(220);
		table.getColumnModel().getColumn(0).setMinWidth(175);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(72)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtnNewRadioButton_6)
									.addGap(137)
									.addComponent(table, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE))
								.addComponent(rdbtnNewRadioButton_3)
								.addComponent(rdbtnNewRadioButton_2)
								.addComponent(rdbtnNewRadioButton_4)
								.addComponent(rdbtnNewRadioButton_5)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnNewRadioButton_1)
								.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnNewRadioButton)
								.addComponent(txtrCocolevel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(112)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(74, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblCoconutAirways)
					.addPreferredGap(ComponentPlacement.RELATED, 390, Short.MAX_VALUE)
					.addComponent(lblUpAndRunning)
					.addGap(114))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCoconutAirways)
						.addComponent(lblUpAndRunning))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButton_6)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(rdbtnNewRadioButton_1)
					.addGap(28)
					.addComponent(rdbtnNewRadioButton_3)
					.addGap(27)
					.addComponent(rdbtnNewRadioButton_4)
					.addGap(18)
					.addComponent(rdbtnNewRadioButton_2)
					.addGap(18)
					.addComponent(rdbtnNewRadioButton_5)
					.addGap(11)
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtrCocolevel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(rdbtnNewRadioButton)
					.addGap(99)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(69))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
	}
}
