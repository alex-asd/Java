import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
public class MainGUI extends JFrame{
	
	private JTabbedPane tabPane;
	
	private MakeReservationPanel makeReservationPanel;
	private AddBusChauffeurPanel addBusChauffeurPanel;
	
	private TabListener tabListener;
	private FileAdapter adapter;
	public MainGUI()
	{
		super("VIA Bus System");
		
		makeReservationPanel = new MakeReservationPanel();
		addBusChauffeurPanel = new AddBusChauffeurPanel();
		
		tabPane = new JTabbedPane();
		tabPane.addTab("Make Reservation", makeReservationPanel);
		tabPane.addTab("Add bus/chauffeur", addBusChauffeurPanel);
//		tabPane.addChangeListener(tabListener);

		
		add(tabPane);
		setSize(600, 500);
		setVisible(true);
		setResizable(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	private class TabListener implements ChangeListener
	{
		public void stateChanged(ChangeEvent e)
		{
		   if(((JTabbedPane)e.getSource()).getSelectedIndex()==0)
		   {
		      
			} 
 
			if(((JTabbedPane)e.getSource()).getSelectedIndex()==1)
			{
				  
			}
		}
	}

	public static void main(String[] args)
	{
		MainGUI main = new MainGUI();
	}
}
