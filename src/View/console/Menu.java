package View.console;

import Model.Client;
import Model.User;


public class Menu {
    public static int choix;

    public static void afficherMenuGeneral(User onlineUser) {
        System.out.println("----------------------------------------------");
        System.out.println("|     Bienvenu dans Votre Banque Fidele      |");
        System.out.println("----------------------------------------------");
        System.out.println("| Admin    : " + onlineUser.getUsername()+ " |");
        System.out.println("----------------------------------------------");
        System.out.println("1. Pour Acceder au Service Transactionnelle  |");
        System.out.println("2. Pour Acceder au Service de Gestion        |");
        System.out.println("3. Pour Acceder au Service ++                |");
        System.out.println("4. Pour se Deconnecter");
        System.out.println("0. Quitter                                   |");
        System.out.println("----------------------------------------------");
        System.out.println("Choix: ");
    }
    public static void afficherMenuTransactionelle(User onlineUser) {
        System.out.println("----------------------------------------------");
        System.out.println("|         Service de Transactionelle         |");
        System.out.println("----------------------------------------------");
        System.out.println("| Nom de " + onlineUser.getRole());
        System.out.println("| Nombre de Comptes: " + ((Client)onlineUser).getNbr_Comptes()+ " |");
        System.out.println("----------------------------------------------");
        System.out.println("1. Pour Verser de l'argent                   |");
        System.out.println("2. Pour Retirer de l'argent                  |");
        System.out.println("3. Pour Effectuer un Virement                |");
        System.out.println("4. Pour Afficher le(s) compte(s)               |");
        System.out.println("5. Pour Afficher votre information           |");
        System.out.println("6. Retour au Menu General                    |");
        System.out.println("0. Quitter                                   |");
        System.out.println("----------------------------------------------");
        System.out.println("Choix: ");

    }
    public static void afficherMenuServiceGestion() {
        System.out.println("-------------------------------------------------------------|");
        System.out.println("|                    Service de Gestion                      |");
        System.out.println("-------------------------------------------------------------|");
        System.out.println("           CLIENTS           |             COMPTES           |");
        System.out.println("-------------------------------------------------------------|");
        System.out.println("1. Pour Ajouter un Client    |  5. Pour Ajouter un Compte    |");
        System.out.println("2. Pour Supprimer un Client  |  6. Pour Supprimer un Compte  |");
        System.out.println("3. Pour Modifier un Client   |  7. Pour Modifier un Compte   |");
        System.out.println("4. Pour Afficher les Clients |  8. Pour Afficher les Comptes |");
        System.out.println("-------------------------------------------------------------|");
        System.out.println("               9. Pour Revenir au Menu General               |");
        System.out.println("               0. Quitter                                    |");
        System.out.println("-------------------------------------------------------------|");
        System.out.println("Choix: ");

    }
    public static void afficherMenuServicePlus() {
        System.out.println("------------------------------------------------|");
        System.out.println("|                  Service++                    |");
        System.out.println("------------------------------------------------|");
        System.out.println("1. Pour Consulter les informations de la banque |");
        System.out.println("2. Pour Lister les Clients de la banque         |");
        System.out.println("3. Pour Revenir au Menu General                 |");
        System.out.println("0. Quitter                                      |");
        System.out.println("------------------------------------------------|");
        System.out.println("Choix: ");
    }
    public static void afficherMenuLogin()
    {
        System.out.println("------------------------------------------------|");
        System.out.println("|                  Login                        |");
        System.out.println("------------------------------------------------|");
        System.out.println("|                                               |");
        System.out.println("|                 se connecter                  |");
        System.out.println("|                                               |");
        System.out.println("------------------------------------------------|");
    }


}