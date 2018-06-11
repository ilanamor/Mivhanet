public abstract class TeachingWorker extends User{

    public Question[] showCourseQuestions(String courseId){return new Question[0];}
    public void createQuestion(String courseId, int time, int level, String quesBody, Answer[] answers){}
    public void editQuestionBody(String questionId, String body){}
    public void editQuestionTime(String questionId, int time){}
    public void addComment(String questionId, Question.Comment comment){}
    private void changePassword(String newPass){}
    public StudentAnswers[] getExamGrades(String courseInSemesterId, String ExamId){return new StudentAnswers[0];}
    public void insertStudentAnswers(StudentAnswers[] answers, String examId){}
    private void printExam(String examId, String path){}

    public Exam[] showPastExams(String courseInSemesterID){return new Exam[0];}
    public Question[] ShowExamQuestions(String examId){return new Question[0];}
    public void calcAndSaveGrade(String examId, String studentId, Answer[] answers){}
    public CourseInSemester ShowCourseInSemester(String courseInSemesterId){return new CourseInSemester();}
    public boolean CheckEditPermission(String questionId, String workerId){return true;}
    public void	createAnswer(String answerBody, boolean isTrue){}
    public Exam ShowExam(String examId){return new Exam();}
    public int checkNumOfComments(String quesId){return 0;}
    TeachingWorker(){}

}
