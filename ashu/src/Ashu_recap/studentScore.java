package Ashu_recap;

public class studentScore {

		private String subjectTitle;
		private int grade;
		private int semester;
		private int point;
		
		public studentScore(String subjectTitle, int grade, int semester, int point) {
			this.subjectTitle = subjectTitle;
			this.setPoint(point);
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
			studentScore other = (studentScore) obj;
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

		public int getPoint() {
			return point;
		}

		public void setPoint(int point) {
			this.point = point;
		}

}
