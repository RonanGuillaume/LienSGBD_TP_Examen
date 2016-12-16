package View;

import Controller.MainController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ronan
 * on 16/12/2016.
 */
public class SignUpView extends JFrame{
    private JButton cancelButton;
    private JButton createMyAccountButton;
    private JTextField fornameField;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField addressField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JPanel mainJPanel;

    public SignUpView() {
        setContentPane(mainJPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        makeSignUpView();
    }

    private void makeSignUpView() {
        setVisible(true);

        //Minimize the frame's size and freeze the minimum size
        pack();
        setMinimumSize(getSize());

        //Set the frame on the middle screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        //set Sign In as a default button
        JRootPane rootPane = SwingUtilities.getRootPane(createMyAccountButton);
        rootPane.setDefaultButton(createMyAccountButton);
    }

    public void registerListener(MainController connectionController){
        cancelButton.addActionListener(connectionController);
        createMyAccountButton.addActionListener(connectionController);
    }
}
