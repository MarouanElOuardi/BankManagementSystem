package Service;
import Model.Banque;
import Model.Client;
import Model.Compte;

import java.util.Scanner;
public class ServiceBanque {
    private Banque banque;
    public ServiceBanque(Banque banque) {
        this.banque = banque;
    }
    //Service Transactionnel:
    public static boolean verser(double montant, Compte compte) {
        if (montant > 0) {
            compte.setSolde(compte.getSolde() + montant);
            compte.getJournalisation().add("Versement de " + montant + "dhs");

            return true;
        } else {
            return false;
        }
    }
    public boolean retirer(double montant, Compte compte) {
        if (montant > 0 && compte.getSolde() >= montant) {
            compte.setSolde(compte.getSolde() - montant);
            compte.getJournalisation().add("Retrait de " + montant + "dhs");
            return true;
        } else {
            return false;
        }
    }
    public boolean virement(double montant, Compte compteSrc, Compte compteDest) {
        if (montant > 0 && compteSrc.getSolde() >= montant) {
            compteSrc.setSolde(compteSrc.getSolde() - montant);
            compteDest.setSolde(compteDest.getSolde() + montant);
            compteSrc.getJournalisation().add("Virement de " + montant + "dhs vers le compte " + compteDest.getIdCompte());
            compteSrc.getJournalisation().add("Virement de " + montant + "dhs depuis le compte " + compteDest.getIdCompte());
            return true;
        } else {
            return false;
        }
    }
    //Service CRUD:
    public boolean creeEtAjouterClient() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du client: ");
        String nom = clavier.nextLine();
        System.out.println("Veuillez saisir le prenom du client: ");
        String prenom = clavier.nextLine();
        System.out.println("Veuillez saisir l'adresse du client: ");
        String adresse = clavier.nextLine();

        Client nouveauClient = new Client(nom, prenom, adresse);

        if (banque.getClients().contains(nouveauClient)) {
            System.out.println("Ce client existe déjà!");
            return false;
        } else {
            banque.getClients().add(nouveauClient);
            System.out.println("Client ajouté avec succès!");
            return true;
        }
    }
    public boolean creeEtAjouterCompte() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Compte est-il pour un client existant? (y/n)");
        String reponse = clavier.nextLine();
        if (reponse.equalsIgnoreCase("y")) {
            System.out.println("Veuillez saisir l'identifiant du client: ");
            int idClient = clavier.nextInt();
            Client client = banque.getClientById(idClient);
            if (client == null) {
                System.out.println("Ce client n'existe pas!");
                return false;
            }
            else
            {
                System.out.println("Veuillez saisir le solde du compte: ");
                double solde = clavier.nextDouble();
                Compte nouveauCompte = new Compte(solde, client);
                if (banque.getComptes().contains(nouveauCompte)) {
                    System.out.println("Ce compte existe déjà!");
                    return false;
                } else {
                    banque.getComptes().add(nouveauCompte);
                    System.out.println("Compte ajouté avec succès!");
                    return true;
                }
            }
        } else {
            System.out.println("Veuillez saisir le nom du client: ");
            String nom = clavier.nextLine();
            System.out.println("Veuillez saisir le prenom du client: ");
            String prenom = clavier.nextLine();
            System.out.println("Veuillez saisir l'adresse du client: ");
            String adresse = clavier.nextLine();
            Client nouveauClient = new Client(nom, prenom, adresse);
            if (banque.getClients().contains(nouveauClient)) {
                System.out.println("Ce client existe déjà!");
                return false;
            } else {
                banque.getClients().add(nouveauClient);
                System.out.println("Veuillez saisir le solde du compte: ");
                double solde = clavier.nextDouble();
                Compte nouveauCompte = new Compte(solde, nouveauClient);
                if (banque.getComptes().contains(nouveauCompte)) {
                    System.out.println("Ce compte existe déjà!");
                    return false;
                } else {
                    banque.getComptes().add(nouveauCompte);
                    System.out.println("Compte ajouté avec succès!");
                    return true;
                }
            }
        }

    }
    public String toString() {
        return "ServiceBanque [banque=" + banque + "]";
    }
    public void afficherClients() {
        for (Client client : banque.getClients()) {
            System.out.println(client);
        }
    }
    public void afficherComptes() {
        for (Compte compte : banque.getComptes()) {
            System.out.println(compte);
        }
    }


    public boolean lierCompteAuClient(int idClient, int idCompte) {
        Client client = banque.getClientById(idClient);
        Compte compte = banque.getCompteById(idCompte);
        if (client == null) {
            System.out.println("Ce client n'existe pas!");
            return false;
        } else if (compte == null) {
            System.out.println("Ce compte n'existe pas!");
            return false;
        } else {
            compte.setClient(client);
            System.out.println("Le compte " + compte.getIdCompte() + " est maintenant lié au client " + client.getIdClient());
            return true;
        }
    }
    public Compte chercherCompte(Scanner clavier) {
        System.out.println("Veuillez saisir l'identifiant du compte: ");
        int idCompte = clavier.nextInt();
        clavier.nextLine();
        Compte compte = banque.getCompteById(idCompte);
        if (compte == null) {
            System.out.println("Ce compte n'existe pas!");
            return null;
        } else {
            return compte;
        }
    }
    public Client chercherClient(Scanner clavier) {
        System.out.println("Veuillez saisir l'identifiant du client: ");
        int idClient = clavier.nextInt();
        clavier.nextLine();
        Client client = banque.getClientById(idClient);
        if (client == null) {
            System.out.println("Ce client n'existe pas!");
            return null;
        } else {
            return client;
        }
    }
    public void consulterDetailsCompte(Scanner clavier) {
        Compte compte = chercherCompte(clavier);
        if (compte != null) {
            System.out.println(compte);
        }
    }
    public void consulterDetailsClient(Scanner clavier) {
        Client client = chercherClient(clavier);
        if (client != null) {
            System.out.println(client);
        }
    }
    public boolean modifierCompte(Scanner clavier) {
        Compte compte = chercherCompte(clavier);
        if (compte != null) {
            System.out.println("Veuillez saisir le nouveau solde du compte: ");
            double solde = clavier.nextDouble();
            clavier.nextLine();
            compte.setSolde(solde);
            System.out.println("Le solde du compte " + compte.getIdCompte() + " a été modifié avec succès!");
            return true;
        } else {
            return false;
        }
    }
    public boolean modifierClient(Scanner clavier) {
        Client client = chercherClient(clavier);
        if (client != null) {
            System.out.println("Veuillez saisir le nouveau nom du client: ");
            String nom = clavier.nextLine();
            System.out.println("Veuillez saisir le nouveau prenom du client: ");
            String prenom = clavier.nextLine();
            System.out.println("Veuillez saisir la nouvelle adresse du client: ");
            String adresse = clavier.nextLine();
            client.setNom(nom);
            client.setPrenom(prenom);
            client.setEmail(adresse);
            System.out.println("Les informations du client " + client.getIdClient() + " ont été modifiées avec succès!");
            return true;
        } else {
            return false;
        }
    }
    public boolean supprimerCompte(Scanner clavier) {
        Compte compte = chercherCompte(clavier);
        if (compte != null) {
            banque.getComptes().remove(compte);
            System.out.println("Le compte " + compte.getIdCompte() + " a été supprimé avec succès!");
            return true;
        } else {
            return false;
        }
    }
    public boolean supprimerClient(Scanner clavier) {
        Client client = chercherClient(clavier);
        if (client != null) {
            banque.getClients().remove(client);
            System.out.println("Le client " + client.getIdClient() + " a été supprimé avec succès!");
            return true;
        } else {
            return false;
        }
    }
    //Service ++ :
    public void consulterInformationsBanque() {

        System.out.println("La banque " + banque.getNomAgence() + " a " + banque.getClients().size() + " clients et " + banque.getComptes().size() + " comptes.");
    }
    public void listerClientsDeLaBanque() {
        System.out.println("Liste des clients de la banque " + banque.getNomAgence() + " :");
        for (Client client : banque.getClients()) {
            System.out.println(client);
        }
    }
   public double calculerSoldeTotalClient(Client client)
   {
         double soldeTotal = 0;
       for(Compte compte : banque.getComptes())
       {
           if(compte.getProproietaire().equals(client))
           {
               soldeTotal += compte.getSolde();
           }
       }
       return soldeTotal;
   }
}



