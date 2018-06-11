import java.util.Date;

public class Secretariat extends User {

    public void openCourse(String name, String courseId){}
    public void createCourseInSemester(String courseId, String semesterId){}
    public void setTerm(String couseInSemesterId, Date date,char term){}
    public void deleteMemberFromCourseStaff(String CourseInSemesterId, String userId){}
    public void deleteStudent(String studentId, String couseInSemesterId){}
    public void addCourseStaff(String courseStaffId, String couseInSemesterId){}
    public void addStudenTtoCourse(String studentId, String couseInSemesterId){}

    public boolean CheckIfTermExist(String courseInSemesterId, Date date, char term){return true;}
    public Course ShowCourse(String courseId){return new Course();}
}
