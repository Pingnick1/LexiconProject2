package se.coconutflightbooking.gui; 

import java.awt.EventQueue;

import javax.swing.JFrame;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import se.coconutflightbooking.DepartureListHandler;

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
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TestWindows extends JFrame{

	private JFrame frmCoconutAirwaysBooking;
	private JTable table;
	private DepartureListHandler departures = new DepartureListHandler();
	private JTable tableFoodMenu;
	
	//Our variables:
	private Integer priceFood = 0;
    //private String foodName = "";
    private Integer priceTicket = 0;
    //private String departure = "";
	
	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWindows window = new TestWindows();
					window.frmCoconutAirwaysBooking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestWindows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCoconutAirwaysBooking = new JFrame();
		frmCoconutAirwaysBooking.setTitle("Coconut Airways Booking");
		frmCoconutAirwaysBooking.getContentPane().setBackground(new Color(135, 206, 250));
		frmCoconutAirwaysBooking.setBounds(100, 100, 982, 704);
		frmCoconutAirwaysBooking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JLabel lblNewLabel = new JLabel("Vald Avg\u00E5ng:");
		
		JLabel lblNewLabel_1 = new JLabel("Klass:");
		
		JLabel lblNewLabel_2 = new JLabel("Kund:");
		
		JTextPane textPaneCustomer = new JTextPane();
		
		JLabel jLabelChosenDeparture = new JLabel("");
		
		JLabel jLabelChosenClass = new JLabel("");
		
		JLabel lblNewLabel_3 = new JLabel("Vald Matr\u00E4tt:");
		
		JLabel jLabelFoodOrder = new JLabel("");
		
		JLabel lblPris = new JLabel("Pris:");
		
		JLabel jLabelTicketPrice = new JLabel("0");
		
		JLabel label = new JLabel("Pris:");
		
		JLabel jLabelFoodCost = new JLabel("0");
		
		JLabel lblTotal = new JLabel("Total:");
		
		JLabel jLabelTotalPrice = new JLabel("0");
		
		JButton btnBoka = new JButton("Boka");
		btnBoka.setEnabled(false);
		GroupLayout groupLayout = new GroupLayout(frmCoconutAirwaysBooking.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 643, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabelFoodOrder, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(jLabelChosenDeparture, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textPaneCustomer, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)))
							.addGap(18)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jLabelChosenClass, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPris, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(jLabelTicketPrice, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(jLabelFoodCost, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(jLabelTotalPrice, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnBoka))))
					.addContainerGap(243, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addComponent(textPaneCustomer, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jLabelChosenClass, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(jLabelTicketPrice, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPris, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
								.addComponent(jLabelChosenDeparture, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addComponent(jLabelFoodOrder, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addComponent(jLabelFoodCost, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(jLabelTotalPrice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTotal, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
					.addGap(40)
					.addComponent(btnBoka)
					.addGap(99))
		);
		
		table = new JTable();
		tabbedPane.addTab("Departures/Seats", null, table, null);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Integer priceTicket = 0;
			    String departure = "";
				
				int departureIndex = table.rowAtPoint(e.getPoint());
			    int flightClassIndex = table.columnAtPoint(e.getPoint());
			    //System.out.println("mouseclick at: " + departureIndex + "," + flightClassIndex);
			    //String value = table.getValueAt(departureIndex, flightClassIndex).toString();
			    
			    
			    
			    
			    if ( flightClassIndex == 0 || departureIndex == 0) {   }
			    else if (flightClassIndex ==1 || flightClassIndex == 2) {
			    	//System.out.println("Flight:" + departureIndex + ", Första klass, value:" + value);
			    	departure = table.getValueAt(departureIndex, 0).toString();
			    	priceTicket = (Integer) table.getValueAt(departureIndex, 2);
			    	
			    	jLabelChosenDeparture.setText(departure);
			    	jLabelChosenClass.setText("Första klass");
			    	jLabelTicketPrice.setText(priceTicket.toString());
			    	
			    }
			    else if (flightClassIndex ==3 || flightClassIndex == 4 ) {
			    	departure = table.getValueAt(departureIndex, 0).toString();
			    	priceTicket = (Integer) table.getValueAt(departureIndex, 4);
				    //System.out.println("Flight:" + departureIndex + ", Ekonomiklass, value:" + value);
			    	jLabelChosenDeparture.setText(departure);
			    	jLabelChosenClass.setText("Ekonomiklass");
			    	jLabelTicketPrice.setText(priceTicket.toString());
				}
			    Integer totalPrice = priceTicket+priceFood;
			    jLabelTotalPrice.setText(totalPrice.toString());
			    
			    if(jLabelFoodOrder.getText() != "" && jLabelChosenDeparture.getText() != "" && textPaneCustomer.getText().length() > 0) {
			    	btnBoka.setEnabled(true);
			    	System.out.println(textPaneCustomer.getText().length());
			    }
			    else {
			    	btnBoka.setEnabled(false);
			    }
			    		    
			}
		});
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"FLIGHT:", "FIRSTCLASS PLATSER", "PRIS(SEK)", "ECONOMYCLASS", "PRIS(SEK)"},
				{"SK161 G\u00F6teborg 14.45", new Integer(2), new Integer(20000), new Integer(2), new Integer(5000)},
				{"SK161 G\u00F6teborg 14.45", new Integer(2), new Integer(20000), new Integer(2), new Integer(5000)},
				{"SK161 G\u00F6teborg 14.45", new Integer(2), new Integer(20000), new Integer(2), new Integer(5000)},
				{"SK161 G\u00F6teborg 14.45", new Integer(2), new Integer(20000), new Integer(5), new Integer(5000)},
				{"SK161 G\u00F6teborg 14.45", new Integer(7), new Integer(20000), new Integer(2), new Integer(5000)},
				{"SK161 G\u00F6teborg 14.45", new Integer(2), new Integer(20000), new Integer(2), new Integer(5000)},
				{"SK162 G\u00F6teborg 16.45", new Integer(2), new Integer(20000), new Integer(4), new Integer(5000)},
				{"SK161 G\u00F6teborg 14.45", new Integer(1), new Integer(20000), new Integer(2), new Integer(5000)},
				{"SK161 G\u00F6teborg 18.45", new Integer(2), new Integer(20000), new Integer(2), new Integer(5000)},
				{"SK161 G\u00F6teborg 14.45", new Integer(0), new Integer(20000), new Integer(2), new Integer(5000)},
				{null, null, null, null, null},
			},
			new String[] {
				"Flight", "First Class", "Economy", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(220);
		table.getColumnModel().getColumn(0).setMinWidth(175);
		
		tableFoodMenu = new JTable();
		tableFoodMenu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableFoodMenu.setRowSelectionAllowed(false);
		tableFoodMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Integer priceFood = 0;
			    String foodName = "";
				
				int foodIndexRow = tableFoodMenu.rowAtPoint(e.getPoint());
			    int foodIndexColumn= tableFoodMenu.columnAtPoint(e.getPoint());
			    //System.out.println("mouseclick at: " + departureIndex + "," + flightClassIndex);
			    //String value = table.getValueAt(foodIndexRow, foodIndexColumn).toString();
			    
			    
			    
			    
			    if ( foodIndexColumn == 0 || foodIndexRow == 0) {   }
			    
			    else if (foodIndexColumn ==1 ) {
			    	foodName = tableFoodMenu.getValueAt(foodIndexRow, foodIndexColumn-1).toString();
			    	priceFood = (Integer) tableFoodMenu.getValueAt(foodIndexRow, 1);
			    	jLabelFoodOrder.setText(foodName);
			    	
			    }
			    
			    else if (foodIndexColumn ==2 ) {
			    	foodName = tableFoodMenu.getValueAt(foodIndexRow, foodIndexColumn-2).toString();
			    	priceFood = (Integer) tableFoodMenu.getValueAt(foodIndexRow, 2);
				    jLabelFoodOrder.setText(foodName);
			    	
				}
			    
			    Integer totalPrice = priceTicket+priceFood;
			    jLabelTotalPrice.setText(totalPrice.toString());
			    
			    if(jLabelFoodOrder.getText() != "" && jLabelChosenDeparture.getText() != "" && textPaneCustomer.getText().length() > 0) {
			    	btnBoka.setEnabled(true);
			    }
			    else {
			    	btnBoka.setEnabled(false);
			    }
			    	
			}
		});
		
		tableFoodMenu.setModel(new DefaultTableModel(
			new Object[][] {
				{"Maträtt:", "Pris Firstclass:", "Pris Economyclass:"},
				{"Papaya", new Integer(100), new Integer(50)},
				{"Cocosnöt", new Integer(150), new Integer(75)},
				{"Cocosnöt", new Integer(100), new Integer(50)},
				{"Papaya", new Integer(175), new Integer(25)},
				{"Cocosnöt", new Integer(200), new Integer(100)},
				{"Papaya", new Integer(199), new Integer(99)},
				{"Cocosnöt", new Integer(1000), new Integer(200)},
			},
			new String[] {
				"Namn:", "Pris:", "Is First Class:"
			}
		));
		tabbedPane.addTab("Food Menu", null, tableFoodMenu, null);
		frmCoconutAirwaysBooking.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frmCoconutAirwaysBooking.setJMenuBar(menuBar);
		
		JMenu mnStart = new JMenu("Start");
		menuBar.add(mnStart);
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		mnStart.add(mntmLoad);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnStart.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnStart.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
	}
}