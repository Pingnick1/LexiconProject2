package se.coconutflightbooking.gui;


import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class coconutGUI extends JFrame
{
  public static void main(String [] args)
  {
      new coconutGUI();
      new coconutGUI();
  }
  private JButton buttonOK;   
 // private JRadioButton add, delete, print;
  private JRadioButton add, delete, print, deadlines;
 // private JCheckBox sort, deadlines, pluspoint;
  private JCheckBox sort, pluspoint;
  public coconutGUI()
  {
      this.setSize(520,200);
      this.setTitle("Vad vill du göra ?");
      this.setDefaultCloseOperation(
          JFrame.EXIT_ON_CLOSE);
      JPanel mainPanel = new JPanel();   
      JPanel sizePanel = new JPanel();   
      Border b1 =   
          BorderFactory.createTitledBorder("Boka flygning");
      sizePanel.setBorder(b1);   
      ButtonGroup sizeGroup = new ButtonGroup();   
      add = new JRadioButton("Boka flygning");   
      add.setSelected(true);
      sizePanel.add(add);
      sizeGroup.add(add);
      delete = new JRadioButton("Boka luftiga förfriskningar ");   
      sizePanel.add(delete);
      sizeGroup.add(delete);
      deadlines = new JRadioButton("Kolla bokningsläge");
      sizePanel.add(deadlines);
      sizeGroup.add(deadlines);
      print = new JRadioButton("Avsluta");   
      sizePanel.add(print);
      sizeGroup.add(print);

      mainPanel.add(sizePanel);   
      JPanel topPanel = new JPanel();
      Border b2 =
          BorderFactory.createTitledBorder(
              "övrigt");
      topPanel.setBorder(b2);
      sort = new JCheckBox("Första klass");   
      topPanel.add(sort);
  //    deadlines = new JCheckBox("Kolla bokningsläge");
  
  //   topPanel.add(deadlines);
      pluspoint = new JCheckBox("CocoClub member");
      topPanel.add(pluspoint);
      mainPanel.add(topPanel);   
      buttonOK = new JButton("OK");
      buttonOK.addActionListener(e -> buttonOKClick() );
      mainPanel.add(buttonOK);
      this.add(mainPanel);   
      this.setVisible(true);
  }

  public void buttonOKClick()
  {
      String tops = "";   
      if (sort.isSelected())
          tops += "Flyga i First Class\n";
      if (deadlines.isSelected())
          tops += "Kolla bokningsläge\n";
      if (pluspoint.isSelected())
          tops += "Registrera CocoNut-poäng\n";
      String msg = "Du ville ";   
      if (add.isSelected())
          msg += "lägga till en flight och ";
      if (delete.isSelected())
          msg += "boka luftiga förfriskningar ";
      if (print.isSelected())
          msg += "avsluta och ";
      if (tops.equals(""))   
          msg += "inget mer.";
      else
          msg += "med följande tillägg:\n"
              + tops;
      JOptionPane.showMessageDialog(   
          buttonOK, msg, "",
          JOptionPane.INFORMATION_MESSAGE);

      sort.setSelected(false);   
//    deadlines.setSelected(false);
      pluspoint.setSelected(false);
      add.setSelected(true);
  }
}
