import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
public class test2 extends JFrame{

	
	private JFrame dia1;
	private JFrame dia2;
	private JFrame dia3;
	private JFrame dia4;
	private JFrame dia5;
	private JFrame dia6;
	private JFrame dia7;
	private JFrame dia8;
	private JFrame dia9;
	private JFrame dia10;
	private JFrame dia11;
	private JFrame dia12;
	private JFrame dia13;
	private JFrame dia14;
	private JFrame dia15;
	private JFrame dia16;
	private JFrame dia17;
	private JFrame dia18;
	private JFrame dia19;
	private JFrame dia20;
	private JFrame dia21;
	private JFrame dia22;
	private JFrame dia23;
	private JFrame dia24;
	private JFrame dia25;
	private JFrame dia26;
	private JFrame dia27;
	private JFrame dia28;
	private JFrame dia29;
	private JFrame dia30;
	private JFrame dia31;
	
	private JLabel msg1;
	private JLabel msg2;
	private JLabel msg3;
	private JLabel msg4;
	private JLabel msg5;
	private JLabel msg6;
	private JLabel msg7;
	private JLabel msg8;
	private JLabel msg9;
	private JLabel msg10;
	private JLabel msg11;
	private JLabel msg12;
	private JLabel msg13;
	private JLabel msg14;
	private JLabel msg15;
	private JLabel msg16;
	private JLabel msg17;
	private JLabel msg18;
	private JLabel msg19;
	private JLabel msg20;
	
	
	
	private JPanel main;
	private JLabel img;
	private JButton click;
	private JLabel msg;
	private JPanel footer;

	public test2(){
		super("Killer program");
		main = new JPanel();
		img = new JLabel();
		msg = new JLabel("Note that clicking this could be really bad for you and you PC!");
		Font font = new Font("Verdana", Font.BOLD, 16);
		msg.setFont(font);
		click = new JButton("Don't click me");
		msg20 = new JLabel("Relax, just a prank !!!");
		msg1 = new JLabel(":)))");
		msg2 = new JLabel("u are doomed m8");
		msg3 = new JLabel("copying all document");
		msg4 = new JLabel("sending to the hacker");
		msg5 = new JLabel("deleting OS");
		msg6 = new JLabel("lockdown CPU");
		msg7 = new JLabel("overheating GPU");
		msg8 = new JLabel("this pc will be trash soon");
		msg9 = new JLabel("Temperature of pc now over 80 degrees");
		msg10 = new JLabel("u need new video card");
		msg11 = new JLabel("new pc too");
		msg12 = new JLabel("i will destroy u :)");
		msg13 = new JLabel("karma");
		msg14 = new JLabel("this is fun thought");
		msg15 = new JLabel("should be over soon");
		msg16 = new JLabel("u are totallt gonna cry now");
		msg17 = new JLabel("call mommy");
		msg18 = new JLabel("riot, cancer, lol");
		msg19 = new JLabel("bye bye, cya :v");
		
		
		footer = new JPanel();
		footer.setLayout(new FlowLayout(FlowLayout.CENTER));
		footer.add(click);
		
		main.add(msg);
		add(main, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);
		
	    setSize(600, 250);
	    setVisible(true);
	    setResizable(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    
	    dia1 = new JFrame("CPU INFECTED");
		dia1.setLayout(new FlowLayout());
		dia1.add(img);
		dia1.setSize(300, 200);
		
		for (int i = 1; i <= 20; i++) {
			String obj = "dia" + i;
			try {
				System.out.println(test2.parseObjectFromString(obj, JFrame.class));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}

		public static <T> T parseObjectFromString(String s, Class<T> clazz) throws Exception {
		    return clazz.getConstructor(new Class[] {String.class }).newInstance(s);
		}
	}