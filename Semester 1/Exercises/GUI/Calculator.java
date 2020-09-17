import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Calculator extends JFrame{
	
	private JPanel main;
	private JPanel buttons;
//	private JPanel field;
	private JPanel buttom;
	
	private buttonListener listener;
	
	private JTextField box;
	
	private JButton but7;
	private JButton but8;
	private JButton but9;
	private JButton butDevide;
	private JButton but4;
	private JButton but5;
	private JButton but6;
	private JButton butMulti;
	private JButton but1;
	private JButton but2;
	private JButton but3;
	private JButton butMinus;
	private JButton but0;
	private JButton butDot;
	private JButton butEquals;
	private JButton butPlus;
	private JButton butC;
	private JButton butDel;
	
	private double x;
	private double y;
	private double z;
	private String operator;
	
	public Calculator()
	{
		super("Calculator");
		main = new JPanel();
		main.setLayout(new BorderLayout());
		listener = new buttonListener();
		
		but7 = new JButton("7");
		but7.addActionListener(listener);
		but8 = new JButton("8");
		but8.addActionListener(listener);
		but9 = new JButton("9");
		but9.addActionListener(listener);
		butDevide = new JButton("/");
		butDevide.addActionListener(listener);
		but4 = new JButton("4");
		but4.addActionListener(listener);
		but5 = new JButton("5");
		but5.addActionListener(listener);
		but6 = new JButton("6");
		but6.addActionListener(listener);
		butMulti = new JButton("*");
		butMulti.addActionListener(listener);
		but1 = new JButton("1");
		but1.addActionListener(listener);
		but2 = new JButton("2");
		but2.addActionListener(listener);
		but3 = new JButton("3");
		but3.addActionListener(listener);
		butMinus = new JButton("-");
		butMinus.addActionListener(listener);
		but0 = new JButton("0");
		but0.addActionListener(listener);
		butDot = new JButton(".");
		butDot.addActionListener(listener);
		butEquals = new JButton("=");
		butEquals.addActionListener(listener);
		butPlus = new JButton("+");
		butPlus.addActionListener(listener);
		
//		field = new JPanel();
		box = new JTextField(20);
//		field.add(box);
		Font font = new Font("Verdana", Font.BOLD, 25);
		box.setFont(font);
		buttons = new JPanel();
		buttons.setLayout(new GridLayout(4,4,0,0));

		buttons.add(but7);
		buttons.add(but8);
		buttons.add(but9);
		buttons.add(butDevide);
		buttons.add(but4);
		buttons.add(but5);
		buttons.add(but6);
		buttons.add(butMulti);
		buttons.add(but1);
		buttons.add(but2);
		buttons.add(but3);
		buttons.add(butMinus);
		buttons.add(but0);
		buttons.add(butDot);
		buttons.add(butEquals);
		buttons.add(butPlus);
		
		box.setEditable(false);
	    box.setHorizontalAlignment(SwingConstants.RIGHT);
//	    box.setText("0");
		
	    buttom = new JPanel();
	    buttom.setLayout(new GridLayout(1,2,0,0));
	    butC = new JButton("C");
	    butC.addActionListener(listener);
	    butDel = new JButton("Delete");
	    butDel.addActionListener(listener);
	    buttom.add(butC);
	    buttom.add(butDel);
	    
		main.add(box, BorderLayout.NORTH);
	    main.add(buttons, BorderLayout.CENTER);
	    main.add(buttom, BorderLayout.SOUTH);
		add(main, BorderLayout.CENTER);
		
	    setSize(240, 340);
	    setVisible(true);
	    setResizable(true);

	      
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	}
	
//	public void waitForNext()
//	{
//		if(box.getText().length() != 0)
//			
//	}
	
	private class buttonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == but0)
			{
				box.setText(box.getText() + "0");
			}
			else if(e.getSource() == but1)
			{
				box.setText(box.getText() + "1");
			}
			else if(e.getSource() == but2)
			{
				box.setText(box.getText() + "2");
			}
			else if(e.getSource() == but3)
			{
				box.setText(box.getText() + "3");
			}
			else if(e.getSource() == but4)
			{
				box.setText(box.getText() + "4");
			}
			else if(e.getSource() == but5)
			{
				box.setText(box.getText() + "5");
			}
			else if(e.getSource() == but2)
			{
				box.setText(box.getText() + "2");
			}
			else if(e.getSource() == but6)
			{
				box.setText(box.getText() + "6");
			}
			else if(e.getSource() == but7)
			{
				box.setText(box.getText() + "7");
			}
			else if(e.getSource() == but8)
			{
				box.setText(box.getText() + "8");
			}
			else if(e.getSource() == but9)
			{
				box.setText(box.getText() + "9");
			}
			else if(e.getSource() == butDevide)
			{
				if(box.getText().length() != 0)
					x = Double.parseDouble(box.getText());
				box.setText("");
				operator = "/";
			}
			else if(e.getSource() == butMulti)
			{
				if(box.getText().length() != 0)
					x = Double.parseDouble(box.getText());
				box.setText("");
				operator = "*";
			}
			else if(e.getSource() == butMinus)
			{
				if(box.getText().length() != 0)
					x = Double.parseDouble(box.getText());
				box.setText("");
				operator = "-";
			}
			else if(e.getSource() == butPlus)
			{
				if(box.getText().length() != 0)
					x = Double.parseDouble(box.getText());
				box.setText("");
				operator = "+";
			}
			else if(e.getSource() == butDot)
			{
				box.setText(".");
			}
			else if(e.getSource() == butEquals)
			{
				y = Double.parseDouble(box.getText());
				if(operator.equals("+"))
				{
					z = x + y;
					box.setText(String.valueOf(z));
				}
				else if(operator.equals("-"))
				{
					z = x - y;
					box.setText(String.valueOf(z));
				}
				else if(operator.equals("*"))
				{
					z = x * y;
					box.setText(String.valueOf(z));
				}
				else if(operator.equals("/"))
				{
					z = x / y;
					box.setText(String.valueOf(z));
				}
			}
			else if(e.getSource() == butDel)
			{
				box.setText("");
			}
			else if(e.getSource() == butC)
			{
				String str = "";
				ArrayList numbers = new ArrayList<>();
				for(int i = 0; i < box.getText().length(); i++)
				{
					numbers.add(box.getText().charAt(i));
				}
				numbers.remove(box.getText().length() - 1);
				for(int i = 0; i < box.getText().length() - 1; i++)
				{
					str+=numbers.get(i);
				}
				box.setText(str);
			}
		}
		
	}
	
	public static void main(String[] args)
	{
		Calculator calc = new Calculator();
	}
}
