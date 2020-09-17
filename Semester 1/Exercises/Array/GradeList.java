import java.util.ArrayList;

public class GradeList {

	private ArrayList<Grade> grades;

	public GradeList() {
		grades = new ArrayList<Grade>();
		/*
		 * for (int i = 0; i < grades.length; i++) {
		 * grades[i].setCourseName("Not filled yet"); grades[i].setGrade(-1); }
		 */
	}

	public int getNumberOfGrades() {
		return grades.size();
	}

	public int getGrade(int index) {
		return grades.get(index);
	}

	public void setGrade(int grade, int index, String course) {
		/*
		 * if(grades[index] != null) { grades[index].setGrade(grade);
		 * grades[index].setCourseName(course); } else
		 
		grades[index] = new Grade(course, grade);
		*/
		
		grades.get(index).setGrade(grade);
		grades.get(index).setCourseName(course);
	}

	public double getAverage() {
		int count = 0;
		double total = 0;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] != null) {
				total += grades[i].getGrade();
				count++;
			}
		}
		return total / count;

	}

	public String toString() {
		String str = "";
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] != null)
				str += ("Course: " + grades[i].getCourseName() + '\t'
						+ "Grade: " + grades[i].getGrade() + '\n');
		}
		return str;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof GradesListGrade))
			return false;
		GradesListGrade list = (GradesListGrade) obj;
		if (grades.length != list.grades.length)
			return false;
		else {
			for (int i = 0; i < grades.length; i++) {
				if (grades[i] == null && list.grades[i] != null) {
					System.out.println(i);
					return false;
				} else if (grades[i] != null) {
					if (!(grades[i].equals(list.grades[i])))
						return false;
				}
			}
			return true;
		}
	}
}