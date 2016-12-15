package View;

import Controller.ConnectionController;

import javax.swing.*;

/**
 * Created by Ronan
 * 08/12/2016.
 */
public class ConnectionView extends JFrame{
    private JTextField emailTextField;
    private JButton signInButton;
    private JPanel mainJPanel;
    private JPasswordField password;
    private JButton exitButton;

    public ConnectionView() {
        setContentPane(mainJPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }




    public void registerListener(ConnectionController connectionController){
        signInButton.addActionListener(connectionController);
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public JPasswordField getPassword() {
        return password;
    }
}
