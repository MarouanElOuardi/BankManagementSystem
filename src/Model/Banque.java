package Model;
import java.util.ArrayList;
public class Banque {
    public static int compteur = 0;
    private int idBanque;
    private int maxComptes=10, maxClients=10;
    private String nomAgence, emailAgence;
    private ArrayList<Client> clients;
    private ArrayList<Compte> comptes;
    public Banque(String nomAgence, String emailAgence) {
        this.idBanque = ++compteur;
        this.nomAgence = nomAgence;
        this.emailAgence = emailAgence;
        if(!emailAgence.contains("@") || !emailAgence.contains(".")) {
            System.out.println("Email format invalide");
            return;
        }
        this.clients = new ArrayList<Client>();
        this.comptes = new ArrayList<Compte>();
    }

    public int getIdBanque() {
        return idBanque;
    }

    public void setIdBanque(int idBanque) {
        this.idBanque = idBanque;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public String getEmailAgence() {
        return emailAgence;
    }

    public void setEmailAgence(String emailAgence) {
        this.emailAgence = emailAgence;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public void set1client(Client client) {
        this.clients.add(client);
    }

    public  ArrayList<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(ArrayList<Compte> comptes) {
        this.comptes = comptes;
    }

    public void set1compte(Compte compte) {
        this.comptes.add(compte);
    }

    public void setMaxComptes(int maxComptes) {
        this.maxComptes = maxComptes;
    }

    public void setMaxClients(int maxClients) {
        this.maxClients = maxClients;
    }

    public int getMaxComptes() {
        return maxComptes;
    }

    public int getMaxClients() {
        return maxClients;
    }

    public String toString() {
        return "Banque: [idBanque=" + idBanque + ", nomAgence=" + nomAgence + ", emailAgence=" + emailAgence + "]";
    }

    public boolean equals(Banque autreBanque) {
        if(this.nomAgence==autreBanque.nomAgence && this.emailAgence==autreBanque.emailAgence) {
            return true;
        }
        else {
            return false;
        }
    }

    public void ajouterClient(Client client) {
        if(clients.size()<maxClients) {
            clients.add(client);
        }
        else {
            System.out.println("Impossible d'ajouter le client, la banque est pleine");
        }
    }

    public void afficherClients() {
        for(Client client : clients) {
            System.out.println(client);
        }
    }

    public Client getClientById(int idClient) {
        for(Client client: clients) {
            if(client.getIdClient()==idClient) {
                return client;
            }
        }
        return null;
    }
    public void afficherComptes() {
        for(Compte compte: comptes) {
            System.out.println((compte));
        }
    }
    public void afficherComptesClient(int idClient) {
        for(Compte compte: comptes) {
            if(compte.getIdClient()==idClient) {
                System.out.println(compte);
            }
        }
    }
    public Compte getCompteById(int idCompte) {
        for(Compte compte: comptes) {
            if(compte.getIdCompte()==idCompte) {
                System.out.println("Compte trouvé" + compte);
                return compte;
            }
        }
        return null;
    }
}
