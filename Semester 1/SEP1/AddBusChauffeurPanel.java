
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JRadioButton;


public class AddBusChauffeurPanel extends JPanel
{
   private JComboBox<String> typeComboBox;
   private JTextField capacityTextField;
   private JTextField regNoTextField;
   private JTextField nameTextField;
   private JTextField streetTextField;
   private JTextField noTextField;
   private JTextField cityTextField;
   private JTextField phoneTextField;
   private JTextField emailTextField;
   private JTextField idTextField;
   private JLabel addBusLabel;
   private JSeparator separator;
   private JLabel addChauffeurLabel;
   private JButton addBusButton;
   private JRadioButton miniBusRadioButton;
   private JRadioButton luxuryBusRadioButton;
   private JRadioButton partyBusRadioButton;
   private JButton addChauffeurButton;
   private JRadioButton oneDayTripsRadioButton;
   private JRadioButton travelsRadioButton;
   private JLabel lblChauffeursPrefferences;
   private ButtonListener buttonListener;
   private FileAdapter busAdapter;
   private FileAdapter chauffeurAdapter;
   /**
    * Create the panel.
    */
   public AddBusChauffeurPanel()
   {
      setLayout(null);
      buttonListener = new ButtonListener();
      busAdapter = new FileAdapter("garage.bin");
      chauffeurAdapter = new FileAdapter("chauffeurList.bin");
      
      addBusLabel = new JLabel("Add Bus");
      addBusLabel.setBounds(10, 11, 80, 14);
      add(addBusLabel);
      
      separator = new JSeparator();
      separator.setBounds(10, 155, 446, 2);
      add(separator);
      
      addChauffeurLabel = new JLabel("Add Chauffeur");
      addChauffeurLabel.setBounds(10, 168, 129, 14);
      add(addChauffeurLabel);
      
      typeComboBox = new JComboBox<>();
      typeComboBox.setBounds(10, 41, 142, 20);
      typeComboBox.addItem("Mini bus");
      typeComboBox.addItem("Luxury bus");
      typeComboBox.addItem("Party bus");
      add(typeComboBox);
      
      capacityTextField = new JTextField("Capacity");
      capacityTextField.setBounds(10, 72, 142, 20);
      add(capacityTextField);
      capacityTextField.setColumns(10);
      
      regNoTextField = new JTextField("Registration No");
      regNoTextField.setBounds(10, 103, 142, 20);
      add(regNoTextField);
      regNoTextField.setColumns(10);
      
      addBusButton = new JButton("Add Bus");
      addBusButton.setBounds(341, 55, 109, 55);
      addBusButton.addActionListener(buttonListener);
      add(addBusButton);
      
      nameTextField = new JTextField("Name");
      nameTextField.setBounds(10, 193, 86, 20);
      add(nameTextField);
      nameTextField.setColumns(10);
      
      streetTextField = new JTextField("Street");
      streetTextField.setBounds(106, 193, 86, 20);
      add(streetTextField);
      streetTextField.setColumns(10);
      
      noTextField = new JTextField("no");
      noTextField.setBounds(202, 193, 33, 20);
      add(noTextField);
      noTextField.setColumns(10);
      
      cityTextField = new JTextField("City");
      cityTextField.setBounds(245, 193, 86, 20);
      add(cityTextField);
      cityTextField.setColumns(10);
      
      phoneTextField = new JTextField("phone");
      phoneTextField.setBounds(10, 228, 86, 20);
      add(phoneTextField);
      phoneTextField.setColumns(10);
      
      emailTextField = new JTextField("E-mail");
      emailTextField.setBounds(106, 228, 129, 20);
      add(emailTextField);
      emailTextField.setColumns(10);
      
      idTextField = new JTextField("id");
      idTextField.setBounds(245, 228, 86, 20);
      add(idTextField);
      idTextField.setColumns(10);
      
      miniBusRadioButton = new JRadioButton("Mini bus");
      miniBusRadioButton.setSelected(true);
      miniBusRadioButton.setBounds(10, 280, 109, 23);
      add(miniBusRadioButton);
      
      luxuryBusRadioButton = new JRadioButton("Luxury bus");
      luxuryBusRadioButton.setSelected(true);
      luxuryBusRadioButton.setBounds(121, 280, 109, 23);
      add(luxuryBusRadioButton);
      
      partyBusRadioButton = new JRadioButton("Party bus");
      partyBusRadioButton.setSelected(true);
      partyBusRadioButton.setBounds(232, 280, 109, 23);
      add(partyBusRadioButton);
      
      addChauffeurButton = new JButton("Add Chauffeur");
      addChauffeurButton.setBounds(341, 193, 115, 55);
      addChauffeurButton.addActionListener(buttonListener);
      add(addChauffeurButton);
      
      oneDayTripsRadioButton = new JRadioButton("One-day Trips");
      oneDayTripsRadioButton.setSelected(true);
      oneDayTripsRadioButton.setBounds(10, 306, 109, 23);
      add(oneDayTripsRadioButton);
      
      travelsRadioButton = new JRadioButton("Travels");
      travelsRadioButton.setSelected(true);
      travelsRadioButton.setBounds(121, 306, 76, 23);
      add(travelsRadioButton);
      
      lblChauffeursPrefferences = new JLabel("Chauffeur's Prefferences");
      lblChauffeursPrefferences.setBounds(10, 259, 153, 14);
      add(lblChauffeursPrefferences);  
   } 
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(e.getSource() == addBusButton)
         {
            if(capacityTextField.getText().equals("Capacity") ||
                  regNoTextField.getText().equals("Registration No")){
               JOptionPane.showMessageDialog(null, "Some of the fields were not filled correctly, try again",
                     "Error saving bus", JOptionPane.ERROR_MESSAGE);
            } else {
            
            
            Bus temp = new Bus((String)typeComboBox.getSelectedItem(), Integer.parseInt(capacityTextField.getText()), regNoTextField.getText());
            Garage tempGarage = busAdapter.getAllBusses();
            tempGarage.addBus(temp);
            busAdapter.saveGarage(tempGarage);
            JOptionPane.showMessageDialog(null, "Bus Added to the Garage",
                  "Success", JOptionPane.INFORMATION_MESSAGE);
            }
         }
         
         if(e.getSource() == addChauffeurButton){
      
               
               if(nameTextField.getText().equals("Name") || nameTextField.getText().length() == 0
                     || phoneTextField.getText().equals("Phone")
                     || phoneTextField.getText().length() < 8
                     || emailTextField.getText().equals("e-mail")
                     || emailTextField.getText().length() < 5
                     || streetTextField.getText().equals("Street")
                     || streetTextField.getText().length() < 3
                     || noTextField.getText().equals("nr.")
                     || cityTextField.getText().equals("City")
                     || cityTextField.getText().length() < 3){
                  JOptionPane.showMessageDialog(null, "Some of the fields were not filled correctly, try again",
                        "Error saving chauffeur", JOptionPane.ERROR_MESSAGE);
               } else {
            Address tempadr = new Address(streetTextField.getText(), noTextField.getText(), cityTextField.getText());
            Chauffeur temp = new Chauffeur(nameTextField.getText(), tempadr, idTextField.getText(), emailTextField.getText(), phoneTextField.getText());
            ChauffeurList chauf = chauffeurAdapter.getAllChauffeurs();
            
            if(miniBusRadioButton.isSelected()){
               temp.addPreference("Mini bus");
            }
            if(luxuryBusRadioButton.isSelected()){
               temp.addPreference("Luxury bus");
            }
            if(partyBusRadioButton.isSelected()){
               temp.addPreference("Party bus");
            }
            if(oneDayTripsRadioButton.isSelected()){
               temp.addPreference("One-day trip");
            }
            if(travelsRadioButton.isSelected()){
               temp.addPreference("Travel");
            }
            
            chauf.addChauffeur(temp);  
            chauffeurAdapter.saveChauffeurs(chauf);
            JOptionPane.showMessageDialog(null, "Chauffeur Added",
                  "Success", JOptionPane.INFORMATION_MESSAGE);
               }
            
         }
      }
      
      
      
      
      
   }
}

   
