package sample;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.sql.SQLException;

public class ControllerLogin {
    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private Label status;

    @FXML
    void login(MouseEvent event) throws SQLException, IOException {

            List<User> list =UserDB.getUsers();
            Map<String, String> map = new HashMap<String,String>();

            for (User a:list){
                map.put(a.getUsername(), a.getPassword());
            }
            if(map.containsKey(username.getText())){
                String val =map.get(username.getText());
                if(val.equals(password.getText())){
                    System.out.println(" compte correcte");
                    UserDB.getConnection();
                    Stage stage = new Stage();
                    stage.close();
                    Parent root = FXMLLoader.load(getClass().getResource("reservation.fxml"));
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();

                }else{
                    System.out.println("faux compte ou password incoo");}

            }else{
                System.out.println("faux compte");}
        }



    @FXML
    private void signup(MouseEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
