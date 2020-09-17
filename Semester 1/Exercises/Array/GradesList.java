
public class GradesList {

	private int[] grades;
		
	public GradesList(int numberOfGrades)
	{
		grades = new int[numberOfGrades];
		for (int i = 0; i < grades.length; i++) 
		{
			grades[i] = -1;
		}
	}
	
	public int getNumberOfGrades()
	{
		int count = 0;
		for (int i = 0; i < grades.length; i++) 
		{
			if(grades[i] != -1)
				count++;
		}
		return count++;
	}
	
	public int getGrade(int index)
	{
		return grades[index];
	}
	
	public void setGrade(int grade, int index)
	{
		grades[index] = grade;
	}
	
	public double getAverage()
	{
		int count = 0;
		double total = 0;
		for (int i = 0; i < grades.length; i++) 
		{
			if(grades[i] != -1)
			{
				total += grades[i];
				count++;
			}
		}
		return total/count;
				
	}
	
	public String toString()
	{
		String str = "";
		for (int i = 0; i < grades.length; i++) 
		{
			str +=("Grade: " + grades[i] + " ");
		}
		return str;
	}

	public boolean equals(Object obj)
	{
		if (!(obj instanceof GradesList)) 
			return false;
		GradesList list = (GradesList)obj;
		for (int i = 0; i < grades.length; i++) 
		{
			if(grades.length != list.grades.length)
				return false;
			else if(grades[i] == -1 && list.grades[i] != -1)
				return false;
			else if(grades[i] != -1)
			{
				if(!(grades[i] == list.grades[i]))
						return false;
			}
		}
		return true;
	}
}
