package Controller;

import View.ConnectionView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Ronan
 * 08/12/2016.
 */
public class ConnectionController implements ActionListener{

    private ConnectionView connectionView;

    public ConnectionController() {
        connectionView = new ConnectionView();

        connectionView.registerListener(this);

        connectionView.setVisible(true);
    }

    private void connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex1) {
            System.out.println("Driver not found!");
            System.exit(1);
        }
        try {
            Properties userInfo = new Properties();
            userInfo.put("user", "root");
            userInfo.put("password", "password");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/TP4?useSSL=false&allowMultiQueries=true", userInfo);

            //Création d'un objet Statement
            Statement state = connection.createStatement();

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
