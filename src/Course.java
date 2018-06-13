import java.util.List;

public class Course {
    String name;
    List<Question> questionBank;
    int courseId;

    public Course(int courseId, String name) {
        this.name = name;
        this.courseId = courseId;
    }

    public int getQuestionBankCount() {
        return questionBank.size();
    }

    public Course(){}

    public List<Question> getCourseQuestoins(){return questionBank;}
    public void addQuestionToCourse(Question q){
        questionBank.add(q);
    }

    public List<Question> getQuestionBank() {
        return questionBank;
    }

    public void setQuestionBank(List<Question> questionBank) {
        this.questionBank = questionBank;
    }

    public Question getQuestion(int quesId){
        for(Question q:questionBank){
            if(q.QuestionId==quesId)
                return q;
        }
        return null;
    }

    public Question getQuestionbyName(String quesName){
        for(Question q:questionBank){
            if(q.body==quesName)
                return q;
        }
        return null;
    }
}
