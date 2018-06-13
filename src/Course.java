public class Course {
    String name;
    Question[] questionBank;
    int courseId;

    public Course(int courseId, String name) {
        this.name = name;
        this.courseId = courseId;
    }

    public Course(){}

    public Question[] getCourseQuestoins(){return questionBank;}
    public void addQuestionToCourse(Question q){}

}
