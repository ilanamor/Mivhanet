public class Question {

    int time;
    String body;
    Answer[] possibleAnswers;
    Comment[] comments;
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
    public int getCommentsNum(){return comments.length;}
    public void addComment(Comment c){}

}
