package se.coconutflightbooking.gui; 

import java.awt.EventQueue;

import javax.swing.JFrame;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import se.coconutflightbooking.AirPlane;
import se.coconutflightbooking.AirPlaneListHandler;
import se.coconutflightbooking.AirPlaneStatus;
import se.coconutflightbooking.Departure;
import se.coconutflightbooking.DepartureListHandler;
import se.coconutflightbooking.FoodMenuItem;
import se.coconutflightbooking.FoodMenuListHandler;
import se.coconutflightbooking.FoodOrderItem;
import se.coconutflightbooking.FoodOrderListHandler;
import se.coconutflightbooking.Reservation;
import se.coconutflightbooking.ReservationListHandler;
import se.coconutflightbooking.database.OurDatabasConnection;
import se.coconutflightbooking.exceptions.AirPlaneNotFoundException;

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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

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
	
	private JTable tableFoodMenu;
	
	//Our variables:
	public Integer costTicket = 0;
	public Integer costFood = 0;
	public Integer totalCost = 0;
	
	private OurDatabasConnection ourDataBasConnection = new OurDatabasConnection();
	
	private AirPlaneListHandler airPlaneHandler = new AirPlaneListHandler();
	private DepartureListHandler departuresListHandler = new DepartureListHandler();
	private ReservationListHandler reservationListHandler = new ReservationListHandler();
	private FoodOrderListHandler foodOrderListHandler = new FoodOrderListHandler();
	private FoodMenuListHandler foodMenuListHandler = new FoodMenuListHandler();
	
	
	public Object[][] getDepartures(){		
		//System.out.println( airPlaneHandler);
		HashMap<String, Departure> result = TestWindows.this.departuresListHandler.getDepartureList();
		int rows = result.size();
		Object[][] returnArray = new Object[rows+1][6];
		
		for(int rowCounter = 1; rowCounter < rows; ) {
			 
			Object[] headerArray = {"DATE:", "DESTINATION", "FIRSTCLASS PLATSER", "PRIS(SEK)", "ECONOMYCLASS", "PRIS(SEK)"};
			returnArray[0] = headerArray;
		
		
			for(Departure departure : result.values()) {
				Object[] columnArray = new Object[6];
				columnArray[0] = departure.getDepartureDateTime().toString();
				columnArray[1] = departure.getDestinationName().toString();
			
				try {
					columnArray[2] = this.airPlaneHandler.getAirPlane(departure.getAirPlaneBoundToDeparture()).getNrOfFirstClass();// .toString();
					//System.out.println("Letar efter flygplan:" + departure.getAirPlaneBoundToDeparture());
				} catch (AirPlaneNotFoundException e) {
					System.out.println("AirPlaneNotFoundException");
					//System.out.println("Letar efter flygplan:" + departure.getAirPlaneBoundToDeparture());
					//e.printStackTrace();
				}
				columnArray[3] = departure.getFirstClassTicketPrice();//.toString();
			
				try {
					columnArray[4] = this.airPlaneHandler.getAirPlane(departure.getAirPlaneBoundToDeparture()).getNrOfEconomcSeats(); //.toString();
					//System.out.println("Letar efter flygplan:" + departure.getAirPlaneBoundToDeparture());
				} catch (AirPlaneNotFoundException e) {
					System.out.println("AirPlaneNotFoundException");
					//System.out.println("Letar efter flygplan:" + departure.getAirPlaneBoundToDeparture());
					//e.printStackTrace();
				}
				columnArray[5] = departure.getEconomyClassTicketPrice();
			
				returnArray[rowCounter] = columnArray;
				rowCounter++;
			}
			
		}
		
		return returnArray;
	}

	
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

	
	public void upDateFromDB() {
		departuresListHandler.setDepartureList(ourDataBasConnection.getDepartures());
		table.repaint();
		repaint();
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		airPlaneHandler.setOurAirPlaneList(ourDataBasConnection.getAirPlanes());
		//HashMap<String, AirPlane> airPlaneList = ourDataBasConnection.getAirPlanes();
		
		departuresListHandler.setDepartureList(ourDataBasConnection.getDepartures());
		
		reservationListHandler.setReservationList(ourDataBasConnection.getReservations());
		
		foodOrderListHandler.setOurFoodOrderList(ourDataBasConnection.getFoodOrders());
		
		foodMenuListHandler.setOurFoodMenuList(ourDataBasConnection.getFoodMenu());
		
		//HashMap<String, FoodMenuItem> foodMenu = ourDataBasConnection.getFoodMenu();
		//HashMap<String, Reservation> reservationList = ourDataBasConnection.getReservations();
		//HashMap<String, FoodOrderItem> foodOrderList = ourDataBasConnection.getFoodOrders();
		
		//departuresListHandler.setOurAirPlaneList(airPlaneList);
		
		
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
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TestWindows.this.upDateFromDB();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmCoconutAirwaysBooking.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 643, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
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
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(btnUpdate)
									.addGap(18)))
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
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBoka)
						.addComponent(btnUpdate))
					.addGap(99))
		);
		
		table = new JTable();
		tabbedPane.addTab("Departures/Seats", null, table, null);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				upDateFromDB();
				//Integer priceTicket = 0;
				//Integer priceFood = 0;
			    String departure = "";
				
				int departureIndex = table.rowAtPoint(e.getPoint());
			    int flightClassIndex = table.columnAtPoint(e.getPoint());
			    
			    if ( flightClassIndex == 0 || departureIndex == 0) {   }
			    else if (flightClassIndex ==2 || flightClassIndex == 3) {
			    	//System.out.println("Flight:" + departureIndex + ", Första klass, value:" + value);
			    	departure = table.getValueAt(departureIndex, 0).toString();
			    	TestWindows.this.costTicket = (Integer) table.getValueAt(departureIndex, 3);
			    	
			    	jLabelChosenDeparture.setText(departure);
			    	jLabelChosenClass.setText("Första klass");
			    	jLabelTicketPrice.setText(TestWindows.this.costTicket.toString());
			    	
			    }
			    else if (flightClassIndex ==4 || flightClassIndex == 5 ) {
			    	departure = table.getValueAt(departureIndex, 0).toString();
			    	TestWindows.this.costTicket = (Integer) table.getValueAt(departureIndex, 5);
			    	
			    	jLabelChosenDeparture.setText(departure);
			    	jLabelChosenClass.setText("Ekonomiklass");
			    	jLabelTicketPrice.setText(TestWindows.this.costTicket.toString());
				}
			    TestWindows.this.totalCost = TestWindows.this.costTicket + TestWindows.this.costFood;
			    jLabelTotalPrice.setText(TestWindows.this.totalCost.toString());
			    
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
				this.getDepartures(),
				new String[] {
						"Date", "Destination", "First Class", "Economy", "New column", "New column"
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
			    //Integer priceTicket = 0;
				
				int foodIndexRow = tableFoodMenu.rowAtPoint(e.getPoint());
			    int foodIndexColumn= tableFoodMenu.columnAtPoint(e.getPoint());
			    //System.out.println("mouseclick at: " + departureIndex + "," + flightClassIndex);
			    //String value = table.getValueAt(foodIndexRow, foodIndexColumn).toString();
			    
			    
			    
			    
			    if ( foodIndexColumn == 0 || foodIndexRow == 0) {   }
			    
			    else if (foodIndexColumn ==1 ) {
			    	foodName = tableFoodMenu.getValueAt(foodIndexRow, foodIndexColumn-1).toString();
			    	TestWindows.this.costFood = (Integer) tableFoodMenu.getValueAt(foodIndexRow, 1);
			    	jLabelFoodOrder.setText(foodName);
			    	jLabelFoodCost.setText(TestWindows.this.costFood.toString());
			    	
			    }
			    
			    else if (foodIndexColumn ==2 ) {
			    	foodName = tableFoodMenu.getValueAt(foodIndexRow, foodIndexColumn-2).toString();
			    	TestWindows.this.costFood = (Integer) tableFoodMenu.getValueAt(foodIndexRow, 2);
				    jLabelFoodOrder.setText(foodName);
				    jLabelFoodCost.setText(TestWindows.this.costFood.toString());
				}
			    
			    TestWindows.this.totalCost = TestWindows.this.costTicket + TestWindows.this.costFood;
			    jLabelTotalPrice.setText(TestWindows.this.totalCost.toString());
			    
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
		
		JTabbedPane tabBokningar = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Bokningar", null, tabBokningar, null);
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