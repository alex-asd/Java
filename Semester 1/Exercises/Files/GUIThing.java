import javax.swing.JOptionPane;

public class GUIThing {

	public static void main(String[] args)
	{
		JOptionPane.showMessageDialog(null, "Well, IDK",
				"My Message", JOptionPane.ERROR_MESSAGE);
		
		String input = JOptionPane.showInputDialog(null,
				"Type something here:", "My Input",
				JOptionPane.WARNING_MESSAGE);
				System.out.println(input);
	}
}
