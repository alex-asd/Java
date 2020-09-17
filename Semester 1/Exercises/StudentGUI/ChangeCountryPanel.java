import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A GUI panel containing components for changing a students country.
 * @author Allan Henriksen
 * @version 1.0
 */ 
public class ChangeCountryPanel extends JPanel
{
   private StudentFileAdapter adapter;
   private MyButtonListener buttonListener;
    
   private JPanel inputPanel;
   
   private JLabel firstNameLabel;
   private JLabel lastNameLabel;
   private JLabel countryLabel;

   private JTextField firstNameField;
   private JTextField lastNameField;
   private JTextField countryField;
   
   private JButton updateButton;
   
   private JPanel comboPanel;
   private JComboBox<Student> studentBox;
   
   private ImageIcon logoIcon;
   private JLabel logoLabel;
   
   /**
    * Constructor initializing the GUI components
    * @param adapter StudentFileAdapter object used for retrieving and storing student information
    */
   public ChangeCountryPanel(StudentFileAdapter adapter)
   {
      this.adapter = adapter;
      buttonListener = new MyButtonListener();
      
      inputPanel = new JPanel();

      firstNameLabel = new JLabel("First Name:    ");
      firstNameField = new JTextField(15);
      firstNameField.setEditable(false);

      lastNameLabel = new JLabel("Last Name:    ");
      lastNameField = new JTextField(15);
      lastNameField.setEditable(false);

      countryLabel = new JLabel("Country:          ");
      countryField = new JTextField(15);

      updateButton = new JButton("Update");
      updateButton.addActionListener(buttonListener);

      inputPanel.add(firstNameLabel);
      inputPanel.add(firstNameField);

      inputPanel.add(lastNameLabel);
      inputPanel.add(lastNameField);

      inputPanel.add(countryLabel);
      inputPanel.add(countryField);

      add(inputPanel);
      inputPanel.setPreferredSize(new Dimension(280, 300));

      comboPanel = new JPanel();
            
      studentBox = new JComboBox<Student>();
      studentBox.addActionListener(buttonListener);
      comboPanel.add(studentBox);
            
      add(comboPanel);
      comboPanel.setPreferredSize(new Dimension(260, 300));
      
      inputPanel.add(updateButton);
      
      logoIcon = new ImageIcon("img/vialogoah.gif");
      logoLabel = new JLabel();
      logoLabel.setIcon(logoIcon);
      
      add(logoLabel);
      logoLabel.setPreferredSize(new Dimension(145, 65));
   }
   
   /**
    * Enables or disables editing of firstNameField and lastNameField.
    * @param bool if true then the fields will be editable, if false then they will not
    */
   public void changeEditableState(boolean bool)
   {
      firstNameField.setEditable(bool);
      lastNameField.setEditable(bool);
   }
   
   /**
    * Updates the studentBox JComboBox with information from the students file  
    */
  public void updateStudentBox()
   {
      int currentIndex = studentBox.getSelectedIndex();
      
      studentBox.removeAllItems();
      
      StudentList students = adapter.getAllStudents();
      for(int i = 0; i<students.size(); i++)
      {
         studentBox.addItem(students.get(i));
      }

      if(currentIndex==-1 && studentBox.getItemCount()>0)
      {
         studentBox.setSelectedIndex(0);
      }
      else
      {
         studentBox.setSelectedIndex(currentIndex);
      }
   }

   /*
    * Inner action listener class 
    * @author Allan Henriksen
    * @version 3.0
    */
   private class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == updateButton)
         {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String country = countryField.getText();

            if (country.equals(""))
            {
               country = "?";
            }

            adapter.changeCountry(firstName, lastName, country);
            updateStudentBox();
            countryField.setText("");
         }
         if (e.getSource() == studentBox)
         {
            if (studentBox.getSelectedItem() instanceof Student)
            {
               Student temp = (Student)studentBox.getSelectedItem();
               firstNameField.setText(temp.getFirstName());
               lastNameField.setText(temp.getLastName());
            }
         }
      }
   }
}
