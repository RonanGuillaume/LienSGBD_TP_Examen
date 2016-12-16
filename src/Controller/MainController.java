package Controller;

import DAO.AbstractDAO;
import DAO.CustomerDAO;
import DAO.OrderDAO;
import DAO.ProductDAO;
import View.ConnectionView;
import View.OrderView;
import View.SignUpView;
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
    private OrderView orderView;
    private SignUpView signUpView;

    private CustomerDAO customerDAO;
    private OrderDAO orderDAO;
    private ProductDAO productDAO;

    public MainController(String userBBD, String passwordBDD) {
        connectionController = new ConnectionController(userBBD, passwordBDD);
        connectionView = new ConnectionView();
        connectionView.registerListener(this);
        customerDAO = new CustomerDAO(connectionController.getConnection());
        orderDAO = new OrderDAO(connectionController.getConnection());
        productDAO = new ProductDAO(connectionController.getConnection());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Sign out":
                signOut();
                break;
            case "Validate":
                break;
            case "Sign in" :
                signIn();
                break;
            case "Sign up" :
                signUp();
                break;
            case "Cancel" :
                cancel();
            case "Create my account" :
                createAccount();
                break;
            default:
                System.err.println("Wrong Command");
                exit(1);
        }
    }

    private void createAccount() {
        
    }

    private void cancel() {
        signUpView.setVisible(false);
        connectionView.getEmailTextField().setText("");
        connectionView.getPassword().setText("");
        connectionView.setVisible(true);
    }

    private void signUp() {
        connectionView.setVisible(false);
        signUpView = new SignUpView();
        signUpView.registerListener(this);
    }

    private void signOut() {
        orderView.setVisible(false);
        connectionView.getPassword().setText("");
        connectionView.getEmailTextField().setText("");
        connectionView.setVisible(true);
    }

    private void signIn() {

            String email = connectionView.getEmailTextField().getText();
            String password = new String(connectionView.getPassword().getPassword());

            if(connectionController.isSignUp(email, password)) {
                connectionView.setVisible(false);
                orderView = new OrderView();
                orderView.registerListener(this);
            }
            else{
                connectionView.getPassword().setText("");
                JOptionPane.showMessageDialog(connectionView,
                        "Sorry, incorrect username or password...",
                        "Connection failed",
                        JOptionPane.ERROR_MESSAGE);
            }
    }
}
