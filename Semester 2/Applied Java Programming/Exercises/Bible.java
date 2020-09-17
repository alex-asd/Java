import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.hamcrest.Matcher;

public class Bible {

	
	public static void main(String[] args)
	{
		String[] bible = loadFile("bible.txt");
		String[] dictionary = loadFile("dictionary.txt");
		
		System.out.println(Bible.numberOfWords(bible));
		System.out.println(Bible.numberOfChar(bible));
	}
	
	public static int numberOfWords(String[] array)
	{
		return array.length;
	}
	
	public static int numberOfChar(String[] array)
	{
		int count = 0;
		for (int i = 0; i < array.length; i++) 
		{
			count += array[i].length();
		}
		return count;
	}
	
	private static int linearSearch(int x, int[] array, int first)
	{
//		int totalDistinct = 0;
//		int count = 0;
//		for (int i = 1; i < array.length; i++) 
//		{
//			if(array[x] == array[i])
//			{
//				count++;
//			}
//		}
//		if(count == 1)
//			totalDistinct++;
		
		if (first >= array.length)
		{
			return -1;
		}
		if (x == array[first])
		{
			return first;
		}
		return linearSearch(x, array, first + 1);
	}

	
	
	public static String[] loadFile(String filename)
	 {
		ArrayList<String> words = new ArrayList<>();
		File file = new File(filename);
		Scanner in = null;
		try
		{
			in = new Scanner(file);
			while (in.hasNext())
			{
				String token = in.next();
				if (!token.matches(".*\\d+.*"))
				{
					Pattern p = Pattern.compile("[^a-z0-9 ]",
							Pattern.CASE_INSENSITIVE);
					java.util.regex.Matcher m = p.matcher(token);
					if (m.find())
					{
						token = token.replaceAll("[^\\w\\s]", "");
					}
					words.add(token.toLowerCase());
				}
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		in.close();
		String[] all = new String[words.size()];
		return words.toArray(all);
	 }
	
}
	
