package Controller;

import View.ConnectionView;
import com.mysql.jdbc.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by Ronan
 * 08/12/2016.
 */
public class ConnectionController{

    private Connection connection;

    public ConnectionController(String userBBD, String passwordBDD) {
        connectionToTheBDD(userBBD, passwordBDD);


    }

    private void connectionToTheBDD(String userBBD, String passwordBDD) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties userInfo = new Properties();
            userInfo.put("user", userBBD);
            userInfo.put("password", passwordBDD);
            // TODO: 15/12/2016 Think to change the link to your DataBase
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/jardiland?useSSL=false&allowMultiQueries=true", userInfo);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection to the BDD failed");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isSignUp(String email, String password){

        boolean testResult = false;

        try {
            Statement state = connection.createStatement();
            String query = "SELECT * FROM customer WHERE email LIKE ? and password LIKE ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet result = preparedStatement.executeQuery();
            testResult = (result.first());
            preparedStatement.close();
            state.close();

        } catch (SQLException e) {
            System.err.println("Error JDBC: "+e);
            e.printStackTrace();
        }
            return testResult;
    }
}
