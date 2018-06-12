import com.sun.glass.ui.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.sql.*;

public class GUIController {

    public TextField userName_txtfld;
    public TextField password_txtfld;
    public static User UserId;


    public void logIn(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:Mivhanet.db");

        PreparedStatement prep = conn.prepareStatement("SELECT userName FROM users WHERE userName='" + userName_txtfld.getText() + "' AND password='" + password_txtfld.getText() +"'");
        ResultSet rs = prep.executeQuery();

        if (rs.next())
        {
            Stage stage = new Stage();
            stage.setTitle("Mivhanet System");
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("MenuGUI.fxml").openStream());
            Scene scene = new Scene(root, 500, 500);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL); //Lock the window until it closes
            Stage stage2=(Stage)userName_txtfld.getScene().getWindow();
            MenuGUIController.user=userName_txtfld.getText();
            stage2.close();
            stage.show();
        }
        else
        {
            showAlertError("Invalid parmeters");
        }


    }
    private void showAlertError(String alertMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(alertMessage);
        alert.show();
    }
}
