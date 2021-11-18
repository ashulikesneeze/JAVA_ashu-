package D17;

public class ExbScore {
	private String subjectTitle;
	private int grade;
	private int semester;
	private int point;
	
	public ExbScore(String subjectTitle, int grade, int semester, int point) {
		this.subjectTitle = subjectTitle;
		this.point = point;
		this.grade = grade;
		this.semester = semester;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExbScore other = (ExbScore) obj;
		if (grade != other.grade)
			return false;
		if (semester != other.semester)
			return false;
		if (subjectTitle == null) {
			if (other.subjectTitle != null)
				return false;
		} else if (!subjectTitle.equals(other.subjectTitle))
			return false;
		return true;
	}

	public String getSubjectTitle() {
		return subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

}
