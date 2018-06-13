public class Answer {
    public String answer;
    public boolean isTrue;

    public Answer(String answer, boolean isTrue, int questionId, int answerId) {
        this.answer = answer;
        this.isTrue = isTrue;
        this.questionId = questionId;
        this.answerId = answerId;
    }

    public int questionId;
    public int answerId;

    //Answer(String body, boolean isTrue){}
    Answer(){}
    public boolean getIsTrue(){return isTrue;}
    public int getQuestionId(){return questionId;}

}