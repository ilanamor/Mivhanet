public class CourseManager extends Lecturer {

    public void deleteQuestion(String QuestionId, String courseId){}
    public void createSyllabus(String courseId, String text){}
    public void updateExamGrade(String examId, String courseInSemesterId, int factor){}
    public void updateExamGradeforStudent(String examId, String courseInSemesterId, String studentId, int newGrade){}
    public void approveExam(String examId){}

    public Exam[] ShowNotApprovedExams(String courseInSemesterId){return new Exam[0];}

}
