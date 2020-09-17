import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
public class Align extends JFrame{

	private JPanel left;
	private JPanel right;
	private JPanel center;
	private JPanel main;
	private JPanel yBox;
	private JPanel xBox;
	
	private JCheckBox checkOk;
	private JCheckBox checkCancel;
	
	private JLabel xLabel;
	private JLabel yLabel;
	   
	private JTextField x;
	private JTextField y;
	
	private JButton ok;
	private JButton cancel;
	private JButton clear;
	
	public Align()
	{
		super("Align");
		left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		checkOk = new JCheckBox("Exit on OK");
		checkCancel = new JCheckBox("Exit on Cancel");
		left.add(checkOk);
		left.add(checkCancel);
		
		
		center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		y = new JTextField(3);
		x = new JTextField(3);
		xLabel = new JLabel("X:");
		yLabel = new JLabel("Y:");
		xBox = new JPanel();
		xBox.add(xLabel);
		xBox.add(x);
		yBox = new JPanel();
		yBox.add(yLabel);
		yBox.add(y);
		center.add(xBox);
		center.add(yBox);
		
		
		right = new JPanel();
		right.setLayout(new GridLayout(3,1,4,4));
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		clear = new JButton("Clear");
		right.add(ok);
		right.add(cancel);
		right.add(clear);
		
		main = new JPanel();
		main.setLayout(new BorderLayout());
		main.add(left, BorderLayout.WEST);
	    main.add(center, BorderLayout.CENTER);
	    main.add(right, BorderLayout.EAST);
	    
	    add(main, BorderLayout.CENTER);
	    setSize(260, 130);
	    setVisible(true);
	    setResizable(true);
	      
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	}
	
	public static void main(String[] args)
	{
		Align ali = new Align();
	}
}

//private JFrame dia1;
//private JFrame dia2;
//private JFrame dia3;
//private JFrame dia4;
//private JFrame dia5;
//private JFrame dia6;
//private JFrame dia7;
//private JFrame dia8;
//private JFrame dia9;
//private JFrame dia10;
//private JFrame dia11;
//private JFrame dia12;
//private JFrame dia13;
//private JFrame dia14;
//private JFrame dia15;
//private JFrame dia16;
//private JFrame dia17;
//private JFrame dia18;
//private JFrame dia19;
//private JFrame dia20;



//JPanel panel1 = new JPanel();
//panel1.setBackground(new Color(180, 200, 240));