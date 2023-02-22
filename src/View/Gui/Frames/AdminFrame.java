package View.Gui.Frames;

import Model.Banque;
import Model.User;
import View.Gui.Panels.AdminPanel;
import View.Gui.Panels.LoginPanel;

import javax.swing.*;

public class AdminFrame extends JFrame {
    public AdminFrame(Banque banque, User currentuser) {
        //complete this frame
        super("Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        AdminPanel adminPanel = new AdminPanel(banque, currentuser);
        add(adminPanel);
        setVisible(true);



    }
}
