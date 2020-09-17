import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Hello extends JFrame
{
	
	private JButton but;
	private JLabel lab;
	
	
	public Hello()
	{
		super("VIA Bus System");
		but = new JButton("Click me");
		but.setBounds(279, 161, 239, 56);
		Font font = new Font("Verdana", 1, 30);
		lab = new JLabel("Hello!");
		lab.setFont(font);
		lab.setBounds(30, 30, 239, 56);
		setLayout(null);
		add(but);
		add(lab);
		setSize(600, 500);
		setVisible(true);
		setResizable(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args)
	{
		Hello hel = new Hello();
	}
}
