public class Exam {
    Question[] questions=new Question[20];
    Term examTerm;
    boolean isPass;
    boolean isApproved;
    int time;
    double avgScore;
    String examId;

    public boolean getIfPass(){return isPass;}
    public Question[] getQuestions(){return questions;}
    public boolean getIsApproved(){return isApproved;}
    public void setIsApproved(boolean b){}
    public void addTerm(Term t){}

}
