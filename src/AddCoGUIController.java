import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCoGUIController {
    public ChoiceBox coursesList;
    
    @FXML
    public void initialize() {
        //coursesList.getItems().add("sss"); // Perfectly Ok here, as FXMLLoader already populated all @FXML annotated members.
        //KARIN AND ILANA - find list of courses by user (saved gstatic in MenueGUIController) - into courses }
        String[] courses = {"a"};
        coursesList.getItems().add("cc");
        for (String c : courses) {
            coursesList.getItems().add(c);
        }
    }
}


