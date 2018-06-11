import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class EditGUIController {

    public ChoiceBox coursesList;
    public ChoiceBox questionList;
    public TextField qBody_txtfld;
    public Button save_btn;

    @FXML
    public void initialize() {
        //KARIN AND ILANA - find list of courses by user (saved gstatic in MenueGUIController) - into courses }

        String[] courses = new String[50];
        for (String c : courses) {
            coursesList.getItems().add(c);
        }
        //listener to course choose
        coursesList.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                showQuestions();
            }
        });

        //listener to question chooser
        questionList.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                //KARIN AND ILANA - check if possible to change question
                String questionName=questionList.getValue().toString();
                boolean posible=true;
                if(posible)
                {
                    qBody_txtfld.setDisable(false);
                    save_btn.setDisable(false);
                }
                else
                {
                    showAlertError("Edit Question Not Possible");
                }
            }
        });
    }

    private void showQuestions() {
        //KARIN AND ILANA - find list of Question by course - into questions }
        String courseName=coursesList.getValue().toString();
        String[] questions = new String[50];
        for (String q : questions) {
            questionList.getItems().add(q);
        }
    }

    private void showAlertError(String alertMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(alertMessage);
        alert.show();
    }

    public void saveQuestionBody(ActionEvent actionEvent) {
        //KARIN AND ILANA - change question in db
        String newQsBody=qBody_txtfld.getText();
    }
}
