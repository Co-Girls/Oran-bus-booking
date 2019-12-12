package sample;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerSignUp {
    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    void login(MouseEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }


    @FXML

    public void insertUser(ActionEvent e) throws IOException, Exception{

        String usern = username.getText();
        String pass = password.getText();

        User user = new User();
        user.setUsername(usern);
        user.setPassword(pass);

       UserDB.insertUser(user);




    }
}