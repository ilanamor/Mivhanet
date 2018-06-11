public class Controller {

    public CourseInSemester getCourseInSemester(String cisId){return new CourseInSemester();}
    public Exam getExam(String examId){return new Exam();}
    public Student getStudent(String examId){return new Student();}
    public Score getScore(String examId, String quesId){return new Score();}
    public Course getCourse(String courseId){return new Course();}
    public Question getQuestion(String quesId){return new Question();}
    public Answer getAnswer(String answerId){return new Answer();}
    public Term getTerm(String termId){return new Term();}
    public Semester getSemester(String SemesterId){return new Semester();}
    public TeachingWorker getUser(String userId){return new Lecturer();}

}
