import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MakeReservationPanel extends JPanel
{
   private JTextField dateFieldFrom;
   private JTextField dateFieldTo;
   private JTextField clockFieldFrom;
   private JTextField clockFieldTo;
   private JTextField locationField;
   private JTextField nameFieldCust;
   private JTextField phoneFieldCust;
   private JTextField emailFieldCust;
   private JTextField streetFieldCust;
   private JTextField nrFieldCust;
   private JTextField cityFieldCust;
   private JTextField compenyField;
   private JTextField nameFieldPass;
   private JTextField streetFieldPass;
   private JTextField nrFieldPass;
   private JTextField cityFieldPass;
   private JTextField birthdayFieldPass;
   
   private JLabel passengerLabel;
   private JLabel customerLabel;
   private JLabel typeLabel;
   private JLabel busLabel;
   private JLabel chauffeurLabel;
   private JLabel fromLabel;
   private JLabel toLabel;
   private JLabel locationLabel;
   
   private JCheckBox isAPassenger;
   
   private JButton addCustomer;
   private JButton done;
   private JButton addPassenger;
   private JButton addDestination;
   
   private JSeparator separator;
   private JSeparator separator_1;
   
   private JComboBox<String> typeComboBox;
   private JComboBox<Bus> busComboBox;
   private JComboBox<Chauffeur> chauffeurComboBox;
   
   private ButtonListener buttonListener;
   
   private FileAdapter customerAdapter;
   private FileAdapter busAdapter;
   /**
    * Create the panel.
    */
   public MakeReservationPanel()
   {
      setLayout(null);
      
      customerAdapter = new FileAdapter("customers.bin");
      busAdapter = new FileAdapter("garage.bin");
      
      buttonListener = new ButtonListener();
      
      fromLabel = new JLabel("Departure");
      fromLabel.setBounds(10, 11, 97, 14);
      add(fromLabel);
      
      toLabel = new JLabel("Arrival");
      toLabel.setBounds(139, 11, 86, 14);
      add(toLabel);
      
      dateFieldFrom = new JTextField();
      dateFieldFrom.setText("dd/mm/yy");
      dateFieldFrom.setBounds(10, 31, 86, 20);
      add(dateFieldFrom);
      dateFieldFrom.setColumns(10);
      
      dateFieldTo = new JTextField();
      dateFieldTo.setText("dd/mm/yy");
      dateFieldTo.setColumns(10);
      dateFieldTo.setBounds(139, 31, 86, 20);
      add(dateFieldTo);
      
      clockFieldFrom = new JTextField();
      clockFieldFrom.setText("hh/mm");
      clockFieldFrom.setBounds(10, 61, 46, 20);
      add(clockFieldFrom);
      clockFieldFrom.setColumns(10);
      
      clockFieldTo = new JTextField();
      clockFieldTo.setText("hh/mm");
      clockFieldTo.setColumns(10);
      clockFieldTo.setBounds(139, 61, 46, 20);
      add(clockFieldTo);
      
      locationLabel = new JLabel("location");
      locationLabel.setBounds(270, 11, 46, 14);
      add(locationLabel);
      
      locationField = new JTextField();
      locationField.setBounds(270, 31, 86, 20);
      add(locationField);
      locationField.setColumns(10);
      
      typeComboBox = new JComboBox<String>();
      typeComboBox.addItem("One-day trip");
      typeComboBox.addItem("Travel");
      typeComboBox.setBounds(10, 130, 86, 20);
      add(typeComboBox);
      
      busComboBox = new JComboBox<Bus>();
      
      Garage showBusses = new Garage();
      showBusses = busAdapter.getAllBusses();
      for (int i = 0; i < showBusses.size(); i++) 
      {
        busComboBox.addItem(showBusses.getBusByIndex(i));
      }
      
      busComboBox.setBounds(139, 130, 109, 20);
      add(busComboBox);
      
      chauffeurComboBox = new JComboBox<Chauffeur>();
      chauffeurComboBox.setBounds(270, 130, 142, 20);
      add(chauffeurComboBox);
      
      typeLabel = new JLabel("Type");
      typeLabel.setBounds(10, 105, 46, 14);
      add(typeLabel);
      
      busLabel = new JLabel("Bus");
      
      busLabel.setBounds(139, 105, 46, 14);
      add(busLabel);
      
      chauffeurLabel = new JLabel("Chauffeur");
      chauffeurLabel.setBounds(270, 105, 69, 14);
      add(chauffeurLabel);
      
      separator = new JSeparator();
      separator.setBounds(10, 161, 468, 2);
      add(separator);
      
      customerLabel = new JLabel("Customer");
      customerLabel.setBounds(10, 174, 86, 14);
      add(customerLabel);
      
      nameFieldCust = new JTextField();
      nameFieldCust.setText("Name");
      nameFieldCust.setBounds(10, 199, 86, 20);
      add(nameFieldCust);
      nameFieldCust.setColumns(10);
      
      phoneFieldCust = new JTextField();
      phoneFieldCust.setText("phone");
      phoneFieldCust.setBounds(106, 199, 86, 20);
      add(phoneFieldCust);
      phoneFieldCust.setColumns(10);
      
      emailFieldCust = new JTextField();
      emailFieldCust.setText("e-mail");
      emailFieldCust.setBounds(206, 199, 86, 20);
      add(emailFieldCust);
      emailFieldCust.setColumns(10);
      
      streetFieldCust = new JTextField();
      streetFieldCust.setText("Street");
      streetFieldCust.setBounds(10, 230, 86, 20);
      add(streetFieldCust);
      streetFieldCust.setColumns(10);
      
      nrFieldCust = new JTextField();
      nrFieldCust.setText("nr.");
      nrFieldCust.setBounds(106, 230, 46, 20);
      add(nrFieldCust);
      nrFieldCust.setColumns(10);
      
      cityFieldCust = new JTextField();
      cityFieldCust.setText("City");
      cityFieldCust.setBounds(162, 230, 86, 20);
      add(cityFieldCust);
      cityFieldCust.setColumns(10);
      
      compenyField = new JTextField();
      compenyField.setText("Company");
      compenyField.setBounds(10, 261, 142, 20);
      add(compenyField);
      compenyField.setColumns(10);
      
      addCustomer = new JButton("Add Customer");
      addCustomer.setBounds(349, 214, 129, 52);
      addCustomer.addActionListener(buttonListener);
      add(addCustomer);
      
      addDestination = new JButton("Add Destination");
      addDestination.setBounds(349, 61, 129, 52);
      add(addDestination);
      
      separator_1 = new JSeparator();
      separator_1.setBounds(10, 300, 468, 2);
      add(separator_1);
      
      passengerLabel = new JLabel("Passenger");
      passengerLabel.setBounds(10, 307, 86, 14);
      add(passengerLabel);
      
      nameFieldPass = new JTextField();
      nameFieldPass.setText("Name");
      nameFieldPass.setColumns(10);
      nameFieldPass.setBounds(10, 332, 86, 20);
      add(nameFieldPass);
      
      streetFieldPass = new JTextField();
      streetFieldPass.setText("Street");
      streetFieldPass.setColumns(10);
      streetFieldPass.setBounds(106, 332, 86, 20);
      add(streetFieldPass);
      
      nrFieldPass = new JTextField();
      nrFieldPass.setText("nr.");
      nrFieldPass.setColumns(10);
      nrFieldPass.setBounds(202, 332, 46, 20);
      add(nrFieldPass);
      
      cityFieldPass = new JTextField();
      cityFieldPass.setText("City");
      cityFieldPass.setColumns(10);
      cityFieldPass.setBounds(258, 332, 86, 20);
      add(cityFieldPass);
      
      birthdayFieldPass = new JTextField();
      birthdayFieldPass.setText("Birthday(dd/mm/yy)");
      birthdayFieldPass.setColumns(10);
      birthdayFieldPass.setBounds(10, 368, 129, 20);
      add(birthdayFieldPass);
      
      addPassenger = new JButton("Add Passenger");

      addPassenger.setBounds(349, 316, 129, 52);
      add(addPassenger);
      
      isAPassenger = new JCheckBox("Is a passenger");
      isAPassenger.setBounds(172, 260, 144, 23);
      add(isAPassenger);
      
      done = new JButton("DONE");
      done.setBounds(162, 380, 130, 23);
      done.addActionListener(buttonListener);
      add(done);

   }
   
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
         
//       if (e.getSource() == addDestination) {
//          
//          
//          
//          Trip tempTrip = new Trip();
//          
//          if(nameFieldCust.getText().equals("Name") || nameFieldCust.getText().length() == 0
//                || phoneFieldCust.getText().equals("Phone")
//                || phoneFieldCust.getText().length() < 8
//                || emailFieldCust.getText().equals("e-mail")
//                || emailFieldCust.getText().length() < 5
//                || streetFieldCust.getText().equals("Street")
//                || streetFieldCust.getText().length() < 3
//                || nrFieldCust.getText().equals("nr.")
////                 || number == (int)number
//                || cityFieldCust.getText().equals("City")
//                || cityFieldCust.getText().length() < 3)
//             JOptionPane.showMessageDialog(null, "Some of the fields were not filled correctly, try again",
//                   "Error saving customer", JOptionPane.ERROR_MESSAGE);
//          else
//          {
//             Address tempAddr = new Address(streetFieldCust.getText(), nrFieldCust.getText(), cityFieldCust.getText());
//             Customer tempCust = new Customer(nameFieldCust.getText(), tempAddr, phoneFieldCust.getText(), emailFieldCust.getText());
//             tempCustList.addCustomer(tempCust);
//             customerAdapter.saveCustomers(tempCustList);
//          }
//       }
         
         
         
         if (e.getSource() == addCustomer) {
//          String strNumber = nrFieldCust.getText();
//          int number = Integer.parseInt(strNumber);
            
            CustomerList tempCustList = new CustomerList();
            tempCustList = customerAdapter.getAllCustomers();
            
            if(nameFieldCust.getText().equals("Name") || nameFieldCust.getText().length() == 0
                  || phoneFieldCust.getText().equals("Phone")
                  || phoneFieldCust.getText().length() < 8
                  || emailFieldCust.getText().equals("e-mail")
                  || emailFieldCust.getText().length() < 5
                  || streetFieldCust.getText().equals("Street")
                  || streetFieldCust.getText().length() < 3
                  || nrFieldCust.getText().equals("nr.")
//                || number == (int)number
                  || cityFieldCust.getText().equals("City")
                  || cityFieldCust.getText().length() < 3)
               JOptionPane.showMessageDialog(null, "Some of the fields were not filled correctly, try again",
                     "Error saving customer", JOptionPane.ERROR_MESSAGE);
            else
            {
               Address tempAddr = new Address(streetFieldCust.getText(), nrFieldCust.getText(), cityFieldCust.getText());
               Customer tempCust = new Customer(nameFieldCust.getText(), tempAddr, phoneFieldCust.getText(), emailFieldCust.getText());
               tempCustList.addCustomer(tempCust);
               customerAdapter.saveCustomers(tempCustList);
            }
         }
         
         if (e.getSource() == done)
         {
            JOptionPane.showMessageDialog(null, "Enter more");
         }
      }
   }
}
