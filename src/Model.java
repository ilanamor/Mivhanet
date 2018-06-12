import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.*;

public class Model {

    public Connection conn;

    public void connectToDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:Mivhanet.db");
    }

    public User Login(String userName, String password) throws Exception {
        PreparedStatement prep = conn.prepareStatement("SELECT userName FROM users WHERE userName='" + userName + "' AND password='" + password +"'");
        ResultSet rs = prep.executeQuery();

        if (rs.next()) {
            String type = rs.getString("job");
            if(type=="secretary"){
                return new Secretariat(rs.getString("userName"),rs.getString("lName"),rs.getString("fName"),rs.getString("userId"), rs.getString("address"),rs.getString("phone"),rs.getString("email") ,rs.getString("password"));
            }
            else{
                return new TeachingWorker(rs.getString("userName"),rs.getString("lName"),rs.getString("fName"),rs.getString("userId"), rs.getString("address"),rs.getString("phone"),rs.getString("email") ,rs.getString("password"));
            }
        }
        else {
            throw new Exception();
        }
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
