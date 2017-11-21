package se.coconutflightbooking.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class coconutTC implements Runnable {
  private JFrame frame = new JFrame("Please accept Terms & Conditions ('T&Cs')");
  private String longMessage = "Preorder your meal deal online - Terms and Conditions\r\n" + 
  		"\r\n" + 
  		"Pre-order Items - Terms and Conditions\r\n" + 
  		"\r\n" + 
  		"\r\n" + 
  		"Headline Terms and Conditions\r\n" + 
  		"\r\n" + 
  		"Pre-order items for your flight in advance of flying\r\n" + 
  		"\r\n" + 
  		"    Pre-order items online once you have booked your flight with us (subject to availability and whilst stocks last).\r\n" + 
  		"    Present your pre-order confirmation to a member of cabin crew once on board your flight.\r\n" + 
  		"    Pre-order quantity restrictions may apply.\r\n" + 
  		"    Pre-ordered items will only be made available for the selected flight for which they are purchased.\r\n" + 
  		"    Refunds or substitutions for any pre-ordered Items will only be given at CocoNut’s sole discretion.\r\n" + 
  		"    Pre-ordered items are non-transferable and will only be given to the passenger for whom the pre-ordered items have been purchased during the specified flight for which they have been purchased.\r\n" + 
  		"\r\n" + 
  		"\r\n" + 
  		"Full Terms and Conditions\r\n" + 
  		"\r\n" + 
  		"Pre-order items for your flight in advance of flying\r\n" + 
  		"\r\n" + 
  		"    Definitions\r\n" + 
  		"\r\n" + 
  		"\r\n" + 
  		"For the purpose of these Terms and Conditions (“T&Cs”), the following words shall have the following meanings:\r\n" + 
  		"\r\n" + 
  		"    “Booker” shall refer to the lead passenger in whose name the flight booking has been made;\r\n" + 
  		"    “CocoNut” shall refer to CocoNut Airline Company Limited;\r\n" + 
  		"    “Items” shall refer to selected food, drinks, meal deals, boutique and/or duty free items (including, without limitation, tobacco, cigarettes and litre spirits) as advertised on CocoNut’s product selection page and in the on-board section of the CocoNut Inflight magazine, which may be pre-ordered online in advance of a Selected Flight (subject to availability);\r\n" + 
  		"    “Selected Flights” shall refer to selected flights (in CocoNut’s sole discretion) where the Booker is provided with access to pre-order Items to enjoy on-board the CocoNut flights the Booker has booked;\r\n" + 
  		"    “Passenger” shall refer to the Booker and, if appropriate, any other passenger on the Booker’s booking; and\r\n" + 
  		"    “Pre-order Confirmation” shall refer to the confirmation that Passengers will receive following their purchase of pre-ordered Items after booking a Selected Flight with CocoNut, which may be presented on-board the Selected Flight in exchange for the pre-ordered Items.\r\n" + 
  		"\r\n" + 
  		" \r\n" + 
  		"Availability of Pre-ordered Items and Use of the Pre-order Confirmation\r\n" + 
  		"\r\n" + 
  		"    The Booker on Selected Flights will be invited by email to pre-order Items to enjoy on-board the CocoNut flights they have booked.\r\n" + 
  		"    Items can only be pre-ordered by the Booker. When there is more than one Passenger on a single booking, the Booker can pre-order Items on behalf of the other Passengers on that same booking.\r\n" + 
  		"    Details of the Items which may be pre-ordered are set out on CocoNut’s product selection page displayed to the Booker.\r\n" + 
  		"    After the pre-order transaction has been processed and payment has been received by CocoNut, the Booker will receive a Pre-order Confirmation by email which will specify the:\r\n" + 
  		"            Passenger’s details;\r\n" + 
  		"            Items that have been pre-ordered; and\r\n" + 
  		"            Selected Flight for which the Items have been pre-ordered.\r\n" + 
  		"    Pre-ordered Items are non-transferable. A Pre-order Confirmation may only be exchanged on board the Selected Flight to which it relates for the Items that have been pre-ordered by the Passenger for whom the Items have been pre-ordered.\r\n" + 
  		"    Refunds or substitutions for any pre-ordered Items will only be given at CocoNut’s sole discretion.\r\n" + 
  		"    All pre-ordered Items are strictly subject to availability and are not guaranteed. CocoNut reserves the right to substitute or cancel the available Items and/or the list of Selected Flights in respect of which Items may be pre-ordered. If CocoNut changes the ability to redeem pre-ordered Items on a Selected Flight after Items have been pre-ordered and paid for, CocoNut will reimburse the amount paid in accordance with clause 16 below.\r\n" + 
  		"    The name on the Pre-order Confirmation must match the name on the boarding pass of the Passenger who intends to redeem the Pre-order Confirmation. When the Booker pre-orders Items on behalf of other Passengers on that same booking, the Booker must ensure that they have entered the names of the other Passengers correctly. CocoNut reserves the right to inspect boarding passes to ensure that the correct Passenger is using the correct Pre-order Confirmation.\r\n" + 
  		"    CocoNut reserves the right to refuse to allow exchange of a Pre-order Confirmation on board the Selected Flight if its staff have reasonable suspicion that the Passenger has fraudulently attempted to duplicate a Pre-order Confirmation, or otherwise seek to disadvantage CocoNut by misuse of this pre-order scheme.\r\n" + 
  		"    CocoNut reserves the right to refuse to accept Pre-order Confirmations which have been defaced or destroyed, and/or are illegible.\r\n" + 
  		"    CocoNut will retain the Pre-order Confirmation after it has been exchanged.\r\n" + 
  		"\r\n" + 
  		" \r\n" + 
  		"\r\n" + 
  		"Refunds\r\n" + 
  		"\r\n" + 
  		"    A Pre-order Confirmation cannot be refunded if not used on the Selected Flight for which the Items have been pre-ordered, regardless of whether the Passenger flies or not. Subject to clauses 13, 14 and 15 below, a Passenger who misses their flight or does not use their Pre-order Confirmation for any reason within or outside of their control will not receive a refund for their unused Pre-order Confirmation.\r\n" + 
  		"    Where CocoNut cancels a Selected Flight or the Selected Flight is cancelled due to an event of major disruption, this will constitute a reason for refund under clause 16.\r\n" + 
  		"    If CocoNut is unable to provide any of the pre-ordered Items on a Selected Flight, the Booker can apply for a refund in respect of the pre-ordered Items that they have purchased which are affected by this in accordance with clause 16.\r\n" + 
  		"    If the Booker has pre-ordered Items for a Selected Flight but then rebooks that Selected Flight for a later date, it is not possible to transfer the Pre-order Confirmation for those Items to the rebooked flight. Instead, the Booker will be permitted to apply for a refund in accordance with clause 16. The Booker must separately pre-order Items for the rebooked flight if they wish to do so.\r\n" + 
  		"    If the Booker is eligible for refund under these T&Cs, the Booker should contact CocoNut’s inflight supplier by email at refunds@gategroup.com.\r\n" + 
  		"    Refunds can only be claimed by the Booker on behalf of other Passengers on the Booking. \r\n" + 
  		"\r\n" + 
  		" \r\n" + 
  		"\r\n" + 
  		"Age Restrictions\r\n" + 
  		"\r\n" + 
  		"    Subject to clause 19 below, Passengers travelling on a Selected Flight who are younger than 18 years of age may exchange a Pre-order Confirmation if given permission by the Booker.\r\n" + 
  		"    Alcohol and duty free Items (including, without limitation, tobacco, cigarettes and litre spirits) may only be pre-ordered by Passengers who are 18 years old or above.\r\n" + 
  		"\r\n" + 
  		" \r\n" + 
  		"\r\n" + 
  		"Use of Your Personal Data\r\n" + 
  		"\r\n" + 
  		"    By pre-ordering Items, Passengers agree to CocoNut processing their data in accordance with CocoNut’s Privacy Policy available at www.coconut.com/privacypolicy. CocoNut may also pass the Passengers’ information to trusted third parties to enable them to market or provide services.\r\n" + 
  		"\r\n" + 
  		" \r\n" + 
  		"\r\n" + 
  		"Governing Law and Other Provisions\r\n" + 
  		"\r\n" + 
  		"    These T&Cs are subject to English law and the non-exclusive jurisdiction of English Courts.\r\n" + 
  		"    These T&Cs are also subject to the existing terms and conditions for CocoNut’s Bistro magazine, which shall apply to all sales of Items.";

  public static void main(String[] args)
  {
    coconutTC example = new coconutTC();
    SwingUtilities.invokeLater(example);
  }

  public void run()
  {
    // start building a jframe
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(450, 300));

    // add a button to the jframe
    JButton button = new JButton("Click Me");
    button.addActionListener(new ShowDialogListener());
    frame.getContentPane().add(button);

    // display the jframe
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
  
  /**
   * Our button listener. Show a scrolling text area in a 
   * JOptionPane showMessageDialog dialog.
   */
  class ShowDialogListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      // create a JTextArea
      JTextArea textArea = new JTextArea(36, 72);
      textArea.setText(longMessage);
      textArea.setEditable(false);
      
      // wrap a scrollpane around it
      JScrollPane scrollPane = new JScrollPane(textArea);
      
      // display them in a message dialog
      JOptionPane.showMessageDialog(frame, scrollPane);
    }
  }
}     

//public class coconutTC {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}


