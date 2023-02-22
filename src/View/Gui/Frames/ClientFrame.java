package View.Gui.Frames;

import Model.Banque;
import Model.User;
import View.Gui.Panels.ClientPanel;
import View.Gui.Panels.LoginPanel;

import javax.swing.*;

public class ClientFrame extends JFrame {
    public ClientFrame(Banque banque, User currentuser) {
        super("Client");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        ClientPanel clientPanel = new ClientPanel(banque, currentuser);
        add(clientPanel);
        setVisible(true);

    }
}
