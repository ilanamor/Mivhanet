import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class AddCoGUIController {
    public ChoiceBox coursesList;
    public ChoiceBox questionList;
    public TextField comment_txtfld;
    public Button addComment_btn;
    private HashMap<String,Integer> courses;
    Course currCourse;
    List<Question> currQuestions;



    /* public void initialize() throws SQLException {
         //KARIN AND ILANA - The system retrieves user information and courses in which it is a team member - Done
         courses= Model.getAllCourses(MenuGUIController.user.ID);
         for (String str:courses.keySet()) {
             coursesList.getItems().add(str);
         }
     }*/
    @FXML
    public void initialize() throws SQLException {
        //KARIN AND ILANA - find list of courses by user (saved gstatic in MenueGUIController) - into courses }
        courses= Model.getAllCourses(MenuGUIController.user.ID);
        //String[] courses = new String[50];
        for (String c : courses.keySet()) {
            coursesList.getItems().add(c);
        }
        //listener to course choose
        coursesList.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                try {

                    showQuestions();
                } catch (Exception e) {
                    // e.printStackTrace();
                }
            }
        });

        //listener to question chooser
        questionList.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                //KARIN AND ILANA - check if possible to add comment
                String questionName=questionList.getValue().toString();
                if(currCourse.getQuestionbyName(questionName).comments.size()<10)
               // boolean posible=false;
                //if(posible)
                {
                    comment_txtfld.setDisable(false);
                    addComment_btn.setDisable(false);
                }
                else
                {
                    showAlertError("Add Comment Is Not Possible");
                }
            }
        });
    }

    private void showQuestions() {
        //KARIN AND ILANA - find list of Question by course - into questions }
        try {
            String courseName = coursesList.getValue().toString();
            int courseId = courses.get(courseName);
            currCourse = Model.getCourse(courseId);
            currQuestions = currCourse.getCourseQuestoins();
            coursesList.setDisable(true);
            for (Question q : currQuestions) {
                questionList.getItems().add(q.body);
            }
        } catch (Exception e) {}
    }

    private void showAlertError(String alertMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(alertMessage);
        alert.show();
    }

    public void addComment(ActionEvent actionEvent) {
        //KARIN AND ILANA - Crate comment and save in data base
    }
}


