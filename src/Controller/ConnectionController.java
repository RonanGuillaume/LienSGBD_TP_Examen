package Controller;

import View.ConnectionView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.*;


/**
 * Created by Ronan
 * 08/12/2016.
 */
public class ConnectionController implements ActionListener{

    private Connection connection;

    private ConnectionView connectionView;

    public ConnectionController(String userBBD, String passwordBDD) {
        connectionToTheBDD(userBBD, passwordBDD);

        connectionView = new ConnectionView();

        connectionView.registerListener(this);

        connectionView.setVisible(true);
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

    // TODO: 15/12/2016 Move to a ViewController
    private void connection(){

            //Création d'un objet Statement
        Statement state = null;
        try {
            state = connection.createStatement();
            String email = connectionView.getEmailTextField().getText();
            String password = new String(connectionView.getPassword().getPassword());

            String query = "SELECT * FROM user WHERE EmailUser LIKE ? and PasswordUser LIKE ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                System.out.println("Email User :"  + result.getString("EmailUser") +
                        "\n\t Password :" + result.getString("PasswordUser")
                );
            }

            preparedStatement.close();
            state.close();

        } catch (SQLException ex2) {
            System.out.println("Error JDBC: "+ex2);
            System.exit(1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Sign in" :
                connection();
                break;
        }
    }
}
