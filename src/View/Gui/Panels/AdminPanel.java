package View.Gui.Panels;

import Model.Banque;
import Model.User;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AdminPanel extends JPanel {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public AdminPanel(Banque banque, User CurrentUser) {

        // Center panel with buttons
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        centerPanel.setPreferredSize(new Dimension(300, 200));

        button1 = new JButton("Menu Transaction");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for button 1
            }
        });
        centerPanel.add(button1);

        button2 = new JButton("Menu ");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for button 2
            }
        });
        centerPanel.add(button2);

        button3 = new JButton("Button 3");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for button 3
            }
        });
        centerPanel.add(button3);

        button4 = new JButton("Button 4");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for button 4
            }
        });
        centerPanel.add(button4);

        add(centerPanel, BorderLayout.CENTER);

        // South panel with logout button
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPanel(banque);
                (SwingUtilities.getWindowAncestor(AdminPanel.this)).dispose();

            }
        });
        southPanel.add(new JLabel("Logged in as Admin"));
        southPanel.add(logoutButton);
        add(southPanel, BorderLayout.SOUTH);
    }

}
