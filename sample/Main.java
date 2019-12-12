package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.sql.*;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Login and SignUp System");
        primaryStage.getIcons().add(new Image("/img/user.png"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    static Connection con=null;
    public static void main(String[] args) {
        launch(args);


        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/obus";
            con = DriverManager.getConnection(url,"root","");
            System.out.println("connected");
        } catch(ClassNotFoundException|SQLException e){
            System.out.println("echec de se connecter a la base");
        }
    }



}
