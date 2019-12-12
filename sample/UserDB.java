package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fatima on 12/12/19.
 */
public class UserDB {
    static Connection con=null;

    public static Connection getConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/obus";
            con = DriverManager.getConnection(url,"root","");
            // System.out.println("connected");
        } catch(ClassNotFoundException|SQLException e){
            //  System.out.println("echec de se connecter a la base");
        }
        return con;
    }
    public static List<User> getUsers() throws SQLException{
        List<User> list= new ArrayList<User>();
        try{
            String sql= "SELECT * FROM `users` WHERE 1";
            //connection
            Connection con = UserDB.getConnection();
            //execute les cmd
            PreparedStatement preparedStatement= (PreparedStatement)con.prepareStatement(sql);
            //retourne les résultat du prepared
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                User users = new User();
                users.setId(resultSet.getInt(1));
                users.setUsername(resultSet.getString(2));
                users.setPassword(resultSet.getString(3));
                list.add(users);
            }
            con.close();


        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }


    public static int insertUser(User user) throws SQLException, Exception{
        int s =0;

        try{

            String sql =" INSERT INTO `users` (`username`, `password`) VALUES (?,?)";
            Connection con =UserDB.getConnection();
            PreparedStatement stm = (PreparedStatement)con.prepareStatement(sql);
            stm.setString(1, user.getUsername());
            stm.setString(2, user.getPassword());
            s=stm.executeUpdate();

            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return s;
    }

}
