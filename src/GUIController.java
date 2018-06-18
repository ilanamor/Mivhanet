import com.sun.glass.ui.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.sql.*;

public class GUIController {

    public TextField userName_txtfld;
    public PasswordField password_txtfld;

    public void logIn(ActionEvent actionEvent) {
        try {
            if (userName_txtfld.getText() == "" || password_txtfld.getText() == "") {
                showAlertError("Invalid parmeters");
                return;
            }

            Model.connectToDB();
            User user = Model.Login(userName_txtfld.getText(), password_txtfld.getText());
            Stage stage = new Stage();
            stage.setTitle("Mivhanet System");
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("MenuGUI.fxml").openStream());
            Scene scene = new Scene(root, 500, 500);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
            Stage stage2 = (Stage) userName_txtfld.getScene().getWindow();
            MenuGUIController.user = user;
            stage2.close();
            stage.show();

        }
        catch (Exception e){
            showAlertError("Invalid parmeters");
            return;
        }

    }
    private void showAlertError(String alertMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(alertMessage);
        alert.show();
    }
}
