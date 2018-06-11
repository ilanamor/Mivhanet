import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class MenuGUIController {

    public Button createQuestion_btn;
    public static String user;

    public void createQuestion(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();
        stage.setTitle("Create Question");
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("CreateQGUI.fxml").openStream());
        Scene scene = new Scene(root, 700, 470);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
        Stage stage2=(Stage)createQuestion_btn.getScene().getWindow();
        stage2.close();
        stage.show();

    }

    public void editQuestion(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Edit Question");
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("EditGUI.fxml").openStream());
        Scene scene = new Scene(root, 700, 470);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
        Stage stage2=(Stage)createQuestion_btn.getScene().getWindow();
        stage2.close();
        stage.show();
    }

    public void addCommentToQuestion(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Add Comment To Question");
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("AddCoGUI.fxml").openStream());
        Scene scene = new Scene(root, 700, 470);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
        Stage stage2=(Stage)createQuestion_btn.getScene().getWindow();
        stage2.close();
        stage.show();
    }
}
