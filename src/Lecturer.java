public class Lecturer extends TeachingWorker {

    Lecturer(String userName, String lastName, String firstName, int ID, String address, String phoneNumber, String email, String password) {
        super(userName, lastName, firstName, ID, address, phoneNumber, email, password);
    }

    Lecturer(){}

    public void updateQuestionAnswer(String courseId, String questionId, String answerId, String body){}
    public void createExam(String courseInSemesterId){}

    public void PointToQuestionInExam(String questionId,String examId, int scoreInExam){}
    public void AddTermToExam(String termId, String examId){}
}
