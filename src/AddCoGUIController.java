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
    Question currQuesToAdd;


    @FXML
    public void initialize() throws SQLException {
        courses= Model.getAllCourses(MenuGUIController.user.ID);
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
                }
            }
        });

        //listener to question chooser
        questionList.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(CheckNumberOfComments())
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

    public boolean CheckNumberOfComments(){
        String questionName=questionList.getValue().toString();
        currQuesToAdd=(currCourse.getQuestionbyName(questionName));
        if(currQuesToAdd.comments.size()<10)
            return true;
        return false;
    }

    private void showQuestions() {
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
    private void showAlert(String alertMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(alertMessage);
        alert.show();
    }

    public void addComment(ActionEvent actionEvent) throws SQLException {
        if(comment_txtfld.getText().equals(""))
            showAlertError("you must write a comment!");
        else {
            currQuesToAdd.addComment(new Comment(comment_txtfld.getText().toString(), Model.addComment(currQuesToAdd.QuestionId, comment_txtfld.getText().toString())));
            showAlert("Comment added succesfully!");
        }
    }
}


