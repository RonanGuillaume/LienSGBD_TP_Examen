package Controller;

import View.ConnectionView;
import com.mysql.jdbc.Connection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.System.exit;

/**
 * Created by Ronan
 * 08/12/2016.
 */
public class MainController implements ActionListener{

    private ConnectionController connectionController;

    private ConnectionView connectionView;

    public MainController(String userBBD, String passwordBDD) {
        connectionController = new ConnectionController(userBBD, passwordBDD);
        connectionView = new ConnectionView();
        connectionView.registerListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Disconnect":
                break;
            case "Add":
                break;
            case "Validate":
                break;
            case "Sign in" :
                signIn();
                break;
            default:
                System.err.println("Wrong Command");
                exit(1);
        }
    }

    private void signIn() {

            String email = connectionView.getEmailTextField().getText();
            String password = new String(connectionView.getPassword().getPassword());

            if(connectionController.isSignUp(email, password)) {
                System.out.println("Connected");
            }
            else{
                JOptionPane.showMessageDialog(connectionView,
                        "Sorry, incorrect username or password...",
                        "Connection failed",
                        JOptionPane.ERROR_MESSAGE);
            }
    }
}
