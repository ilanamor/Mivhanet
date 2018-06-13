import java.util.List;

public class Question {

    int time;
    String body;
    List<Answer> possibleAnswers;

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    List<Comment> comments;

    public void setPossibleAnswers(List<Answer> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    int level;
    int writerId;
    int QuestionId;

    public Question(int questionId, int time, String body, int level, int writerId) {
        this.time = time;
        this.body = body;
        this.level = level;
        this.writerId = writerId;
        QuestionId = questionId;
    }

    Question(){}
    public int getWriterId(){return writerId;}
    public void setBody(String body){}
    public void addAnswer(Answer a){}
    public int getCommentsNum(){return comments.size();}
    public void addComment(Comment c){}

}
