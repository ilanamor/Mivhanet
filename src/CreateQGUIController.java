import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class CreateQGUIController{

    public ChoiceBox chooseCourse_box;
    public TextField qustionBodt_fld;
    public TextField time_fld;
    public TextField answer1_fld;
    public TextField answer2_fld;
    public TextField answer3_fld;
    public TextField level_fld;
    public CheckBox isTrue1;
    public CheckBox isTrue2;
    public CheckBox isTrue3;
    private HashMap<String,Integer> courses;

    @FXML
    public void initialize() throws SQLException {
        //KARIN AND ILANA - The system retrieves user information and courses in which it is a team member - Done
        courses= Model.getAllCourses(MenuGUIController.user.ID);
        for (String str:courses.keySet()) {
            chooseCourse_box.getItems().add(str);
        }
    }

    public void addQuestion(ActionEvent actionEvent) throws SQLException {
        if(chooseCourse_box==null || qustionBodt_fld.getText().equals("") || time_fld.getText().equals("") || level_fld.getText().equals("")) {
            showAlertError("You must fill all fields");
            return;
        }

        if((answer1_fld.getText().equals("") && answer2_fld.getText().equals("")) || (answer2_fld.getText().equals("")&&answer3_fld.getText().equals("")) || (answer1_fld.getText().equals("")&& answer3_fld.getText().equals("")) ) {
            showAlertError("You must add at least 2 answers");
            return;
        }
        //ILANA KARIN The system saves the answers to the question
        String courseName=chooseCourse_box.getValue().toString();
        int courseId=courses.get(courseName);
        int quesId=Model.addQuestion(courseId, Integer.parseInt(time_fld.getText()),qustionBodt_fld.getText(), Integer.parseInt(level_fld.getText()) );

        //KARIN AND ILANA - The question information is stored in the current course - also check that at least one answer is true (checkbox)
        if(!isTrue1.isSelected() && !isTrue2.isSelected() && !isTrue3.isSelected() ){
            showAlertError("You must add at least 1 correct answer");
            return;
        }

        if(answer3_fld.getText().equals("")){
            String[] answers={answer1_fld.getText(),answer2_fld.getText()};
            boolean[] isTrue ={isTrue1.isSelected(),isTrue2.isSelected()};
            Model.addAnswers(quesId,answers,isTrue);
        }
        else{
            String[] answers={answer1_fld.getText(),answer2_fld.getText(),answer3_fld.getText()};
            boolean[] isTrue ={isTrue1.isSelected(),isTrue2.isSelected(),isTrue3.isSelected()};
            Model.addAnswers(quesId,answers,isTrue);
        }

    }


    private void showAlertError(String alertMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(alertMessage);
        alert.show();
    }
}
