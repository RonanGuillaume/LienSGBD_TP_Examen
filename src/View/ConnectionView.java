package View;

import Controller.ConnectionController;
import Controller.MainController;

import javax.swing.*;
import java.awt.*;

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

        makeConnectionView();
    }

    private void makeConnectionView() {
        setVisible(true);

        //Set the frame on the middle screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        //Minimize the frame's size and freeze the minimum size
        pack();
        setMinimumSize(getSize());

        //set Sign In as a default button
        JRootPane rootPane = SwingUtilities.getRootPane(signInButton);
        rootPane.setDefaultButton(signInButton);




        //Action when we click on exit
        exitButton.addActionListener(e -> {
            dispose();
            System.exit(0);
        });
    }


    public void registerListener(MainController connectionController){
        signInButton.addActionListener(connectionController);
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public JPasswordField getPassword() {
        return password;
    }
}
