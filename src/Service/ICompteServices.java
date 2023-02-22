package Service;
import Model.Client;
import Model.Compte;

import java.util.ArrayList;
import java.util.Date;

public interface ICompteServices {
    public int getIdCompte();
    public void setIdCompte(int idCompte);
    public double getSolde();
    public void setSolde(double solde);
    public Client getProproietaire();
    public void setProproietaire(Client proproietaire);
    public Date getDateCreation();
    public void setDateCreation(Date dateCreation);
    public ArrayList<String> getJournalisation();
    public void setJournalisation(ArrayList<String> journalisation);
    public String toString();
    public boolean equals(Compte autreCompte);
}
