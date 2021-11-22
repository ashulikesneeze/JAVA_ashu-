package D17;

import java.util.ArrayList;

public class AStudent {
	private int grade, classNum, num;
	private String name;
	private ArrayList<AScore> score;

	public AStudent(int grade, int classNum, int num, String name, ArrayList<AScore> score) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		this.score = score;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AStudent other = (AStudent) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} 
		if (num != other.num)
			return false;
		return true;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ExbStudent [grade=" + grade + ", classNum=" + classNum + ", num=" + num + ", name=" + name + "]";
	}

	public ArrayList<AScore> getScore() {
		return score;
	}

	public void setScore(ArrayList<AScore> score) {
		this.score = score;
	}
}
