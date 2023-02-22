package View.Gui.Frames;

import Model.Banque;
import View.Gui.Panels.LoginPanel;

import javax.swing.*;

public class LoginFrame extends JFrame {
    public LoginFrame(Banque banque) {
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        LoginPanel loginPanel = new LoginPanel(banque);
        add(loginPanel);
        setVisible(true);

    }
}
