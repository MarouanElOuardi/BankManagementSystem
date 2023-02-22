package View.Gui.Panels;

import Controller.Auth;
import Model.Banque;
import Model.User;
import View.Gui.Frames.AdminFrame;
import View.Gui.Frames.ClientFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginPanel(Banque banque) {
        setLayout(new BorderLayout());

        // North panel with logo
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        northPanel.setPreferredSize(new Dimension(100, 200));

        // set image dimensions to 100 200
        ImageIcon logo = new ImageIcon("src/View/Gui/Images/logo.png");
        Image img = logo.getImage();
        Image newImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon newLogo = new ImageIcon(newImg);
        JLabel logoLabel = new JLabel(newLogo);


        northPanel.add(logoLabel);
        add(northPanel, BorderLayout.NORTH);

        // Center panel with email and password fields
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setPreferredSize(new Dimension(300, 80));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        // Email field
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 12));
        c.gridx = 0;
        c.gridy = 0;
        centerPanel.add(emailLabel, c);

        emailField = new JTextField();
        emailField.setText("elmarouanelouardi@gmail.com");
        emailField.setPreferredSize(new Dimension(200, 25));
        c.gridx = 1;
        c.gridy = 0;
        centerPanel.add(emailField, c);

        // Password field
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 12));
        c.gridx = 0;
        c.gridy = 1;
        centerPanel.add(passwordLabel, c);

        passwordField = new JPasswordField();
        passwordField.setText("Client123");
        passwordField.setPreferredSize(new Dimension(200, 25));
        passwordField.setEchoChar('*');

        c.gridx = 1;
        c.gridy = 1;
        centerPanel.add(passwordField, c);

        add(centerPanel, BorderLayout.CENTER);

        // South panel with login button
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setPreferredSize(new Dimension(0, 50));
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                Auth auth = new Auth(banque);
                User currentuser = auth.authenticate(email, password);
                if (currentuser != null) {
                    if (currentuser instanceof Model.Admin) {
                        new AdminFrame(banque, currentuser);
                        (SwingUtilities.getWindowAncestor(LoginPanel.this)).dispose();

                    } else {
                        new ClientFrame(banque, currentuser);
                        (SwingUtilities.getWindowAncestor(LoginPanel.this)).dispose();

                    }
                }
            }
        });
        southPanel.add(loginButton);
        add(southPanel, BorderLayout.SOUTH);

    }
}
