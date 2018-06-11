import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class CreateQGUIController{

    public ChoiceBox chooseCourse_box;
    public TextField qustionBodt_fld;
    public TextField time_fld;
    public TextField answer1_fld;
    public TextField answer2_fld;
    public TextField answer3_fld;
    public TextField comment_fld;
    public CheckBox isTrue1;
    public CheckBox isTrue2;
    public CheckBox isTrue3;

    @FXML
    public void initialize() {
        //KARIN AND ILANA - The system retrieves user information and courses in which it is a team member
        String[] courses=new String[50];
        for (String str:courses) {
            chooseCourse_box.getItems().add(str);
        }

    }


    public void addQuestion(ActionEvent actionEvent) {
        if(answer1_fld.getText().equals("") ||answer2_fld.getText().equals("")|| answer2_fld.getText().equals("") ){
            showAlertError("You Must add at least 2 answers");

        //ILANA KARIN The system saves the answers to the question
        String courseName=chooseCourse_box.getValue().toString();

        //KARIN AND ILANA - The question information is stored in the current course - also check that at least one answer is true (checkbox)

        }
    }


    private void showAlertError(String alertMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(alertMessage);
        alert.show();
    }
}
