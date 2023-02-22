package View.Gui.Panels;

import Dao.DbFile;
import Model.Banque;
import Model.Compte;
import Model.User;
import Service.ServiceBanque;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.html.Option;

public class ClientPanel extends JPanel {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public ClientPanel(Banque banque, User CurrentUser) {



        // Center panel with buttons
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        centerPanel.setPreferredSize(new Dimension(300, 200));

        button1 = new JButton("Verser");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Compte> listeComptes = banque.getComptes();
                JComboBox<String> comptesComboBox = new JComboBox<>();
                for (int i = 0; i < listeComptes.size(); i++) {
                    comptesComboBox.addItem(String.valueOf(listeComptes.get(i).getIdCompte()));
                }
                JTextField montantField = new JTextField();

                Object[] message = {
                        "Compte :", comptesComboBox,
                        "Montant :", montantField
                };

                int option = JOptionPane.showConfirmDialog(null, message,
                        "Retrait d'argent", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    int idCompte = Integer.parseInt(comptesComboBox.getSelectedItem().toString());
                    Compte compte = banque.getCompteById(idCompte);
                    Double montant = Double.parseDouble(montantField.getText());
                    ServiceBanque.verser(montant, compte);

                    if (montant <= 0)
                        throw new IllegalArgumentException("Le montant doit être > à 0");
                    if (compte == null)
                        throw new IllegalArgumentException("Le compte n'existe pas");
                    if (compte.getSolde() < montant)
                        throw new IllegalArgumentException("Le solde du compte est insuffisant");
                    try {
                        DbFile.save(banque);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        centerPanel.add(button1);

        button2 = new JButton("Retirer");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for button 2
                
            }
        });
        centerPanel.add(button2);

        button3 = new JButton("Virement");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action for button 3
            }
        });
        centerPanel.add(button3);

        button4 = new JButton("Consulter");
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
                (SwingUtilities.getWindowAncestor(ClientPanel.this)).dispose();


            }
        });
        southPanel.add(new JLabel("Logged in as Client"));
        southPanel.add(logoutButton);
        add(southPanel, BorderLayout.SOUTH);
    }

}
