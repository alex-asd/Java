import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;


public class ChangeCancelPanel extends JPanel
{
   private JTextField dateTextField;
   private JTextField nameTextField;
   private JCheckBox cancelCheckBox;
   private JLabel nameLabel;
   private JLabel dateLabel;
   private JButton btnNewButton;

   /**
    * Create the panel.
    */
   public ChangeCancelPanel()
   {
      setLayout(null);
      
      dateTextField = new JTextField();
      dateTextField.setText("dd/mm/yy");
      dateTextField.setBounds(10, 31, 110, 20);
      add(dateTextField);
      dateTextField.setColumns(10);
      
      dateLabel = new JLabel("Reservation date");
      dateLabel.setBounds(10, 11, 110, 14);
      add(dateLabel);
      
      nameTextField = new JTextField();
      nameTextField.setBounds(10, 80, 110, 20);
      add(nameTextField);
      nameTextField.setColumns(10);
      
      nameLabel= new JLabel("Customer name");
      nameLabel.setBounds(10, 62, 110, 14);
      add(nameLabel);
      
      cancelCheckBox = new JCheckBox("Cancel reservation");
      cancelCheckBox.setBounds(6, 107, 131, 23);
      add(cancelCheckBox);
      
      btnNewButton = new JButton("Done");
      btnNewButton.setBounds(10, 183, 110, 74);
      add(btnNewButton);

   }

}
