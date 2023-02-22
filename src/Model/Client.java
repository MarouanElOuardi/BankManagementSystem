package Model;

import Service.IClientServices;

import java.util.ArrayList;
import java.util.Map;

public class Client extends User implements IClientServices {
    public static int compteur = 0;
    private int idClient, nbr_Comptes=0;
    private String nom, prenom, email;

    private String[] journalisation;

    private Map<Integer, Integer> NumCompte_IdCompte;
    public Client(String nom, String prenom, String email) {
        super(email, "Client123", "Client");
        this.idClient = ++compteur;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        if(!email.contains("@") || !email.contains(".")) {
            System.out.println("Email format invalide");

        }
        Compte compte = new Compte(0, this);
        this.nbr_Comptes++;
        this.journalisation = new String[nbr_Comptes];
        this.journalisation[0] = "Création du compte le: " + compte.getDateCreation() +" avec un solde de " + compte.getSolde() + "dhs";
        this.NumCompte_IdCompte = Map.of(getNbr_Comptes(),compte.getIdCompte());
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        String      clientStr  = "------------------------------------------------------\n";
        clientStr += "| Identifiant du Client     : "   + this.idClient        + "\n";
        clientStr += "| Nom Complet               : "   + this.getNomComplet() + "\n" ;
        clientStr += "| Adresse email             : "   + this.email     + "\n" ;
        clientStr += "------------------------------------------------------\n";
        return clientStr;
    }

    public boolean equals(Client autreClient) {
        if(this.nom==autreClient.nom && this.prenom==autreClient.prenom && this.email==autreClient.email) {
            return true;
        }
        else {
            return false;
        }
    }
    public String getNomComplet(){
        return this.getNom() + this.getPrenom();
    }
    public int getNbr_Comptes() {
        return nbr_Comptes;
    }
    public Map<Integer, Integer> getNumCompte_IdCompte() {
        return NumCompte_IdCompte;
    }


        public void setNbr_Comptes() {
            this.nbr_Comptes++;
        }
        public void afficherCompteClient(User u, Banque b)
        {
            for(Compte compte : b.getComptes())
            {
                if(compte.getProproietaire().equals(u))
                {
                    System.out.println(compte.toString());
                }
            }
        }

}



