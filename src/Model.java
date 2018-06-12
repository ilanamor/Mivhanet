import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Model {

    public static Connection conn;

    public static void connectToDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:Mivhanet.db");
    }

    public static User Login(String userName, String password) throws Exception {
        PreparedStatement prep = conn.prepareStatement("SELECT * FROM users WHERE userName='" + userName + "' AND password='" + password +"'");
        ResultSet rs = prep.executeQuery();

        if (rs.next()) {
            String type = rs.getString("job");
            if(type.equals("secretary")){
                return new Secretariat(rs.getString("userName"),rs.getString("lName"),rs.getString("fName"),rs.getInt("userId"), rs.getString("address"),rs.getString("phone"),rs.getString("email") ,rs.getString("password"));
            }
            else{
                return new TeachingWorker(rs.getString("userName"),rs.getString("lName"),rs.getString("fName"),rs.getInt("userId"), rs.getString("address"),rs.getString("phone"),rs.getString("email") ,rs.getString("password"));
            }
        }
        else {
            throw new Exception();
        }
    }

    public static HashMap<String,Integer> getAllCourses(int UserId) throws SQLException {
        PreparedStatement prep = conn.prepareStatement("select distinct c.courseName, c.courseId from courseStaff a join courseInSemester b on a.courseInSemesterId=b.id join courses c on b.courseId=c.courseId where a.userId='"+UserId+"'");
        ResultSet rs = prep.executeQuery();
        HashMap<String,Integer> result = new HashMap<String,Integer>();
        while (rs.next()) {
            result.put(rs.getString("courseName"),rs.getInt("courseId"));
        }
        return result;
    }

    public static int addQuestion(int courseId, int time, String body, int level ) throws SQLException {
        //get max question id
        PreparedStatement prep = conn.prepareStatement("select max(quesId) as max from questions");
        ResultSet rs = prep.executeQuery();
        int maxId;
        if (rs.next()) {
            maxId= rs.getInt("max");
        }
        else
            maxId=0;
        maxId++;
        //add question
        prep = conn.prepareStatement("insert into questions (quesId, courseId, time, body, level) values ('" +maxId+"','"+ courseId+"','"+ time+"','"+ body+"','"+ level+"')");
        prep.executeUpdate();

        return maxId;
    }

    public static void addAnswers(int quesId, String[] body, boolean[] isTrue ) throws SQLException {
        PreparedStatement prep = conn.prepareStatement("select max(answerId) as max from answers");
        ResultSet rs = prep.executeQuery();
        int maxId;
        if (rs.next()) {
            maxId= rs.getInt("max");
        }
        else
            maxId=0;
        maxId++;

        for(int i=0; i<body.length;i++){
            prep = conn.prepareStatement("insert into answers (answerId, quesId, answer, isTrue) values ('" +maxId+"','"+ quesId+"','"+ body[i]+"','"+ isTrue[i]+"')");
            prep.executeUpdate();
            maxId++;
        }
    }

    public static HashMap<Integer, String> getAllQuestions(int CourseId) throws SQLException {
        PreparedStatement prep = conn.prepareStatement("select quesId, body from questions where courseId='"+CourseId+"'");
        ResultSet rs = prep.executeQuery();
        HashMap<Integer, String> result= new HashMap<Integer, String>();
        while (rs.next()) {
            result.put(rs.getInt("quesId"), rs.getString("body"));
        }
        return result;
    }

    public static void updateQuestion(String quesId, String body) throws SQLException {
        PreparedStatement prep = conn.prepareStatement("update questions set body='"+body+"' where quesId='"+quesId+"'");
        prep.executeUpdate();
    }

    public static int checkNumOfComments(String quesId) throws SQLException {

        PreparedStatement prep = conn.prepareStatement("select count(commentId) as num from comments where quesId='"+quesId+"'");
        ResultSet rs = prep.executeQuery();
        if(rs.next()){
            return rs.getInt("num");
        }
        else return 0;
    }

    public static void addComment(String quesId, String comment) throws SQLException {
        PreparedStatement prep = conn.prepareStatement("select max(commentId) as max from comments");
        ResultSet rs = prep.executeQuery();
        int maxId;
        if (rs.next()) {
            maxId= rs.getInt("max");
        }
        else
            maxId=0;
        maxId++;

         prep = conn.prepareStatement("insert into comments (commentId, quesId, text) values ('"+maxId+"','"+quesId+"','"+comment+"')");
         prep.executeUpdate();
    }

    public CourseInSemester getCourseInSemester(String cisId){return new CourseInSemester();}
    public Exam getExam(String examId){return new Exam();}
    public Student getStudent(String examId){return new Student();}
    public Score getScore(String examId, String quesId){return new Score();}
    public Course getCourse(String courseId){return new Course();}
    public Question getQuestion(String quesId){return new Question();}
    public Answer getAnswer(String answerId){return new Answer();}
    public Term getTerm(String termId){return new Term();}
    public Semester getSemester(String SemesterId){return new Semester();}
    public TeachingWorker getUser(String userId){return new Lecturer();}

}