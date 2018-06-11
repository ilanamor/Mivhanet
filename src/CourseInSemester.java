public class CourseInSemester {
    String sylabus;
    Course course;
    Semester semester;
    CourseStaff staff;
    Student[] students;
    Exam[] exams=new Exam[3];
    Term[] terms=new Term[3];

    CourseInSemester(Semester s, Course c){}
    CourseInSemester(){}
    public Exam[] getExams(){return exams;}
    public Term[] getCourseInSemesterTerms(){return terms;}
    public void addTerm(Term t){}
    public void addExam(Exam e){}
    public void addStudent(Student s){}
    public void addCourseStaff(CourseStaff cs){}

}
