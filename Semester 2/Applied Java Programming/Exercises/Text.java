
public class Text {

	private String text;

	public Text(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	 public boolean isPalindrome() {
	 return isPalindrome(text, 0, text.length() - 1);
	 }
	
	 private static boolean isPalindrome(String text, int left, int right) {
	 if (left >= right) {
	 return true;
	 }
	
	 if (Character.toLowerCase((int) text.charAt(left)) < 65)
	 left += 1;
	 if (Character.toLowerCase((int) text.charAt(right)) < 65)
	 right += 1;
	
	 return (Character.toLowerCase(text.charAt(left)) ==
	 Character.toLowerCase(text.charAt(right)))
	 && isPalindrome(text, left + 1, right - 1);
	 }

	public boolean check() {
		boolean bol = false;
		if (text.length() % 2 == 0) {
			for (int i = 0; i < text.length() / 2 ; i++) 
			{
				// need just to add ";" , "," , ":", " " ;
				if (Character.toLowerCase(text.charAt(i)) !=
						Character.toLowerCase(text.charAt(text.length() - i - 1)))
					bol = false;
				else
					bol = true;
			}
		}

		else {
			for (int i = 0; i < (text.length() - 1) / 2 ; i++) 
			{
				if (Character.toLowerCase(text.charAt(i)) != 
						Character.toLowerCase(text.charAt(text.length() - i - 1))) 
				{
					bol = false;
				} else {
					bol = true;
				}
			}
		}
		return bol;
		// String temp ="";
		// int i = 0;
		// int right = text.length() - 1;
		// while (i < text.length())
		// {
		// if()
		// i++;
		// }
	}
	
	
//	public String reverse(String text)
//	{
//		
//	}

}
