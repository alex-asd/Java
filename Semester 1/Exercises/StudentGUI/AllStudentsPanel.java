import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * A GUI panel containing components for displaying a list of students.
 * @author Allan Henriksen
 * @version 1.0
 */  
public class AllStudentsPanel extends JPanel
{
   private StudentFileAdapter adapter;
   private MyButtonListener buttonListener;
   
   private JTextArea allStudentsArea;
   private JScrollPane allStudentsScrollPane;
   
   private JButton getButton;
   
   /**
    * Constructor initializing the GUI components
    * @param adapter StudentFileAdapter object used for retrieving and storing student information
    */
   public AllStudentsPanel(StudentFileAdapter adapter)
   {
      this.adapter = adapter;
      buttonListener = new MyButtonListener();
      
      allStudentsArea = new JTextArea(20, 50);
      allStudentsArea.setEditable(false);

      allStudentsScrollPane = new JScrollPane(allStudentsArea);
      allStudentsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

      add(allStudentsScrollPane);

      getButton = new JButton("Get Students");
      getButton.addActionListener(buttonListener);
      
      add(getButton);
   }
   
   /**
    * Enables or disables editing of the allStudentsArea.
    * @param bool if true then the area will be editable, if false then it will not
    */
   public void changeEditableState(boolean bool)
   {
     allStudentsArea.setEditable(bool);
   }
   
   /**
    * Updates the allStudentsArea JTextArea with information from the students file
    */
   public void updateStudentArea()
   {
      StudentList students = adapter.getAllStudents();
      allStudentsArea.setText(students.toString());
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
         if (e.getSource() == getButton)
         {
            updateStudentArea();
         }
      }
   }
}
