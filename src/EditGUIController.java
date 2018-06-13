import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.HashMap;

public class EditGUIController {

    public ChoiceBox coursesList;
    public ChoiceBox questionList;
    public TextField qBody_txtfld;
    public Button save_btn;
    private HashMap<String,Integer> courses;
    private Course currentCourse;
    @FXML
    public void initialize() throws SQLException {
        //KARIN AND ILANA - find list of courses by user (saved gstatic in MenueGUIController) - into courses }


        courses= Model.getAllCourses(MenuGUIController.user.ID);
        for (String c : courses.keySet()) {
            coursesList.getItems().add(c);
        }
        //listener to course choose
        coursesList.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                try {
                    questionList.valueProperty().set("");
                    String courseName=coursesList.getValue().toString();
                    int courseId = courses.get(courseName);
                    currentCourse = Model.getCourse(courseId);
                    showQuestions();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                catch (java.lang.NullPointerException e2){}
            }
        });

        //listener to question chooser
        questionList.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                //KARIN AND ILANA - check if possible to change question
                String questionName=questionList.getValue().toString();
                if(!questionName.equals("")) {
                    Question q= currentCourse.getQuestionbyName(questionName);
                    if (q.writerId == MenuGUIController.user.ID) {
                        qBody_txtfld.setDisable(false);
                        save_btn.setDisable(false);
                    } else {
                        showAlertError("Edit Question Not Possible");
                    }
                }
            }
        });
    }

    private void showQuestions() throws SQLException {
        //KARIN AND ILANA - find list of Question by course - into questions }
        coursesList.setDisable(true);

        for (Question q : currentCourse.getCourseQuestoins()) {
            //if(q.writerId==MenuGUIController.user.ID)
                questionList.getItems().add(q.body);
        };
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

    public void saveQuestionBody(ActionEvent actionEvent) throws SQLException {
        //KARIN AND ILANA - change question in db
        String newQsBody=qBody_txtfld.getText();
        if(newQsBody.equals("")){
            showAlertError("invalid question!");
        }
        else {
            Model.updateQuestion(currentCourse.getQuestionbyName(questionList.getValue().toString()).QuestionId, newQsBody);
            showAlert("Question saved succesfully!");
        }

    }
}
