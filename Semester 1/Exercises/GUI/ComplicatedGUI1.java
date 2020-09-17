import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ComplicatedGUI1 extends JFrame
{
   private JPanel headerPanel;
 
   private JPanel mainPanel;
   private JPanel textPanel;
   private JPanel changePanel;
   private JPanel personPanel;
   private JPanel personNamePanel;
   private JPanel personPhonePanel;
   private JPanel personAgePanel;

   private JPanel footerPanel;
   
   private JLabel headerLabel;
   
   private JLabel textLabel1;
   private JLabel textLabel2;
   
   private JCheckBox boldCheckBox;
   private JCheckBox italicCheckBox;
   
   private JRadioButton redRadioButton;
   private JRadioButton greenRadioButton;
   private JRadioButton blueRadioButton;
   private JRadioButton normalRadioButton;
   private ButtonGroup colorGroup;
   
   private JLabel nameLabel;
   private JLabel phoneLabel;
   private JLabel ageLabel;
   
   private JTextField nameField;
   private JTextField phoneField;
   private JTextField ageField;
   
   private JButton exitButton;
   private JButton showButton;
   
   public ComplicatedGUI1()
   {
      super("A Complicated Window 1");
      
      headerPanel = new JPanel();
      headerLabel = new JLabel("This is text in a label");
      Font headerFont = new Font(headerLabel.getFont().getFamily(), Font.PLAIN, 20);
      headerLabel.setFont(headerFont);
      headerPanel.add(headerLabel);
      
      mainPanel = new JPanel();
      mainPanel.setLayout(new BorderLayout());
      
      textPanel = new JPanel();
      textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
      textPanel.setBorder(new TitledBorder("Text format"));
      textLabel1 = new JLabel("Change the style of: ");
      textLabel2 = new JLabel("Some text");
      Font someTextFont = new Font("Dialog", Font.PLAIN, 14);
      textLabel2.setFont(someTextFont);
      boldCheckBox = new JCheckBox("Bold");
      italicCheckBox = new JCheckBox("Italic");
      textPanel.add(textLabel1);
      textPanel.add(textLabel2);
      textPanel.add(boldCheckBox);
      textPanel.add(italicCheckBox);
      
      changePanel = new JPanel();
      changePanel.setLayout(new BoxLayout(changePanel, BoxLayout.Y_AXIS));
      changePanel.setBorder(new TitledBorder("Change background"));
      redRadioButton = new JRadioButton("Red");
      greenRadioButton = new JRadioButton("Green");
      blueRadioButton = new JRadioButton("Blue");
      normalRadioButton = new JRadioButton("Normal background", true);
      colorGroup = new ButtonGroup();
      colorGroup.add(redRadioButton);
      colorGroup.add(greenRadioButton);
      colorGroup.add(blueRadioButton);
      colorGroup.add(normalRadioButton);
      changePanel.add(redRadioButton);
      changePanel.add(greenRadioButton);
      changePanel.add(blueRadioButton);
      changePanel.add(normalRadioButton);
      
      personPanel = new JPanel();
      personPanel.setLayout(new BoxLayout(personPanel, BoxLayout.Y_AXIS));
      personPanel.setBorder(new TitledBorder("Person data"));
      personNamePanel = new JPanel();
      personNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      nameLabel = new JLabel("Name");
      nameField = new JTextField(25);
      personPhonePanel = new JPanel();
      personPhonePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      phoneLabel = new JLabel("Phone");
      phoneField = new JTextField(10);
      personAgePanel = new JPanel();
      personAgePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      ageLabel = new JLabel("Age");
      ageField = new JTextField(3);
      
      personNamePanel.add(nameLabel);
      personNamePanel.add(nameField);
      personPhonePanel.add(phoneLabel);
      personPhonePanel.add(phoneField);
      personAgePanel.add(ageLabel);
      personAgePanel.add(ageField);
      personPanel.add(personNamePanel);
      personPanel.add(personPhonePanel);
      personPanel.add(personAgePanel);
      
      mainPanel.add(textPanel, BorderLayout.WEST);
      mainPanel.add(changePanel, BorderLayout.CENTER);
      mainPanel.add(personPanel, BorderLayout.EAST);
      
      footerPanel = new JPanel();
      footerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      exitButton = new JButton("Exit");
      showButton = new JButton("Show result");
      footerPanel.add(exitButton);
      footerPanel.add(showButton);
      
      add(headerPanel, BorderLayout.NORTH);
      add(mainPanel, BorderLayout.CENTER);
      add(footerPanel, BorderLayout.SOUTH);
      setSize(640, 232);
      setVisible(true);
      setResizable(false);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
   }
  
   public static void main(String[] args)
   {
      ComplicatedGUI1 cgui1 = new ComplicatedGUI1();
   }
}
