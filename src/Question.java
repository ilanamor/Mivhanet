public class Question {
    int time;
    String body;
    Answer[] possibleAnswers;
    Comment[] comments;
    int level;
    String writerId;
    String QuestionId;

    public class Comment{
        String text;
    }

    Question(String body, int time, int level){}
    Question(){}
    public String getWriterId(){return writerId;}
    public void setBody(String body){}
    public void addAnswer(Answer a){}
    public int getCommentsNum(){return comments.length;}
    public void addComment(Comment c){}

}
