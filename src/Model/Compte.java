package Model;
import Service.ICompteServices;

import java.util.ArrayList;
import java.util.Date;
public class Compte implements ICompteServices {
    public static int compteur = 0;
    private int idCompte;
    private double solde;
    private Client proproietaire;
    private ArrayList<String> journalisation;
    private Date dateCreation;
    public Compte(double solde, Client proproietaire) {
        if(solde>=0) {
            this.idCompte = ++compteur;
            this.solde = solde;
            this.proproietaire = proproietaire;
            this.proproietaire.setNbr_Comptes();
            this.journalisation = new ArrayList<String>();
            this.dateCreation = new Date();
            journalisation.add("Création du compte le: " + dateCreation +" avec un solde de " + solde + "dhs");

        }
    }
    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getProproietaire() {
        return proproietaire;
    }

    public void setProproietaire(Client proproietaire) {
        this.proproietaire = proproietaire;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    public ArrayList<String> getJournalisation() {
        return journalisation;
    }

    public void setJournalisation(ArrayList<String> journalisation) {
        this.journalisation = journalisation;
    }

    public String toString() {
        String      compteStr  = "------------------------------------------------------\n";
        compteStr += "| N° de Compte            : "   + getIdCompte()   + "\n";
        compteStr += "| Solde du Compte         : "   + getSolde()    + " Dh\n" ;
        compteStr += "| Propriétaire du Compte  : "   + getProproietaire() + "\n" ;
        compteStr += "| Date de Création        : "   + getDateCreation() + "\n" ;
        compteStr += "------------------------------------------------------\n";
        return compteStr;
    }

    public boolean equals(Compte autreCompte) {
        if(this.solde==autreCompte.solde && this.proproietaire==autreCompte.proproietaire) {
            return true;
        }
        else {
            return false;
        }
    }
    public void setClient(Client client) {
        this.proproietaire = client;
    }
    public int getIdClient() {
        return this.proproietaire.getIdClient();
    }

}
