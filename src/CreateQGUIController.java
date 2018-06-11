import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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


    @FXML
    public void initialize() {
        //The system retrieves user information and courses in which it is a team member
        String[] courses=new String[50];
        for (String str:courses) {
            chooseCourse_box.getItems().add(str);
        }

    }


    public void addQuestion(ActionEvent actionEvent) {

        if(answer1_fld.getText().equals("") ||answer2_fld.getText().equals("")|| answer2_fld.getText().equals("") ){
            showAlertError("You Must add at least 2 answers");
        //ILANA KARIN The system saves the answers to the question
        String Course=chooseCourse_box.getValue().toString();
        //IK The question information is stored in the current course

        }
    }


    private void showAlertError(String alertMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(alertMessage);
        alert.show();
    }
}
