public class Answer {
    public String answer;
    public boolean isTrue;
    public String questionId;
    public String answerId;

    Answer(String body, boolean isTrue){}
    Answer(){}
    public boolean getIsTrue(){return isTrue;}
    public String getQuestionId(){return questionId;}

}