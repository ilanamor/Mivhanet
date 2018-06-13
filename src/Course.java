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

    public void setQuestionBank(List<Question> questionBank) {
        this.questionBank = questionBank;
    }
}
